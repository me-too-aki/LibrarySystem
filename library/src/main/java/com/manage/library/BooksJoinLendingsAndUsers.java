/**
 *  パッケージ名。
 */
package com.manage.library;

/**
 * dbのbooks,lendings,usersを結合させたビューのモデルクラス。
 */
public class BooksJoinLendingsAndUsers {

  /**
   * 結合した各テーブルのモデルクラスをインスタンス化。
   */
  private Books books;
  private Lendings lendings;
  private Users users;

  /**
   * Booksクラスから値を得る為のgetterメソッド。
   * 
   * @return books
   */
  public Books getBooks() {
    return this.books;
  }

  /**
   * Lendingsクラスから値を得る為のgetterメソッド。
   * 
   * @return lendings
   */
  public Lendings getLendings() {
    return this.lendings;
  }

  /**
   * Usersクラスから値を得る為のgetterメソッド。
   * 
   * @return users
   */
  public Users getUsers() {
    return this.users;
  }

  /**
   * Booksクラスに値を挿入する為のsetterメソッド。
   * 
   * @param books
   */
  public void setBooks(Books books) {
    this.books = books;
  }

  /**
   * Lendingsクラスに値を挿入する為のsetterメソッド。
   * 
   * @param lendings
   */
  public void setLendings(Lendings lendings) {
    this.lendings = lendings;
  }

  /**
   * Usersクラスに値を挿入する為のsetterメソッド。
   * 
   * @param users
   */
  public void setUsers(Users users) {
    this.users = users;
  }
}
