/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

// 必要なライブラリをインポート。

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Lendings;

/**
 * dbのlendingsテーブルとのやり取りを記載するクラス。
 */
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  /**
   * lendingsテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * 
   * @return getJdbcTemplate().query("select * from lendings;", rowMapper);
   */
  public List<Lendings> findAll() throws DataAccessException {
    // Lendings型の要素でできたrowMapperを生成する。
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // lendingsテーブルのデータ全てをテンプレートで返す。
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  /**
   * lendingsテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * 
   * @param id
   * @return getJdbcTemplate().query("select * from lendings where book_id=" +
   *         id + ";", rowMapper);
   */
  public List<Lendings> findFromId(int id) {
    // Lendings型の要素でできたrowMapperを生成する。
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // lendingsテーブルの、欲しいレコードをテンプレートで返す。
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
   */
  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    /**
     * 実際にlendingsテーブルから得たデータを、オブジェクトに格納して返すメソッド。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
    public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
      // Lendings型のオブジェクトを生成する。ここに各カラムのデータを入れる。
      Lendings viewObj = new Lendings();
      // Lendingsクラスのsetterを用いて、それぞれ値を入れる。
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // データを入れたオブジェクトを返す。
      return viewObj;
    }
  }

}