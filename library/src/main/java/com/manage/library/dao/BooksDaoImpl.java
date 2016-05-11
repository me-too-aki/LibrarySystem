package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Books;

public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  public List<Books> findAll() throws DataAccessException {

    RowMapper<Books> rowMapper = new BooksListRowMapper();
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

  public Books findFromBookId(int id) {
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  protected class BooksListRowMapper implements RowMapper<Books> {

    private List<Books> bookList = new ArrayList<Books>();

    public List<Books> getResults() {
      return bookList;
    }

    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
      Books viewObj = new Books();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setWritterName(rs.getString("writter_name"));
      viewObj.setPublisher(rs.getString("publisher"));
      viewObj.setPublishedAt(rs.getDate("published_at"));
      viewObj.setOwnerUserId(rs.getInt("owner_user_id"));
      viewObj.setRegisteredAt(rs.getTimestamp("registered_at"));
      return viewObj;
    }
  }
}