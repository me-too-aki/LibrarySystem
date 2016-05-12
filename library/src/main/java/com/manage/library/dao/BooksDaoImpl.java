/**
 *  Dao�̃p�b�P�[�W�B
 */
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

/**
 * db��books�e�[�u���Ƃ̂������L�ڂ���N���X�B
 */
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  /**
   * books�e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * 
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public List<Books> findAll() throws DataAccessException {
    // Books�^�̗v�f�łł���rowMapper�𐶐�����B
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    // books�e�[�u���̃f�[�^�S�Ă��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

  /**
   * books�e�[�u������A�Ή�����id�̃��R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
   * 
   * @param id
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public Books findFromBookId(int id) {
    // Books�^�̗v�f�łł���rowMapper�𐶐�����B
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    // books�e�[�u���́A�~�������R�[�h���e���v���[�g�ŕԂ��B
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  /**
   * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B
   */
  protected class BooksListRowMapper implements RowMapper<Books> {

    /**
     * ���ۂ�books�e�[�u�����瓾���f�[�^���A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
     * 
     * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
     */
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
      // Books�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
      Books viewObj = new Books();
      // Books�N���X��setter��p���āA���ꂼ��l������B
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setWritterName(rs.getString("writter_name"));
      viewObj.setPublisher(rs.getString("publisher"));
      viewObj.setPublishedAt(rs.getDate("published_at"));
      viewObj.setOwnerUserId(rs.getInt("owner_user_id"));
      viewObj.setRegisteredAt(rs.getTimestamp("registered_at"));
      // �f�[�^����ꂽ�I�u�W�F�N�g��Ԃ��B
      return viewObj;
    }
  }
}