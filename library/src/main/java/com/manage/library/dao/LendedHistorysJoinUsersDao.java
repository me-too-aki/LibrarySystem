/**
 *  Dao�̃p�b�P�[�W�B
 */
package com.manage.library.dao;

// �K�v�ȃ��C�u�������C���|�[�g�B

import java.util.List;
import com.manage.library.LendedHistorysJoinUsers;

/**
 * books,Lending,Users�����������r���[�Ə�������肷��C���^�[�t�F�[�X�B
 */
public interface LendedHistorysJoinUsersDao {
  /**
   * �r���[�̃f�[�^��S�Ď擾���钊�ۃ��\�b�h�B
   */
  List<LendedHistorysJoinUsers> findAll();

  /**
   * �Ή�����id���烌�R�[�h���擾���钊�ۃ��\�b�h�B
   * 
   * @param id
   */
  List<LendedHistorysJoinUsers> findFromId(int id);
}
