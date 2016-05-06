package com.manage.library.dao;

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

// Daoの実装クラス。
// sql文を発行し、リストに詰める為のRowMapperを用意する。
public class LendedHistorysJoinUsersDaoImpl extends JdbcDaoSupport implements LendedHistorysJoinUsersDao {

  // dbから得たデータを、RowMapperを用いてリストに格納し、返す。
  // 例外が発生した場合は、元のメソッドに例外処理を移譲する。
  // joinしたテーブルからデータを全て拾ってくるメソッド。
  public List<LendedHistorysJoinUsers> findAll() throws DataAccessException {
    // sql文の結果を、RowMapperオブジェクトの形で返す。
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys inner join users on borrow_user_id = user_id;",
        rowMapper);
  }

  // joinしたテーブルから、対応するデータを拾ってくるメソッド
  public List<LendedHistorysJoinUsers> findFromId(int id) {
    RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from lended_historys inner join users on borrow_user_id = user_id where book_id=" + id + ";",
        rowMapper);
  }

  protected class HomeListRowMapper implements RowMapper<LendedHistorysJoinUsers> {

    private List<LendedHistorysJoinUsers> bookList = new ArrayList<LendedHistorysJoinUsers>();

    // 戻り値としてリスト型で結果を返す。
    public List<LendedHistorysJoinUsers> getResults() {
      return bookList;
    }

    // dbから得たデータ(ResultSet型)を、インスタンスにそれぞれ格納し、返す。
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