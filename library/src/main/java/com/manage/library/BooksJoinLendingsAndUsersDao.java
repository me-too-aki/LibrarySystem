package com.manage.library;

import java.util.List;

// �ꗗ��ʂɕ\�����郊�X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface BooksJoinLendingsAndUsersDao {
  List<BooksJoinLendingsAndUsers> findAll();
}