/**
 *  Dao�̃p�b�P�[�W�B
 */
package com.manage.library.dao;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

/**
 * db��users�e�[�u���Ƃ̂������L�ڂ���N���X�B
 */
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

    /**
     * users�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
     *
     * @return users�e�[�u���̑S���R�[�h
     */
    public List<Users> findAll() throws DataAccessException {
        // Users�^�̗v�f�łł���rowMapper�𐶐�����B
        RowMapper<Users> rowMapper = new UsersListRowMapper();
        // users�e�[�u���̃f�[�^�S�Ă��e���v���[�g�ŕԂ��B
        return getJdbcTemplate().query("select * from users;", rowMapper);
    }

    /**
     * users�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
     *
     * @return userId�ɑΉ����郆�[�U��
     */
    public String findUserNameFromUserId(int userId) {
        // ���[�UID�̒l������΁A�Ή����郆�[�U����Ԃ��B
        if (userId != 0) {
            return getJdbcTemplate().queryForObject("select user_name from users where user_id=" + userId + ";",
                    String.class);
            // ���[�UID�̒l���Ȃ���΁A�󕶎���Ԃ��B
        } else {
            return "";
        }
    }

    /**
     * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
     */
    protected class UsersListRowMapper implements RowMapper<Users> {

        /**
         * ���ۂ�users�e�[�u�����瓾���f�[�^���A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
         *
         * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
         */
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            // Users�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
            Users viewObj = new Users();
            // Users�N���X��setter��p���āA���ꂼ��l������B
            viewObj.setUserId(rs.getInt("user_id"));
            viewObj.setUserName(rs.getString("user_name"));
            // �f�[�^����ꂽ�I�u�W�F�N�g��Ԃ��B
            return viewObj;
        }
    }
}
