/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

// 必要なライブラリをインポート。

import java.util.List;
import com.manage.library.LendedHistorysJoinUsers;

/**
 * books,Lending,Usersを結合したビューと情報をやり取りするインターフェース。
 */
public interface LendedHistorysJoinUsersDao {
  /**
   * ビューのデータを全て取得する抽象メソッド。
   */
  List<LendedHistorysJoinUsers> findAll();

  /**
   * 対応するidからレコードを取得する抽象メソッド。
   * 
   * @param id
   */
  List<LendedHistorysJoinUsers> findFromId(int id);
}
