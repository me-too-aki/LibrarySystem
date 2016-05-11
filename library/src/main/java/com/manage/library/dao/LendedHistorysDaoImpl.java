// �p�b�P�[�W���B
package com.manage.library.dao;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;

//db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

//�p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<LendedHistorys> findAll() throws DataAccessException {

    //LendedHistorys�^�̗v�f�łł���rowmapper�𐶐�����B
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    //sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

//�p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<LendedHistorys> findFromId(int id) {
  //LendedHistorys�^�̗v�f�łł���rowmapper�𐶐�����B
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    //sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

  //lendedHistorys�^�̗v�f�łł���lendedHistorysList�𐶐�����B
    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();
    
    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

 // ���f���N���X��setter���\�b�h��p���āAdb���瓾���f�[�^���e�J�����Ɋi�[����B
    public LendedHistorys mapRow(ResultSet rs, int rowNum) throws SQLException {
      LendedHistorys viewObj = new LendedHistorys();
      viewObj.setHistoryId(rs.getInt("history_id"));
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setReturnedAt(rs.getTimestamp("returned_at"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // �f�[�^���i�[���ꂽviewObj��Ԃ��B
      return viewObj;
    }
  }

}