package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;

//Dao�̎����N���X�B
//sql���𔭍s���A���X�g�ɋl�߂�ׂ�RowMapper��p�ӂ���B
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  // db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�Ԃ��B
  // ��O�����������ꍇ�́A���̃��\�b�h�ɗ�O�������ڏ�����B
  // �e�[�u������f�[�^��S�ďE���Ă��郁�\�b�h�B
  public List<LendedHistorys> findAll() throws DataAccessException {

    // sql���̌��ʂ��ARowMapper�I�u�W�F�N�g�̌`�ŕԂ��B
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  // �e�[�u������A�Ή�����f�[�^���E���Ă��郁�\�b�h
  public List<LendedHistorys> findFromId(int id) {
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();

    // �߂�l�Ƃ��ă��X�g�^�Ō��ʂ�Ԃ��B
    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

    // db���瓾���f�[�^(ResultSet�^)���ALendedHistorys�^�C���X�^���X�ɂ��ꂼ��i�[���A�Ԃ��B
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