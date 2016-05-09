package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

//Dao�̎����N���X�B
//sql���𔭍s���A���X�g�ɋl�߂�ׂ�RowMapper��p�ӂ���B
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

	// db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�Ԃ��B
	// ��O�����������ꍇ�́A���̃��\�b�h�ɗ�O�������ڏ�����B
	// �e�[�u������f�[�^��S�ďE���Ă��郁�\�b�h�B
	public List<Users> findAll() throws DataAccessException {

		// sql���̌��ʂ��ARowMapper�I�u�W�F�N�g�̌`�ŕԂ��B
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

		// �߂�l�Ƃ��ă��X�g�^�Ō��ʂ�Ԃ��B
		public List<Users> getResults() {
			return UsersList;
		}

		// db���瓾���f�[�^(ResultSet�^)���ALendedHistorys�^�C���X�^���X�ɂ��ꂼ��i�[���A�Ԃ��B
		public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
			Users viewObj = new Users();
			viewObj.setUserId(rs.getInt("user_id"));
			viewObj.setUserName(rs.getString("user_name"));
			return viewObj;
		}
	}
}