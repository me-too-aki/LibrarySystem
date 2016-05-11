// パッケージ名。
package com.manage.library;

//dbのbooks,lendings,Usersを結合させたビューのモデルクラス。
public class BooksJoinLendingsAndUsers {

  // 結合した各テーブルのモデルクラスをインスタンス化。
  private Books books;
  private Lendings lendings;
  private Users users;

  // booksテーブルから値を得る為のgetterメソッド。
  public Books getBooks() {
    return this.books;
  }

  // lendingsテーブルから値を得る為のgetterメソッド。
  public Lendings getLendings() {
    return this.lendings;
  }

  // usersテーブルから値を得る為のgetterメソッド。
  public Users getUsers() {
    return this.users;
  }

  // booksテーブルに値を挿入する為のsetterメソッド。
  public void setBooks(Books books) {
    this.books = books;
  }

  // lendingsテーブルに値を挿入する為のsetterメソッド。
  public void setLendings(Lendings lendings) {
    this.lendings = lendings;
  }

  // usersテーブルに値を挿入する為のsetterメソッド。
  public void setUsers(Users users) {
    this.users = users;
  }
}
