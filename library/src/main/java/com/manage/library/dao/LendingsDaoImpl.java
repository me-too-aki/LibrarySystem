package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Lendings;

public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  public List<Lendings> findAll() throws DataAccessException {

    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  public List<Lendings> findFromId(int id) {
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    private List<Lendings> LendingsList = new ArrayList<Lendings>();

    public List<Lendings> getResults() {
      return LendingsList;
    }

    public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
      Lendings viewObj = new Lendings();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      return viewObj;
    }
  }

}