package com.manage.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

// Daoの実装クラス。
// sql文を発行し、リストに詰める為のRowMapperを用意する。
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

  // dbから得たデータを、RowMapperを用いてリストに格納し、返す。
  // 例外が発生した場合は、元のメソッドに例外処理を移譲する。
  public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {
    
    // sql文の結果を、RowMapperオブジェクトの形で返す。
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

    private List<BooksJoinLendingsAndUsers> bookList = new ArrayList<BooksJoinLendingsAndUsers>();

    // 戻り値としてリスト型で結果を返す。
    public List<BooksJoinLendingsAndUsers> getResults() {
      return bookList;
    }

    // dbから得たデータ(ResultSet型)を、BooksJoinLendingsAndUsers型インスタンスにそれぞれ格納し、返す。
    public BooksJoinLendingsAndUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
      BooksJoinLendingsAndUsers viewObj = new BooksJoinLendingsAndUsers();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setUserName(rs.getString("user_name"));
      return viewObj;
    }
  }
}