// �p�b�P�[�W���B
package com.manage.library.dao;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.util.List;
import com.manage.library.Lendings;

//db��lendings�e�[�u���Ƃ̏�������肷��ׂ�Dao�C���^�[�t�F�[�X�B
public interface LendingsDao {
  // lendings�e�[�u���̃f�[�^��S�Ď擾���钊�ۃ��\�b�h�B
  List<Lendings> findAll();

  // �Ή�����id���烌�R�[�h���擾���钊�ۃ��\�b�h�B
  List<Lendings> findFromId(int id);
}
