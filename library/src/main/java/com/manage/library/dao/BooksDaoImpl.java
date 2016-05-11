/**
 *  パッケージ名。
 */
package com.manage.library.dao;

/**
 * 必要なライブラリをインポート。
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
 * dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
 */
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  /**
   * booksテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * Books型の要素でできたrowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public List<Books> findAll() throws DataAccessException {
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

  /**
   * booksテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * Books型の要素でできたrowmapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @param id
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public Books findFromBookId(int id) {
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
   */
  protected class BooksListRowMapper implements RowMapper<Books> {

    /**
     * @param booksテーブルから取得するリスト。
     */
    private List<Books> bookList = new ArrayList<Books>();

    /**
     * 取得したResultsetを、List型で返す為のメソッド。
     * 
     * @return bookList
     */
    public List<Books> getResults() {
      return bookList;
    }

    /**
     * dbの各カラムから得たデータを、モデルクラスのsetterメソッドを用いて オブジェクトに格納して返すメソッド。
     * RowMapperインターフェースのメソッドをオーバーライドしたもので、sql実行時に呼び出される。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
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