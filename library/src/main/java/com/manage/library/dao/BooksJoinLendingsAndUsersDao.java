/**
 *  �p�b�P�[�W���B
 */
package com.manage.library.dao;

/**
 * �K�v�ȃ��C�u�������C���|�[�g�B
 */
import java.util.List;
import com.manage.library.BooksJoinLendingsAndUsers;

/**
 * books,Lending,Users�����������r���[�Ə�������肷��ׂ�Dao�C���^�[�t�F�[�X�B
 */
public interface BooksJoinLendingsAndUsersDao {
  /**
   * �r���[�̃f�[�^��S�Ď擾���钊�ۃ��\�b�h�B
   */
  List<BooksJoinLendingsAndUsers> findAll();

  /**
   * �Ή�����id���烌�R�[�h���擾���钊�ۃ��\�b�h�B
   * 
   * @param id
   */
  List<BooksJoinLendingsAndUsers> findFromId(int id);
}