/**
 *  �p�b�P�[�W���B
 */
package com.manage.library.dao;

/**
 * �K�v�ȃ��C�u�������C���|�[�g�B
 */
import java.util.List;
import com.manage.library.Users;

/**
 * db��books�e�[�u���Ƃ̏�������肷��ׂ�Dao�C���^�[�t�F�[�X�B
 */
public interface UsersDao {
/**
 * users�e�[�u���̃f�[�^��S�Ď擾���钊�ۃ��\�b�h�B
 */
  List<Users> findAll();

/**
 * �Ή�����user_id���烌�R�[�h���擾���钊�ۃ��\�b�h�B
 * @param userId
 */
  String findUserNameFromUserId(int userId);
}
