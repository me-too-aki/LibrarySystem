package com.manage.library;

import java.sql.Timestamp;
import java.sql.Date;

// 一覧画面で取得する値を用意し、getterとsetterを用意するクラス。
public class BooksJoinLendingsAndUsers {

  //一覧画面に表示する項目。
  private int bookId;                //本のID。
  private String bookTitle;          //本のタイトル。
  private boolean lendingStatus;     //本の貸出状況。
  private Timestamp lendedAt;        //本の貸出日時。
  private Date dueDate;              //本の返却予定日。
  private String userName;           //本の借入者名。

  public BooksJoinLendingsAndUsers() {
  }
  
  //jspファイル側で値を取得する為に、getterメソッドを実装する。
  public int getBookId() {
    return this.bookId;
  }

  public String getBookTitle() {
    return this.bookTitle;
  }

  public boolean getLendingStatus() {
    return this.lendingStatus;
  }

  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  public String getUserName() {
    return this.userName;
  }

  
  //DaoImplクラスで値を入れる為に、setterメソッドを実装する。
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void setLendingStatus(boolean lendingStatus) {
    this.lendingStatus = lendingStatus;
  }

  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
