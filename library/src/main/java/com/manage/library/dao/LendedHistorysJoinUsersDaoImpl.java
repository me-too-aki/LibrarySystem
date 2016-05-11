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
import com.manage.library.LendedHistorysJoinUsers;
import com.manage.library.Users;

/**
 * dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
 */
public class LendedHistorysJoinUsersDaoImpl extends JdbcDaoSupport implements LendedHistorysJoinUsersDao {

  /**
   * 結合したテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * rowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @return return getJdbcTemplate().query(
   *         "select * from lended_historys inner join users on borrow_user_id = user_id;"
   *         , rowMapper);
   */
  public List<LendedHistorysJoinUsers> findAll() throws DataAccessException {
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys inner join users on borrow_user_id = user_id;",
        rowMapper);
  }

  /**
   * 結合したテーブルから、対応するレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * rowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @param id
   * @return getJdbcTemplate().query(
   *         "select * from lended_historys inner join users on borrow_user_id = user_id where book_id="
   *         + id + ";", rowMapper);
   */
  public List<LendedHistorysJoinUsers> findFromId(int id) {
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from lended_historys inner join users on borrow_user_id = user_id where book_id=" + id + ";",
        rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
   */
  protected class HomeListRowMapper implements RowMapper<LendedHistorysJoinUsers> {

    /**
     * @param bookList
     *          結合したテーブルから取得するリスト。
     */
    private List<LendedHistorysJoinUsers> bookList = new ArrayList<LendedHistorysJoinUsers>();

    /**
     * 取得したResultsetを、List型で返す為のメソッド。
     * 
     * @return bookList
     */
    public List<LendedHistorysJoinUsers> getResults() {
      return bookList;
    }

    /**
     * dbの各カラムから得たデータを、 LendedHistorys、Usersの各モデルクラスのsetterメソッドを用いて
     * 、オブジェクトに格納して返すメソッド。 RowMapperインターフェースのメソッドをオーバーライドしたもので、sql実行時に呼び出される。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
    public LendedHistorysJoinUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
      LendedHistorysJoinUsers viewObj = new LendedHistorysJoinUsers();
      LendedHistorys lendedHistorys = new LendedHistorys();
      Users users = new Users();

      lendedHistorys.setHistoryId(rs.getInt("history_id"));
      lendedHistorys.setBookId(rs.getInt("book_id"));
      lendedHistorys.setLendedAt(rs.getTimestamp("lended_at"));
      lendedHistorys.setReturnedAt(rs.getTimestamp("returned_at"));
      lendedHistorys.setBorrowUserId(rs.getInt("borrow_user_id"));
      users.setUserId(rs.getInt("user_id"));
      users.setUserName(rs.getString("user_name"));

      viewObj.setLendedHistorys(lendedHistorys);
      viewObj.setUsers(users);
      return viewObj;
    }
  }

}