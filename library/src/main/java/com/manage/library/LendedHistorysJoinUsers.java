/**
 *  モデルクラスのパッケージ。
 */
package com.manage.library;

/**
 * dbのlended_historys,usersを結合したビューのモデルクラス。
 */
public class LendedHistorysJoinUsers {

    // 結合した各テーブルのモデルクラスをインスタンス化する。
    private LendedHistorys lendedHistorys;
    private Users users;

    /**
     * lendedHistorysの値を得る為のgetterメソッド。
     *
     * @return lendedHistorys
     */
    public LendedHistorys getLendedHistorys() {
        return this.lendedHistorys;
    }

    /**
     * usersの値を得る為のgetterメソッド。
     *
     * @return users
     */
    public Users getUsers() {
        return this.users;
    }

    /**
     * lendedHistorysに値を挿入する為のsetterメソッド。
     *
     * @param lendedHistorys
     */
    public void setLendedHistorys(LendedHistorys lendedHistorys) {
        this.lendedHistorys = lendedHistorys;
    }

    /**
     * usersに値を挿入する為のsetterメソッド。
     *
     * @param users
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
