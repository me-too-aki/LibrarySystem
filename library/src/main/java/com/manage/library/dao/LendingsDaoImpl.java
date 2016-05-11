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
import com.manage.library.Lendings;

/**
 * dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
 */
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  /**
   * lendingsテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * Lendings型の要素でできたrowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @return getJdbcTemplate().query("select * from lendings;", rowMapper);
   */
  public List<Lendings> findAll() throws DataAccessException {
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  /**
   * lendingsテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * Lendings型の要素でできたrowmapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @param id
   * @return getJdbcTemplate().query("select * from lendings where book_id=" +
   *         id + ";", rowMapper);
   */
  public List<Lendings> findFromId(int id) {
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
   */
  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    /**
     * @param LendingsList
     *          テーブルから取得するリスト。
     */
    private List<Lendings> LendingsList = new ArrayList<Lendings>();

    /**
     * 取得したResultsetを、List型で返す為のメソッド。
     * 
     * @return LendingsList
     */
    public List<Lendings> getResults() {
      return LendingsList;
    }

    /**
     * dbの各カラムから得たデータを、モデルクラスのsetterメソッドを用いて オブジェクトに格納して返すメソッド。
     * RowMapperインターフェースのメソッドをオーバーライドしたもので、sql実行時に呼び出される。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
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