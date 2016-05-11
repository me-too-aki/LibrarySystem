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
import com.manage.library.Lendings;

/**
 * db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
 */
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  /**
   * lendings�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * Lendings�^�̗v�f�łł���rowMapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @return getJdbcTemplate().query("select * from lendings;", rowMapper);
   */
  public List<Lendings> findAll() throws DataAccessException {
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  /**
   * lendings�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * Lendings�^�̗v�f�łł���rowmapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @param id
   * @return getJdbcTemplate().query("select * from lendings where book_id=" +
   *         id + ";", rowMapper);
   */
  public List<Lendings> findFromId(int id) {
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
   */
  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    /**
     * @param LendingsList
     *          �e�[�u������擾���郊�X�g�B
     */
    private List<Lendings> LendingsList = new ArrayList<Lendings>();

    /**
     * �擾����Resultset���AList�^�ŕԂ��ׂ̃��\�b�h�B
     * 
     * @return LendingsList
     */
    public List<Lendings> getResults() {
      return LendingsList;
    }

    /**
     * db�̊e�J�������瓾���f�[�^���A���f���N���X��setter���\�b�h��p���� �I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
     * RowMapper�C���^�[�t�F�[�X�̃��\�b�h���I�[�o�[���C�h�������̂ŁAsql���s���ɌĂяo�����B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
    public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
      Lendings viewObj = new Lendings();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      return viewObj;
    }
  }

}