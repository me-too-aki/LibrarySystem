package com.manage.library;

public class LendedHistorysJoinUsers {

  private LendedHistorys lendedHistorys;
  private Users users;

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
