package com.manage.library.dao;

import java.util.List;
import com.manage.library.LendedHistorysJoinUsers;

// リストを得るDaoのインターフェイス。
public interface LendedHistorysJoinUsersDao {
  List<LendedHistorysJoinUsers> findAll();

  List<LendedHistorysJoinUsers> findFromId(int id);
}
