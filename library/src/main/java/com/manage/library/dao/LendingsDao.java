// パッケージ名。
package com.manage.library.dao;

//必要なライブラリをインポート。
import java.util.List;
import com.manage.library.Lendings;

//dbのlendingsテーブルとの情報をやり取りする為のDaoインターフェース。
public interface LendingsDao {
  // lendingsテーブルのデータを全て取得する抽象メソッド。
  List<Lendings> findAll();

  // 対応するidからレコードを取得する抽象メソッド。
  List<Lendings> findFromId(int id);
}
