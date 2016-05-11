/**
 *  パッケージ名。
 */
package com.manage.library.dao;

/**
 * 必要なライブラリをインポート。
 */
import java.util.List;
import com.manage.library.BooksJoinLendingsAndUsers;

/**
 * books,Lending,Usersを結合したビューと情報をやり取りする為のDaoインターフェース。
 */
public interface BooksJoinLendingsAndUsersDao {
  /**
   * ビューのデータを全て取得する抽象メソッド。
   */
  List<BooksJoinLendingsAndUsers> findAll();

  /**
   * 対応するidからレコードを取得する抽象メソッド。
   * 
   * @param id
   */
  List<BooksJoinLendingsAndUsers> findFromId(int id);
}