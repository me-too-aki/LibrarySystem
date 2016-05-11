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
import com.manage.library.LendedHistorys;

/**
 * dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
 */
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  /**
   * lended_historysテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * LendedHistorys型の要素でできたrowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
   */
  public List<LendedHistorys> findAll() throws DataAccessException {

    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  /**
   * lended_historysテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * LendedHistorys型の要素でできたrowmapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @param id
   * @return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
   */
  public List<LendedHistorys> findFromId(int id) {
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
   */
  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    /**
     * @param lendedHistorysList
     *          テーブルから取得するリスト。
     */
    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();

    /**
     * 取得したResultsetを、List型で返す為のメソッド。
     * 
     * @return lendedHistorysList
     */
    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

    /**
     * dbの各カラムから得たデータを、モデルクラスのsetterメソッドを用いて オブジェクトに格納して返すメソッド。
     * RowMapperインターフェースのメソッドをオーバーライドしたもので、sql実行時に呼び出される。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
    public LendedHistorys mapRow(ResultSet rs, int rowNum) throws SQLException {
      LendedHistorys viewObj = new LendedHistorys();
      viewObj.setHistoryId(rs.getInt("history_id"));
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setReturnedAt(rs.getTimestamp("returned_at"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      return viewObj;
    }
  }

}