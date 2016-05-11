package com.manage.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;

public class LendedHistorysDaoImpl extends JdbcDaoSupport implements LendedHistorysDao {

  public List<LendedHistorys> findAll() throws DataAccessException {

    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys;", rowMapper);
  }

  public List<LendedHistorys> findFromId(int id) {
    RowMapper<LendedHistorys> rowMapper = new LendedHistorysListRowMapper();
    return getJdbcTemplate().query("select * from lended_historys where history_id=" + id + ";", rowMapper);
  }

  protected class LendedHistorysListRowMapper implements RowMapper<LendedHistorys> {

    private List<LendedHistorys> lendedHistorysList = new ArrayList<LendedHistorys>();

    public List<LendedHistorys> getResults() {
      return lendedHistorysList;
    }

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