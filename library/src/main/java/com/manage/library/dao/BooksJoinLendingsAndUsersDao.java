package com.manage.library.dao;

import java.util.List;
import com.manage.library.BooksJoinLendingsAndUsers;

// ���X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface BooksJoinLendingsAndUsersDao {
	List<BooksJoinLendingsAndUsers> findAll();

	List<BooksJoinLendingsAndUsers> findFromId(int id);
}