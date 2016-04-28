package com.manage.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

// Dao�̎����N���X�B
// sql���𔭍s���A���X�g�ɋl�߂�ׂ�RowMapper��p�ӂ���B
public class HomeDaoImpl extends JdbcDaoSupport implements HomeDao {

  // db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�Ԃ��B
  // ��O�����������ꍇ�́A���̃��\�b�h�ɗ�O�������ڏ�����B
  public List<Home> findAll() throws DataAccessException {
    
    // sql���̌��ʂ��ARowMapper�I�u�W�F�N�g�̌`�ŕԂ��B
    RowMapper<Home> rowMapper = new HomeRowMapper();
    return getJdbcTemplate().query(
        "select * from books inner join users on owner_user_id = user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  protected class HomeRowMapper implements RowMapper<Home> {

    private List<Home> bookList = new ArrayList<Home>();

    // �߂�l�Ƃ��ă��X�g�^�Ō��ʂ�Ԃ��B
    public List<Home> getResults() {
      return bookList;
    }

    // db���瓾���f�[�^(ResultSet�^)���AHome�^�C���X�^���X�ɂ��ꂼ��i�[���A�Ԃ��B
    public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
      Home home = new Home();
      home.setBookId(rs.getInt("book_id"));
      home.setBookTitle(rs.getString("book_title"));
      home.setLendingStatus(rs.getBoolean("lending_status"));
      home.setLendedAt(rs.getTimestamp("lended_at"));
      home.setDueDate(rs.getDate("due_date"));
      home.setUserName(rs.getString("user_id"));
      return home;
    }
  }
}