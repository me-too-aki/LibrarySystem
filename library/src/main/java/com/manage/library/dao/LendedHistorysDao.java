// �p�b�P�[�W���B
package com.manage.library.dao;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.util.List;
import com.manage.library.LendedHistorys;

//db��lended_historys�e�[�u���Ƃ̏�������肷��ׂ�Dao�C���^�[�t�F�[�X�B
public interface LendedHistorysDao {
  // lended_historys�e�[�u���̃f�[�^��S�Ď擾���钊�ۃ��\�b�h�B
  List<LendedHistorys> findAll();

//�Ή�����id���烌�R�[�h���擾���钊�ۃ��\�b�h�B
  List<LendedHistorys> findFromId(int id);
}
