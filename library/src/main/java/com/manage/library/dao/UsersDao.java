package com.manage.library.dao;

import java.util.List;
import com.manage.library.Users;

// ���X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface UsersDao {
  List<Users> findAll();

  String findUserNameFromUserId(int userId);
}
