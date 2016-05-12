/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

// 必要なライブラリをインポート。

import java.util.List;
import com.manage.library.Users;

/**
 * dbのusersテーブルと情報をやり取りするインターフェース。
 */
public interface UsersDao {
  /**
   * usersテーブルのデータを全て取得する抽象メソッド。
   */
  List<Users> findAll();

  /**
   * 対応するuser_idからレコードを取得する抽象メソッド。
   * 
   * @param userId
   */
  String findUserNameFromUserId(int userId);
}
