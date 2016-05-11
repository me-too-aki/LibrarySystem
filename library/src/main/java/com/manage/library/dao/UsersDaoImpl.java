// �p�b�P�[�W���B
package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

/**
 * ���[�U�e�[�u���Ƃ̎��ۂ̃f�[�^�̂������L�ڂ���DAO�����N���X
 */
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

  /**
   * ���[�U�e�[�u���̑S���R�[�h���擾���郁�\�b�h
   * @return ���[�U�e�[�u���̑S���R�[�h���X�g
   */
  public List<Users> findAll() throws DataAccessException {

    RowMapper<Users> rowMapper = new UsersListRowMapper();
    return getJdbcTemplate().query("select * from users;", rowMapper);
  }

  /**
   * ���[�U�e�[�u���̑Ή�����id����1���R�[�h���擾���郁�\�b�h
   * @return ���[�U�e�[�u���̃��R�[�h
   */
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

    /**
     * ���f���N���X��setter���\�b�h��p���āAdb���瓾���f�[�^���e�J�����Ɋi�[���郁�\�b�h
     * @return �f�[�^���i�[�����I�u�W�F�N�g
     */
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
      Users viewObj = new Users();
      viewObj.setUserId(rs.getInt("user_id"));
      viewObj.setUserName(rs.getString("user_name"));
      return viewObj;
    }
  }
}