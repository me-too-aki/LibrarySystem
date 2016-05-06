package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Books;
import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.Lendings;
import com.manage.library.Users;

// Daoの実装クラス。
// sql文を発行し、リストに詰める為のRowMapperを用意する。
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

  // dbから得たデータを、RowMapperを用いてリストに格納し、返す。
  // 例外が発生した場合は、元のメソッドに例外処理を移譲する。
  // joinしたテーブルからデータを全て拾ってくるメソッド。
  public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {
    // sql文の結果を、RowMapperオブジェクトの形で返す。
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  // joinしたテーブルから、対応するデータを拾ってくるメソッド
  public List<BooksJoinLendingsAndUsers> findFromId(int id) {
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
            + id + ";",
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

      Books books = new Books();
      Lendings lendings = new Lendings();
      Users users = new Users();

      books.setBookId(rs.getInt("books.book_id"));
      books.setBookTitle(rs.getString("books.book_title"));
      books.setWritterName(rs.getString("books.writter_name"));
      books.setPublisher(rs.getString("books.publisher"));
      books.setPublishedAt(rs.getDate("books.published_at"));
      books.setOwnerUserId(rs.getInt("books.owner_user_id"));
      books.setRegisteredAt(rs.getTimestamp("books.registered_at"));
      lendings.setBookId(rs.getInt("lendings.book_id"));
      lendings.setLendingStatus(rs.getBoolean("lendings.lending_status"));
      lendings.setLendedAt(rs.getTimestamp("lendings.lended_at"));
      lendings.setDueDate(rs.getDate("lendings.due_date"));
      lendings.setBorrowUserId(rs.getInt("lendings.borrow_user_id"));
      users.setUserId(rs.getInt("users.user_id"));
      users.setUserName(rs.getString("users.user_name"));

      viewObj.setBooks(books);
      viewObj.setLendings(lendings);
      viewObj.setUsers(users);
      return viewObj;
    }
  }

}