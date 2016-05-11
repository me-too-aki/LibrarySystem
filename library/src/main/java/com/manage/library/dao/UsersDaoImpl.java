package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

  public List<Users> findAll() throws DataAccessException {

    RowMapper<Users> rowMapper = new UsersListRowMapper();
    return getJdbcTemplate().query("select * from users;", rowMapper);
  }

  public String findUserNameFromUserId(int userId) {
    if (userId != 0) {
      return getJdbcTemplate().queryForObject("select user_name from users where user_id=" + userId + ";",
          String.class);
    } else {
      return "";
    }
  }

  protected class UsersListRowMapper implements RowMapper<Users> {

    private List<Users> UsersList = new ArrayList<Users>();

    public List<Users> getResults() {
      return UsersList;
    }

    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
      Users viewObj = new Users();
      viewObj.setUserId(rs.getInt("user_id"));
      viewObj.setUserName(rs.getString("user_name"));
      return viewObj;
    }
  }
}