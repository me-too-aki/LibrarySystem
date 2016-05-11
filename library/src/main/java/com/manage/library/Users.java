// パッケージ名。
package com.manage.library;

//dbのbooksテーブルのモデルクラス。
public class Users {

  // booksテーブルのカラム。
  private int userId;
  private String userName;

  // usersテーブルからuser_idを取得する為のgetterメソッド。
  public int getUserId() {
    return this.userId;
  }

  // usersテーブルからuser_nameを取得する為のgetterメソッド。
  public String getUserName() {
    return this.userName;
  }

  // user_idに値を挿入するsetterメソッド。
  public void setUserId(int userId) {
    this.userId = userId;
  }

  // user_nameに値を挿入するsetterメソッド。
  public void setUserName(String userName) {
    this.userName = userName;
  }

}
