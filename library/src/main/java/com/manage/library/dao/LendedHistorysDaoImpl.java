package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;

//Daoの実装クラス。
//sql文を発行し、リストに詰める為のRowMapperを用意する。
public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  // dbから得たデータを、RowMapperを用いてリストに格納し、返す。
  // 例外が発生した場合は、元のメソッドに例外処理を移譲する。
  // テーブルからデータを全て拾ってくるメソッド。
  public List<LendedHistorys> findAll() throws DataAccessException {

    // sql文の結果を、RowMapperオブジェクトの形で返す。
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  // テーブルから、対応するデータを拾ってくるメソッド
  public List<LendedHistorys> findFromId(int id) {
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();

    // 戻り値としてリスト型で結果を返す。
    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

    // dbから得たデータ(ResultSet型)を、LendedHistorys型インスタンスにそれぞれ格納し、返す。
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