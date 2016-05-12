/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

// 必要なライブラリをインポート。

import java.util.List;
import com.manage.library.LendedHistorys;

/**
 * dbのlended_historysテーブルと情報をやり取りするインターフェース。
 */
public interface LendedHistorysDao {
  /**
   * lended_historysテーブルのデータを全て取得する抽象メソッド。
   */
  List<LendedHistorys> findAll();

  /**
   * 対応するidからレコードを取得する抽象メソッド。
   * 
   * @param id
   */
  List<LendedHistorys> findFromId(int id);
}
