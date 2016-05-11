// パッケージ名。
package com.manage.library.dao;

//必要なライブラリをインポート。
import java.util.List;
import com.manage.library.LendedHistorysJoinUsers;

//books,Lending,Usersを結合したビューと情報をやり取りする為のDaoインターフェース。
public interface LendedHistorysJoinUsersDao {
  // ビューのデータを全て取得する抽象メソッド。
  List<LendedHistorysJoinUsers> findAll();

  // 対応するidからレコードを取得する抽象メソッド。
  List<LendedHistorysJoinUsers> findFromId(int id);
}
