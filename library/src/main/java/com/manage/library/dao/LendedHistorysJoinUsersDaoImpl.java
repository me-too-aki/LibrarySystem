/**
 *  Dao�̃p�b�P�[�W�B
 */
package com.manage.library.dao;

//  �K�v�ȃ��C�u�������C���|�[�g�B
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

/**
 * db�́Alended_historys,users�����������e�[�u���Ƃ̂������L�ڂ���N���X�B
 */
public class LendedHistorysJoinUsersDaoImpl extends JdbcDaoSupport implements LendedHistorysJoinUsersDao {

    /**
     * ���������e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
     *
     * @return lended_history,users�����������e�[�u���̑S���R�[�h
     */
    public List<LendedHistorysJoinUsers> findAll() throws DataAccessException {
        // ���������e�[�u�����f���̗v�f�łł���rowMapper�𐶐�����B
        RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
        // ���������e�[�u���̃f�[�^�S�Ă��e���v���[�g�ŕԂ��B
        return getJdbcTemplate().query("select * from lended_historys inner join users on borrow_user_id = user_id;",
                rowMapper);
    }

    /**
     * ���������e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
     *
     * @param id
     * @return lended_history,users�����������e�[�u���́Aid�ɑΉ����郌�R�[�h
     */
    public List<LendedHistorysJoinUsers> findFromId(int id) {
        // ���������e�[�u�����f���̗v�f�łł���rowMapper�𐶐�����B
        RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
        // ���������e�[�u���́Aid�ɑΉ����郌�R�[�h���e���v���[�g�ŕԂ��B
        return getJdbcTemplate().query(
                "select * from lended_historys inner join users on borrow_user_id = user_id where book_id=" + id + ";",
                rowMapper);
    }

    /**
     * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
     */
    protected class HomeListRowMapper implements RowMapper<LendedHistorysJoinUsers> {

        /**
         * ���ۂɌ��������e�[�u�����瓾���f�[�^���A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
         *
         * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
         */
        public LendedHistorysJoinUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
            // ���������e�[�u���̃I�u�W�F�N�g�𐶐�����B
            LendedHistorysJoinUsers viewObj = new LendedHistorysJoinUsers();
            // LendedHistorys�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
            LendedHistorys lendedHistorys = new LendedHistorys();
            // Users�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
            Users users = new Users();

            // �N���X��setter��p���āA���ꂼ��l������B
            lendedHistorys.setHistoryId(rs.getInt("history_id"));
            lendedHistorys.setBookId(rs.getInt("book_id"));
            lendedHistorys.setLendedAt(rs.getTimestamp("lended_at"));
            lendedHistorys.setReturnedAt(rs.getTimestamp("returned_at"));
            lendedHistorys.setBorrowUserId(rs.getInt("borrow_user_id"));
            users.setUserId(rs.getInt("user_id"));
            users.setUserName(rs.getString("user_name"));

            // ���������e�[�u���̃I�u�W�F�N�g�ɁAlended_historys�e�[�u���̃f�[�^������B
            viewObj.setLendedHistorys(lendedHistorys);
            // ���������e�[�u���̃I�u�W�F�N�g�ɁAusers�e�[�u���̃f�[�^������B
            viewObj.setUsers(users);
            // �f�[�^����ꂽ�I�u�W�F�N�g��Ԃ��B
            return viewObj;
        }
    }

}
