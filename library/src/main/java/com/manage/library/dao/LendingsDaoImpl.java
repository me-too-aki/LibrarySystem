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
import com.manage.library.Lendings;

//dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
public class LendingsDaoImpl extends JdbcDaoSupport implements LendingsDao {

  // 継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<Lendings> findAll() throws DataAccessException {

    // Lendings型の要素でできたrowmapperを生成する。
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query("select * from lendings;", rowMapper);
  }

  // 継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<Lendings> findFromId(int id) {
    // Lendings型の要素でできたrowmapperを生成する。
    RowMapper<Lendings> rowMapper = new LendingsListRowMapper();
    // sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query("select * from lendings where book_id=" + id + ";", rowMapper);
  }

  protected class LendingsListRowMapper implements RowMapper<Lendings> {

    // Lendings型の要素でできたLendingsListを生成する。
    private List<Lendings> LendingsList = new ArrayList<Lendings>();

    public List<Lendings> getResults() {
      return LendingsList;
    }

    // モデルクラスのsetterメソッドを用いて、dbから得たデータを各カラムに格納する。
    public Lendings mapRow(ResultSet rs, int rowNum) throws SQLException {
      Lendings viewObj = new Lendings();
      viewObj.setBookId(rs.getInt("book_id"));
      viewObj.setLendingStatus(rs.getBoolean("lending_status"));
      viewObj.setLendedAt(rs.getTimestamp("lended_at"));
      viewObj.setDueDate(rs.getDate("due_date"));
      viewObj.setBorrowUserId(rs.getInt("borrow_user_id"));
      // データが格納されたviewObjを返す。
      return viewObj;
    }
  }

}