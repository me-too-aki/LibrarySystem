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
import com.manage.library.LendedHistorys;

//dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

//継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<LendedHistorys> findAll() throws DataAccessException {

    //LendedHistorys型の要素でできたrowmapperを生成する。
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    //sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

//継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<LendedHistorys> findFromId(int id) {
  //LendedHistorys型の要素でできたrowmapperを生成する。
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    //sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

  //lendedHistorys型の要素でできたlendedHistorysListを生成する。
    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();
    
    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

 // モデルクラスのsetterメソッドを用いて、dbから得たデータを各カラムに格納する。
    public LendedHistorys mapRow(ResultSet rs, int rowNum) throws SQLException {
      LendedHistorys viewObj = new LendedHistorys();
      viewObj.setHistoryId(rs.getInt("history_id"));
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setReturnedAt(rs.getTimestamp("returned_at"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // データが格納されたviewObjを返す。
      return viewObj;
    }
  }

}