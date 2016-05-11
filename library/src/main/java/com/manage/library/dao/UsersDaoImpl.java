// パッケージ名。
package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

/**
 * ユーザテーブルとの実際のデータのやり取りを記載するDAO実装クラス
 */
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

  /**
   * ユーザテーブルの全レコードを取得するメソッド
   * @return ユーザテーブルの全レコードリスト
   */
  public List<Users> findAll() throws DataAccessException {

    RowMapper<Users> rowMapper = new UsersListRowMapper();
    return getJdbcTemplate().query("select * from users;", rowMapper);
  }

  /**
   * ユーザテーブルの対応するidから1レコードを取得するメソッド
   * @return ユーザテーブルのレコード
   */
  public String findUserNameFromUserId(int userId) {
    if (userId != 0) {
      return getJdbcTemplate().queryForObject("select user_name from users where user_id=" + userId + ";",
          String.class);
    } else {
      return "";
    }
  }

  protected class UsersListRowMapper implements RowMapper<Users> {

    private List<Users> UsersList = new ArrayList<Users>();

    public List<Users> getResults() {
      return UsersList;
    }

    /**
     * モデルクラスのsetterメソッドを用いて、dbから得たデータを各カラムに格納するメソッド
     * @return データを格納したオブジェクト
     */
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
      Users viewObj = new Users();
      viewObj.setUserId(rs.getInt("user_id"));
      viewObj.setUserName(rs.getString("user_name"));
      return viewObj;
    }
  }
}