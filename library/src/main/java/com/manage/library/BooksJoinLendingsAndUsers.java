package com.manage.library;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class BooksJoinLendingsAndUsers {

  private Books books;  //本(books)のテーブル
  private Lendings lendings; //貸出状況(lendings)のテーブル
  private Users users; //ユーザ(users)のテーブル

  // jspファイル側で値を取得する為に、getterメソッドを実装する。
  public Books getBooks() {
    return this.books;
  }

  public Lendings getLendings() {
    return this.lendings;
  }

  public Users getUsers() {
    return this.users;
  }

  // DaoImplクラスで値を入れる為に、setterメソッドを実装する。
  public void setBooks(Books books) {
    this.books = books;
  }

  public void setLendings(Lendings lendings) {
    this.lendings = lendings;
  }

  public void setUsers(Users users) {
    this.users = users;
  }
}
