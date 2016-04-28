package com.manage.library;

import java.sql.Timestamp;
import java.sql.Date;

// 一覧画面で取得する値を用意し、getterとsetterを用意するクラス。
public class Home {

  private int bookId;
  private String bookTitle;
  private boolean lendingStatus;
  private Timestamp lendedAt;
  private Date dueDate;
  private String userName;

  public Home(int bookId, String bookTitle, boolean lendingStatus, Timestamp lendedAt, Date dueDate,
      String userName) {
    this.bookId = bookId;
    this.bookTitle = bookTitle;
    this.lendingStatus = lendingStatus;
    this.lendedAt = lendedAt;
    this.dueDate = dueDate;
    this.userName = userName;
  }

  public Home() {
  }

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
