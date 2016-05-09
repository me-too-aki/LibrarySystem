package com.manage.library.dao;

import java.util.List;
import com.manage.library.Users;

// リストを得るDaoのインターフェイス。
public interface UsersDao {
  List<Users> findAll();

  String findUserNameFromUserId(int userId);
}
