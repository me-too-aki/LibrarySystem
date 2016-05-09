package com.manage.library;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class LendedHistorysJoinUsers {

  private LendedHistorys lendedHistorys;
  private Users users;

  // jspファイル側で値を取得する為に、getterメソッドを実装する。
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
