package com.manage.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

// sql���𔭍s���A���X�g�ɋl�߂�ׂ�RowMapper��p�ӂ���N���X�B
public class HomeDaoImpl extends JdbcDaoSupport implements HomeDao {

  // db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�߂��B
  public List<Home> findAll() throws DataAccessException {
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

    // db���瓾���f�[�^�����ꂼ��i�[�����AHome�^�C���X�^���X��߂��B
    public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
      Home home = new Home();
      home.setBook_id(rs.getInt("book_id"));
      home.setBook_title(rs.getString("book_title"));
      home.setLending_status(rs.getBoolean("lending_status"));
      home.setLended_at(rs.getTimestamp("lended_at"));
      home.setDue_date(rs.getDate("due_date"));
      home.setUser_name(rs.getString("user_id"));
      return home;
    }
  }
}