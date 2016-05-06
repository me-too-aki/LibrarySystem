package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Books;

//Dao�̎����N���X�B
//sql���𔭍s���A���X�g�ɋl�߂�ׂ�RowMapper��p�ӂ���B
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

	// db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�Ԃ��B
	// ��O�����������ꍇ�́A���̃��\�b�h�ɗ�O�������ڏ�����B
	// �e�[�u������f�[�^��S�ďE���Ă��郁�\�b�h�B
	public List<Books> findAll() throws DataAccessException {

		// sql���̌��ʂ��ARowMapper�I�u�W�F�N�g�̌`�ŕԂ��B
		RowMapper<Books> rowMapper = new BooksListRowMapper();
		return getJdbcTemplate().query("select * from books;", rowMapper);
	}

	// �e�[�u������A�Ή�����f�[�^���E���Ă��郁�\�b�h
	public List<Books> findFromId(int id) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		RowMapper<Books> rowMapper = new BooksListRowMapper();
		return getJdbcTemplate().query("select * from books where book_id=" + id + ";", rowMapper);
	}

	protected class BooksListRowMapper implements RowMapper<Books> {

		private List<Books> bookList = new ArrayList<Books>();

		// �߂�l�Ƃ��ă��X�g�^�Ō��ʂ�Ԃ��B
		public List<Books> getResults() {
			return bookList;
		}

		// db���瓾���f�[�^(ResultSet�^)���ABooks�^�C���X�^���X�ɂ��ꂼ��i�[���A�Ԃ��B
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