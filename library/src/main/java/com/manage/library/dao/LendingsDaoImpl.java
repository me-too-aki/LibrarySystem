package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Lendings;

//Dao�̎����N���X�B
//sql���𔭍s���A���X�g�ɋl�߂�ׂ�RowMapper��p�ӂ���B
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

	// db���瓾���f�[�^���ARowMapper��p���ă��X�g�Ɋi�[���A�Ԃ��B
	// ��O�����������ꍇ�́A���̃��\�b�h�ɗ�O�������ڏ�����B
	// �e�[�u������f�[�^��S�ďE���Ă��郁�\�b�h�B
	public List<Lendings> findAll() throws DataAccessException {

		// sql���̌��ʂ��ARowMapper�I�u�W�F�N�g�̌`�ŕԂ��B
		RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
		return getJdbcTemplate().query("select * from lendings;", rowMapper);
	}

	// �e�[�u������A�Ή�����f�[�^���E���Ă��郁�\�b�h
	public List<Lendings> findFromId(int id) {
		RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
		return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
	}

	protected class LendingsListRowMapper implements RowMapper<Lendings> {

		private List<Lendings> LendingsList = new ArrayList<Lendings>();

		// �߂�l�Ƃ��ă��X�g�^�Ō��ʂ�Ԃ��B
		public List<Lendings> getResults() {
			return LendingsList;
		}

		// db���瓾���f�[�^(ResultSet�^)���ALendings�^�C���X�^���X�ɂ��ꂼ��i�[���A�Ԃ��B
		public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
			Lendings viewObj = new Lendings();
			viewObj.setBookId(rs.getInt("book_id"));
			viewObj.setLendingStatus(rs.getBoolean("lending_status"));
			viewObj.setLendedAt(rs.getTimestamp("lended_at"));
			viewObj.setDueDate(rs.getDate("due_date"));
			viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
			return viewObj;
		}
	}

}