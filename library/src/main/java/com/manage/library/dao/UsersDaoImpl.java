package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

//Daoの実装クラス。
//sql文を発行し、リストに詰める為のRowMapperを用意する。
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

	// dbから得たデータを、RowMapperを用いてリストに格納し、返す。
	// 例外が発生した場合は、元のメソッドに例外処理を移譲する。
	// テーブルからデータを全て拾ってくるメソッド。
	public List<Users> findAll() throws DataAccessException {

		// sql文の結果を、RowMapperオブジェクトの形で返す。
		RowMapper<Users> rowMapper = new UsersListRowMapper();
		return getJdbcTemplate().query("select * from users;", rowMapper);
	}

	
	public String findUserNameFromUserId(int userId) {
	  if( userId != 0){
	  return getJdbcTemplate().queryForObject("select user_name from users where user_id=" + userId + ";",
        String.class);
	  }else{
	    return "";
	  }
	}

	protected class UsersListRowMapper implements RowMapper<Users> {

		private List<Users> UsersList = new ArrayList<Users>();

		// 戻り値としてリスト型で結果を返す。
		public List<Users> getResults() {
			return UsersList;
		}

		// dbから得たデータ(ResultSet型)を、LendedHistorys型インスタンスにそれぞれ格納し、返す。
		public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
			Users viewObj = new Users();
			viewObj.setUserId(rs.getInt("user_id"));
			viewObj.setUserName(rs.getString("user_name"));
			return viewObj;
		}
	}
}