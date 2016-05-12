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
import com.manage.library.Lendings;

/**
 * db��lendings�e�[�u���Ƃ̂������L�ڂ���N���X�B
 */
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  /**
   * lendings�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * 
   * @return getJdbcTemplate().query("select * from lendings;", rowMapper);
   */
  public List<Lendings> findAll() throws DataAccessException {
    // Lendings�^�̗v�f�łł���rowMapper�𐶐�����B
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // lendings�e�[�u���̃f�[�^�S�Ă��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  /**
   * lendings�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * 
   * @param id
   * @return getJdbcTemplate().query("select * from lendings where book_id=" +
   *         id + ";", rowMapper);
   */
  public List<Lendings> findFromId(int id) {
    // Lendings�^�̗v�f�łł���rowMapper�𐶐�����B
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // lendings�e�[�u���́A�~�������R�[�h���e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
   */
  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    /**
     * ���ۂ�lendings�e�[�u�����瓾���f�[�^���A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
    public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
      // Lendings�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
      Lendings viewObj = new Lendings();
      // Lendings�N���X��setter��p���āA���ꂼ��l������B
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // �f�[�^����ꂽ�I�u�W�F�N�g��Ԃ��B
      return viewObj;
    }
  }

}