// パッケージ名。
package com.manage.library;

//dbのlended_historys,Usersを結合させたビューのモデルクラス。
public class LendedHistorysJoinUsers {

  // 結合した各テーブルのモデルクラスをインスタンス化。
  private LendedHistorys lendedHistorys;
  private Users users;

  // lended_historysテーブルから値を得る為のgetterメソッド。
  public LendedHistorys getLendedHistorys() {
    return this.lendedHistorys;
  }

  // usersテーブルから値を得る為のgetterメソッド。
  public Users getUsers() {
    return this.users;
  }

  // lended_historysテーブルに値を挿入する為のsetterメソッド。
  public void setLendedHistorys(LendedHistorys lendedHistorys) {
    this.lendedHistorys = lendedHistorys;
  }

  // usersテーブルに値を挿入する為のsetterメソッド。
  public void setUsers(Users users) {
    this.users = users;
  }
}
