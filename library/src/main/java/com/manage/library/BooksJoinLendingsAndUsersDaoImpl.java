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
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

  // db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�Ԃ��B
  // ��O�����������ꍇ�́A���̃��\�b�h�ɗ�O�������ڏ�����B
  public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {
    
    // sql���̌��ʂ��ARowMapper�I�u�W�F�N�g�̌`�ŕԂ��B
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

    private List<BooksJoinLendingsAndUsers> bookList = new ArrayList<BooksJoinLendingsAndUsers>();

    // �߂�l�Ƃ��ă��X�g�^�Ō��ʂ�Ԃ��B
    public List<BooksJoinLendingsAndUsers> getResults() {
      return bookList;
    }

    // db���瓾���f�[�^(ResultSet�^)���ABooksJoinLendingsAndUsers�^�C���X�^���X�ɂ��ꂼ��i�[���A�Ԃ��B
    public BooksJoinLendingsAndUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
      BooksJoinLendingsAndUsers viewObj = new BooksJoinLendingsAndUsers();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setUserName(rs.getString("user_name"));
      return viewObj;
    }
  }
}