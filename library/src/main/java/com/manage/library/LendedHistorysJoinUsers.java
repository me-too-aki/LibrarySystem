package com.manage.library;

// �擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class LendedHistorysJoinUsers {

  private LendedHistorys lendedHistorys;
  private Users users;

  // jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
  public LendedHistorys getLendedHistorys() {
    return this.lendedHistorys;
  }

  public Users getUsers() {
    return this.users;
  }

  public void setLendedHistorys(LendedHistorys lendedHistorys) {
    this.lendedHistorys = lendedHistorys;
  }

  public void setUsers(Users users) {
    this.users = users;
  }
}
