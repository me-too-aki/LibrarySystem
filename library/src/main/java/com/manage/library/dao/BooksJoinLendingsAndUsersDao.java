package com.manage.library.dao;

import java.util.List;
import com.manage.library.BooksJoinLendingsAndUsers;

public interface BooksJoinLendingsAndUsersDao {
  List<BooksJoinLendingsAndUsers> findAll();

  List<BooksJoinLendingsAndUsers> findFromId(int id);
}