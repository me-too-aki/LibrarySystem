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
import com.manage.library.Lendings;

//db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  // �p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<Lendings> findAll() throws DataAccessException {

    // Lendings�^�̗v�f�łł���rowmapper�𐶐�����B
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  // �p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<Lendings> findFromId(int id) {
    // Lendings�^�̗v�f�łł���rowmapper�𐶐�����B
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    // Lendings�^�̗v�f�łł���LendingsList�𐶐�����B
    private List<Lendings> LendingsList = new ArrayList<Lendings>();

    public List<Lendings> getResults() {
      return LendingsList;
    }

    // ���f���N���X��setter���\�b�h��p���āAdb���瓾���f�[�^���e�J�����Ɋi�[����B
    public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
      Lendings viewObj = new Lendings();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // �f�[�^���i�[���ꂽviewObj��Ԃ��B
      return viewObj;
    }
  }

}