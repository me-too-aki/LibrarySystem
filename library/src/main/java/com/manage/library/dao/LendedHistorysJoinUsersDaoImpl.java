/**
 *  �p�b�P�[�W���B
 */
package com.manage.library.dao;

/**
 * �K�v�ȃ��C�u�������C���|�[�g�B
 */
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
 * db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
 */
public class LendedHistorysJoinUsersDaoImpl extends JdbcDaoSupport implements LendedHistorysJoinUsersDao {

  /**
   * ���������e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * rowMapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @return return getJdbcTemplate().query(
   *         "select * from lended_historys inner join users on borrow_user_id = user_id;"
   *         , rowMapper);
   */
  public List<LendedHistorysJoinUsers> findAll() throws DataAccessException {
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys inner join users on borrow_user_id = user_id;",
        rowMapper);
  }

  /**
   * ���������e�[�u������A�Ή����郌�R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * rowMapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @param id
   * @return getJdbcTemplate().query(
   *         "select * from lended_historys inner join users on borrow_user_id = user_id where book_id="
   *         + id + ";", rowMapper);
   */
  public List<LendedHistorysJoinUsers> findFromId(int id) {
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from lended_historys inner join users on borrow_user_id = user_id where book_id=" + id + ";",
        rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
   */
  protected class HomeListRowMapper implements RowMapper<LendedHistorysJoinUsers> {

    /**
     * @param bookList
     *          ���������e�[�u������擾���郊�X�g�B
     */
    private List<LendedHistorysJoinUsers> bookList = new ArrayList<LendedHistorysJoinUsers>();

    /**
     * �擾����Resultset���AList�^�ŕԂ��ׂ̃��\�b�h�B
     * 
     * @return bookList
     */
    public List<LendedHistorysJoinUsers> getResults() {
      return bookList;
    }

    /**
     * db�̊e�J�������瓾���f�[�^���A LendedHistorys�AUsers�̊e���f���N���X��setter���\�b�h��p����
     * �A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B RowMapper�C���^�[�t�F�[�X�̃��\�b�h���I�[�o�[���C�h�������̂ŁAsql���s���ɌĂяo�����B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
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