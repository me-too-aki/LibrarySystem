package com.manage.library.dao;

import java.util.List;
import com.manage.library.Books;

// ���X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface BooksDao {
  List<Books> findAll();

  Books findFromBookId(int bookId);
}