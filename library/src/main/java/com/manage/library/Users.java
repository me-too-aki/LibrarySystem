/**
 *  モデルクラスのパッケージ。
 */
package com.manage.library;

/**
 * dbのusersテーブルのモデルクラス。
 */
public class Users {

    //  usersテーブルのカラム。
    private int userId;
    private String userName;

    /**
     * userIdを取得する為のgetterメソッド。
     *
     * @return userId
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * userNameを取得する為のgetterメソッド。
     *
     * @return userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * userIdに値を挿入するsetterメソッド。
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * userNameに値を挿入するsetterメソッド。
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
