/**
 *   Dao�̃p�b�P�[�W�B
 */
package com.manage.library.dao;

// �K�v�ȃ��C�u�������C���|�[�g�B

import java.util.List;
import com.manage.library.Books;

/**
 * db��books�e�[�u���Ə�������肷��C���^�[�t�F�[�X�B
 */
public interface BooksDao {
  /**
   * books�e�[�u���̃f�[�^��S�Ď擾���钊�ۃ��\�b�h�B
   */
  List<Books> findAll();

  /**
   * �Ή�����book_id���烌�R�[�h���擾���钊�ۃ��\�b�h�B
   * 
   * @param bookId
   */
  Books findFromBookId(int bookId);
}