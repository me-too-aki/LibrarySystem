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

/**
 * db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
 */
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  /**
   * lended_historys�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * LendedHistorys�^�̗v�f�łł���rowMapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
   */
  public List<LendedHistorys> findAll() throws DataAccessException {

    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  /**
   * lended_historys�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * LendedHistorys�^�̗v�f�łł���rowmapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @param id
   * @return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
   */
  public List<LendedHistorys> findFromId(int id) {
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
   */
  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    /**
     * @param lendedHistorysList
     *          �e�[�u������擾���郊�X�g�B
     */
    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();

    /**
     * �擾����Resultset���AList�^�ŕԂ��ׂ̃��\�b�h�B
     * 
     * @return lendedHistorysList
     */
    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

    /**
     * db�̊e�J�������瓾���f�[�^���A���f���N���X��setter���\�b�h��p���� �I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
     * RowMapper�C���^�[�t�F�[�X�̃��\�b�h���I�[�o�[���C�h�������̂ŁAsql���s���ɌĂяo�����B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
    public LendedHistorys mapRow(ResultSet rs, int rowNum) throws SQLException {
      LendedHistorys viewObj = new LendedHistorys();
      viewObj.setHistoryId(rs.getInt("history_id"));
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setReturnedAt(rs.getTimestamp("returned_at"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      return viewObj;
    }
  }

}