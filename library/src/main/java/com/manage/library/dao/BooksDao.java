/**
 *   Daoのパッケージ。
 */
package com.manage.library.dao;

// 必要なライブラリをインポート。

import java.util.List;
import com.manage.library.Books;

/**
 * dbのbooksテーブルと情報をやり取りするインターフェース。
 */
public interface BooksDao {
  /**
   * booksテーブルのデータを全て取得する抽象メソッド。
   */
  List<Books> findAll();

  /**
   * 対応するbook_idからレコードを取得する抽象メソッド。
   * 
   * @param bookId
   */
  Books findFromBookId(int bookId);
}