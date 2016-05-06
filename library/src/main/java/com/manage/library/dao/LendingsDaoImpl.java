package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Lendings;

//Daoの実装クラス。
//sql文を発行し、リストに詰める為のRowMapperを用意する。
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

	// dbから得たデータを、RowMapperを用いてリストに格納し、返す。
	// 例外が発生した場合は、元のメソッドに例外処理を移譲する。
	// テーブルからデータを全て拾ってくるメソッド。
	public List<Lendings> findAll() throws DataAccessException {

		// sql文の結果を、RowMapperオブジェクトの形で返す。
		RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
		return getJdbcTemplate().query("select * from lendings;", rowMapper);
	}

	// テーブルから、対応するデータを拾ってくるメソッド
	public List<Lendings> findFromId(int id) {
		RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
		return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
	}

	protected class LendingsListRowMapper implements RowMapper<Lendings> {

		private List<Lendings> LendingsList = new ArrayList<Lendings>();

		// 戻り値としてリスト型で結果を返す。
		public List<Lendings> getResults() {
			return LendingsList;
		}

		// dbから得たデータ(ResultSet型)を、Lendings型インスタンスにそれぞれ格納し、返す。
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