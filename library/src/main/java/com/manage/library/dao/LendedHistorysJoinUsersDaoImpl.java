package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;
import com.manage.library.LendedHistorysJoinUsers;
import com.manage.library.Users;

public class LendedHistorysJoinUsersDaoImpl extends JdbcDaoSupport implements LendedHistorysJoinUsersDao {


  public List<LendedHistorysJoinUsers> findAll() throws DataAccessException {

    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys inner join users on borrow_user_id = user_id;",
        rowMapper);
  }

  public List<LendedHistorysJoinUsers> findFromId(int id) {
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from lended_historys inner join users on borrow_user_id = user_id where book_id=" + id + ";",
        rowMapper);
  }

  protected class HomeListRowMapper implements RowMapper<LendedHistorysJoinUsers> {

    private List<LendedHistorysJoinUsers> bookList = new ArrayList<LendedHistorysJoinUsers>();

    public List<LendedHistorysJoinUsers> getResults() {
      return bookList;
    }

    public LendedHistorysJoinUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
      LendedHistorysJoinUsers viewObj = new LendedHistorysJoinUsers();
      LendedHistorys lendedHistorys = new LendedHistorys();
      Users users = new Users();

      lendedHistorys.setHistoryId(rs.getInt("history_id"));
      lendedHistorys.setBookId(rs.getInt("book_id"));
      lendedHistorys.setLendedAt(rs.getTimestamp("lended_at"));
      lendedHistorys.setReturnedAt(rs.getTimestamp("returned_at"));
      lendedHistorys.setBorrowUserId(rs.getInt("borrow_user_id"));
      users.setUserId(rs.getInt("user_id"));
      users.setUserName(rs.getString("user_name"));

      viewObj.setLendedHistorys(lendedHistorys);
      viewObj.setUsers(users);
      return viewObj;
    }
  }

}