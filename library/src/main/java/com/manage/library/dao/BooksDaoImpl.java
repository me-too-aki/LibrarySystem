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
import com.manage.library.Books;

//db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  //�p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<Books> findAll() throws DataAccessException {

    //Books�^�̗v�f�łł���rowmapper�𐶐�����B
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    //sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

//�p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public Books findFromBookId(int id) {
  //Books�^�̗v�f�łł���Rowmapper�𐶐�����B
    RowMapper<Books> rowMapper = new BooksListRowMapper();
  //sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  
  protected class BooksListRowMapper implements RowMapper<Books> {

    //Books�^�̗v�f�łł���bookList�𐶐�����B
    private List<Books> bookList = new ArrayList<Books>();

    public List<Books> getResults() {
      return bookList;
    }

    // ���f���N���X��setter���\�b�h��p���āAdb���瓾���f�[�^���e�J�����Ɋi�[����B
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
      Books viewObj = new Books();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setWritterName(rs.getString("writter_name"));
      viewObj.setPublisher(rs.getString("publisher"));
      viewObj.setPublishedAt(rs.getDate("published_at"));
      viewObj.setOwnerUserId(rs.getInt("owner_user_id"));
      viewObj.setRegisteredAt(rs.getTimestamp("registered_at"));
      // �f�[�^���i�[���ꂽviewObj��Ԃ��B
      return viewObj;
    }
  }
}