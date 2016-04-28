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
public class HomeDaoImpl extends JdbcDaoSupport implements HomeDao {

  // dbから得たデータを、RowMapperを用いてリストに格納し、返す。
  // 例外が発生した場合は、元のメソッドに例外処理を移譲する。
  public List<Home> findAll() throws DataAccessException {
    
    // sql文の結果を、RowMapperオブジェクトの形で返す。
    RowMapper<Home> rowMapper = new HomeRowMapper();
    return getJdbcTemplate().query(
        "select * from books inner join users on owner_user_id = user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  protected class HomeRowMapper implements RowMapper<Home> {

    private List<Home> bookList = new ArrayList<Home>();

    // 戻り値としてリスト型で結果を返す。
    public List<Home> getResults() {
      return bookList;
    }

    // dbから得たデータ(ResultSet型)を、Home型インスタンスにそれぞれ格納し、返す。
    public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
      Home home = new Home();
      home.setBookId(rs.getInt("book_id"));
      home.setBookTitle(rs.getString("book_title"));
      home.setLendingStatus(rs.getBoolean("lending_status"));
      home.setLendedAt(rs.getTimestamp("lended_at"));
      home.setDueDate(rs.getDate("due_date"));
      home.setUserName(rs.getString("user_id"));
      return home;
    }
  }
}