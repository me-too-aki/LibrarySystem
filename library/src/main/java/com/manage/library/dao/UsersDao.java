package com.manage.library.dao;

import java.util.List;
import com.manage.library.Users;

public interface UsersDao {
  List<Users> findAll();

  String findUserNameFromUserId(int userId);
}
