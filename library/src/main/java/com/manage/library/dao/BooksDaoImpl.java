// パッケージ名。
package com.manage.library.dao;

//必要なライブラリをインポート。
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Books;

//dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  //継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<Books> findAll() throws DataAccessException {

    //Books型の要素でできたrowmapperを生成する。
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    //sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

//継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public Books findFromBookId(int id) {
  //Books型の要素でできたRowmapperを生成する。
    RowMapper<Books> rowMapper = new BooksListRowMapper();
  //sql文の結果をテンプレートで返す。
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  
  protected class BooksListRowMapper implements RowMapper<Books> {

    //Books型の要素でできたbookListを生成する。
    private List<Books> bookList = new ArrayList<Books>();

    public List<Books> getResults() {
      return bookList;
    }

    // モデルクラスのsetterメソッドを用いて、dbから得たデータを各カラムに格納する。
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
      Books viewObj = new Books();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setWritterName(rs.getString("writter_name"));
      viewObj.setPublisher(rs.getString("publisher"));
      viewObj.setPublishedAt(rs.getDate("published_at"));
      viewObj.setOwnerUserId(rs.getInt("owner_user_id"));
      viewObj.setRegisteredAt(rs.getTimestamp("registered_at"));
      // データが格納されたviewObjを返す。
      return viewObj;
    }
  }
}