// �p�b�P�[�W���B
package com.manage.library;

//db��lended_historys,Users�������������r���[�̃��f���N���X�B
public class LendedHistorysJoinUsers {

  // ���������e�e�[�u���̃��f���N���X���C���X�^���X���B
  private LendedHistorys lendedHistorys;
  private Users users;

  // lended_historys�e�[�u������l�𓾂�ׂ�getter���\�b�h�B
  public LendedHistorys getLendedHistorys() {
    return this.lendedHistorys;
  }

  // users�e�[�u������l�𓾂�ׂ�getter���\�b�h�B
  public Users getUsers() {
    return this.users;
  }

  // lended_historys�e�[�u���ɒl��}������ׂ�setter���\�b�h�B
  public void setLendedHistorys(LendedHistorys lendedHistorys) {
    this.lendedHistorys = lendedHistorys;
  }

  // users�e�[�u���ɒl��}������ׂ�setter���\�b�h�B
  public void setUsers(Users users) {
    this.users = users;
  }
}
