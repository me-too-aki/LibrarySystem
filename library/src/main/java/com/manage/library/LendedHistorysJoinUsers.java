/**
 *  パッケージ名。
 */
package com.manage.library;

/**
 * dbのlended_historys,usersを結合させたビューのモデルクラス。
 */
public class LendedHistorysJoinUsers {

  /**
   *  結合した各テーブルのモデルクラスをインスタンス化。
   */
  private LendedHistorys lendedHistorys;
  private Users users;

  /**
   *  LendedHistorysクラスから値を得る為のgetterメソッド。
   * @return lendedHistorys
   */
  public LendedHistorys getLendedHistorys() {
    return this.lendedHistorys;
  }

  /**
   *  Usersクラスから値を得る為のgetterメソッド。
   * @return users
   */
  public Users getUsers() {
    return this.users;
  }

  /**
   *  lendedHistorysクラスに値を挿入する為のsetterメソッド。
   * @param lendedHistorys
   */
  public void setLendedHistorys(LendedHistorys lendedHistorys) {
    this.lendedHistorys = lendedHistorys;
  }

  /**
   *  usersクラスに値を挿入する為のsetterメソッド。
   * @param users
   */
  public void setUsers(Users users) {
    this.users = users;
  }
}
