/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

// 必要なライブラリをインポート。

import java.util.List;
import com.manage.library.Lendings;

/**
 * dbのlendingsテーブルと情報をやり取りするインターフェース。
 */
public interface LendingsDao {
  /**
   * lendingsテーブルのデータを全て取得する抽象メソッド。
   */
  List<Lendings> findAll();

  /**
   * 対応するidからレコードを取得する抽象メソッド。
   * 
   * @param id
   */
  List<Lendings> findFromId(int id);
}
