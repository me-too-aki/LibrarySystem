package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Books;

//Daoの実装クラス。
//sql文を発行し、リストに詰める為のRowMapperを用意する。
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

	// dbから得たデータを、RowMapperを用いてリストに格納し、返す。
	// 例外が発生した場合は、元のメソッドに例外処理を移譲する。
	// テーブルからデータを全て拾ってくるメソッド。
	public List<Books> findAll() throws DataAccessException {

		// sql文の結果を、RowMapperオブジェクトの形で返す。
		RowMapper<Books> rowMapper = new BooksListRowMapper();
		return getJdbcTemplate().query("select * from books;", rowMapper);
	}

	// テーブルから、対応するデータを拾ってくるメソッド
	public List<Books> findFromId(int id) {
		// TODO 自動生成されたメソッド・スタブ
		RowMapper<Books> rowMapper = new BooksListRowMapper();
		return getJdbcTemplate().query("select * from books where book_id=" + id + ";", rowMapper);
	}

	protected class BooksListRowMapper implements RowMapper<Books> {

		private List<Books> bookList = new ArrayList<Books>();

		// 戻り値としてリスト型で結果を返す。
		public List<Books> getResults() {
			return bookList;
		}

		// dbから得たデータ(ResultSet型)を、Books型インスタンスにそれぞれ格納し、返す。
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