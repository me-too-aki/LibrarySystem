package com.manage.library.dao;

import java.util.List;
import com.manage.library.LendedHistorys;

public interface LendedHistorysDao {
  List<LendedHistorys> findAll();

  List<LendedHistorys> findFromId(int id);
}
