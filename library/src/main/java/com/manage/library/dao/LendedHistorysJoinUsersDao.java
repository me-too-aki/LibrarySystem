package com.manage.library.dao;

import java.util.List;
import com.manage.library.LendedHistorysJoinUsers;

// ���X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface LendedHistorysJoinUsersDao {
  List<LendedHistorysJoinUsers> findAll();

  List<LendedHistorysJoinUsers> findFromId(int id);
}
