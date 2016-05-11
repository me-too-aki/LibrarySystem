package com.manage.library.dao;

import java.util.List;
import com.manage.library.Books;

public interface BooksDao {
  List<Books> findAll();

  Books findFromBookId(int bookId);
}