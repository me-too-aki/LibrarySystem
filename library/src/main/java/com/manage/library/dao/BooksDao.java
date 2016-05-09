package com.manage.library.dao;

import java.util.List;
import com.manage.library.Books;

// リストを得るDaoのインターフェイス。
public interface BooksDao {
  List<Books> findAll();

  Books findFromBookId(int bookId);
}