/**
 *  Dao�̃p�b�P�[�W�B
 */
package com.manage.library.dao;

// �K�v�ȃ��C�u�������C���|�[�g�B

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;

/**
 * db��lended_historys�e�[�u���Ƃ̂������L�ڂ���N���X�B
 */
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  /**
   * lended_historys�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * 
   * @return lended_historys�e�[�u���̑S���R�[�h

   */
  public List<LendedHistorys> findAll() throws DataAccessException {
    // LendedHistorys�^�̗v�f�łł���rowMapper�𐶐�����B
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    // lended_historys�e�[�u���̃f�[�^�S�Ă��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  /**
   * lended_historys�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * 
   * @param id
   * @return lended_historys�e�[�u���́Aid�ɑΉ����郌�R�[�h
   */
  public List<LendedHistorys> findFromId(int id) {
    // LendedHistorys�^�̗v�f�łł���rowMapper�𐶐�����B
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    // lended_historys�e�[�u���́A�~�������R�[�h���e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B
   */
  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    /**
     * ���ۂ�lended_historys�e�[�u�����瓾���f�[�^���A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
    public LendedHistorys mapRow(ResultSet rs, int rowNum) throws SQLException {
      // LendedHistorys�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
      LendedHistorys viewObj = new LendedHistorys();
      // LendedHistorys�N���X��setter��p���āA���ꂼ��l������B
      viewObj.setHistoryId(rs.getInt("history_id"));
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setReturnedAt(rs.getTimestamp("returned_at"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // �f�[�^����ꂽ�I�u�W�F�N�g��Ԃ��B
      return viewObj;
    }
  }

}