package com.manage.library;

import java.util.List;

// 一覧画面に表示するリストを得るDaoのインターフェイス。
public interface BooksJoinLendingsAndUsersDao {
  List<BooksJoinLendingsAndUsers> findAll();
}