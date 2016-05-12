/**
 *  Daoのパッケージ。
 */
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

/**
 * dbのbooksテーブルとのやり取りを記載するクラス。
 */
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao {

  /**
   * booksテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * 
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public List<Books> findAll() throws DataAccessException {
    // Books型の要素でできたrowMapperを生成する。
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    // booksテーブルのデータ全てをテンプレートで返す。
    return getJdbcTemplate().query("select * from books;", rowMapper);
  }

  /**
   * booksテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * 
   * @param id
   * @return getgetJdbcTemplate().query("select * from books;", rowMapper);
   */
  public Books findFromBookId(int id) {
    // Books型の要素でできたrowMapperを生成する。
    RowMapper<Books> rowMapper = new BooksListRowMapper();
    // booksテーブルの、欲しいレコードをテンプレートで返す。
    return getJdbcTemplate().queryForObject("select * from books where book_id=" + id + ";", rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。
   */
  protected class BooksListRowMapper implements RowMapper<Books> {

    /**
     * 実際にbooksテーブルから得たデータを、オブジェクトに格納して返すメソッド。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
      // Books型のオブジェクトを生成する。ここに各カラムのデータを入れる。
      Books viewObj = new Books();
      // Booksクラスのsetterを用いて、それぞれ値を入れる。
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setBookTitle(rs.getString("book_title"));
      viewObj.setWritterName(rs.getString("writter_name"));
      viewObj.setPublisher(rs.getString("publisher"));
      viewObj.setPublishedAt(rs.getDate("published_at"));
      viewObj.setOwnerUserId(rs.getInt("owner_user_id"));
      viewObj.setRegisteredAt(rs.getTimestamp("registered_at"));
      // データを入れたオブジェクトを返す。
      return viewObj;
    }
  }
}