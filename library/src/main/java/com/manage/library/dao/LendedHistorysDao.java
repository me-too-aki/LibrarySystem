// パッケージ名。
package com.manage.library.dao;

//必要なライブラリをインポート。
import java.util.List;
import com.manage.library.LendedHistorys;

//dbのlended_historysテーブルとの情報をやり取りする為のDaoインターフェース。
public interface LendedHistorysDao {
  // lended_historysテーブルのデータを全て取得する抽象メソッド。
  List<LendedHistorys> findAll();

//対応するidからレコードを取得する抽象メソッド。
  List<LendedHistorys> findFromId(int id);
}
