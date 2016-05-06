package com.manage.library.dao;

import java.util.List;
import com.manage.library.BooksJoinLendingsAndUsers;

// リストを得るDaoのインターフェイス。
public interface BooksJoinLendingsAndUsersDao {
	List<BooksJoinLendingsAndUsers> findAll();

	List<BooksJoinLendingsAndUsers> findFromId(int id);
}