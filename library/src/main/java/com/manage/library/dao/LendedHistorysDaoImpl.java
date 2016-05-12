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
import com.manage.library.LendedHistorys;

/**
 * dbのlended_historysテーブルとのやり取りを記載するクラス。
 */
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  /**
   * lended_historysテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * 
   * @return lended_historysテーブルの全レコード

   */
  public List<LendedHistorys> findAll() throws DataAccessException {
    // LendedHistorys型の要素でできたrowMapperを生成する。
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    // lended_historysテーブルのデータ全てをテンプレートで返す。
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  /**
   * lended_historysテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * 
   * @param id
   * @return lended_historysテーブルの、idに対応するレコード
   */
  public List<LendedHistorys> findFromId(int id) {
    // LendedHistorys型の要素でできたrowMapperを生成する。
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    // lended_historysテーブルの、欲しいレコードをテンプレートで返す。
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。
   */
  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    /**
     * 実際にlended_historysテーブルから得たデータを、オブジェクトに格納して返すメソッド。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
    public LendedHistorys mapRow(ResultSet rs, int rowNum) throws SQLException {
      // LendedHistorys型のオブジェクトを生成する。ここに各カラムのデータを入れる。
      LendedHistorys viewObj = new LendedHistorys();
      // LendedHistorysクラスのsetterを用いて、それぞれ値を入れる。
      viewObj.setHistoryId(rs.getInt("history_id"));
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setReturnedAt(rs.getTimestamp("returned_at"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // データを入れたオブジェクトを返す。
      return viewObj;
    }
  }

}