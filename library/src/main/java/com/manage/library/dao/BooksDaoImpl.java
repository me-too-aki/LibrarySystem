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
import com.manage.library.Books;

/**
 * db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
 */
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  /**
   * books�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * Books�^�̗v�f�łł���rowMapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public List<Books> findAll() throws DataAccessException {
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

  /**
   * books�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * Books�^�̗v�f�łł���rowmapper�𐶐����Asql���̌��ʂ��i�[���ăe���v���[�g�ŕԂ��B
   * 
   * @param id
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public Books findFromBookId(int id) {
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
   */
  protected class BooksListRowMapper implements RowMapper<Books> {

    /**
     * @param books�e�[�u������擾���郊�X�g�B
     */
    private List<Books> bookList = new ArrayList<Books>();

    /**
     * �擾����Resultset���AList�^�ŕԂ��ׂ̃��\�b�h�B
     * 
     * @return bookList
     */
    public List<Books> getResults() {
      return bookList;
    }

    /**
     * db�̊e�J�������瓾���f�[�^���A���f���N���X��setter���\�b�h��p���� �I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
     * RowMapper�C���^�[�t�F�[�X�̃��\�b�h���I�[�o�[���C�h�������̂ŁAsql���s���ɌĂяo�����B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
      Books viewObj = new Books();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setWritterName(rs.getString("writter_name"));
      viewObj.setPublisher(rs.getString("publisher"));
      viewObj.setPublishedAt(rs.getDate("published_at"));
      viewObj.setOwnerUserId(rs.getInt("owner_user_id"));
      viewObj.setRegisteredAt(rs.getTimestamp("registered_at"));
      return viewObj;
    }
  }
}