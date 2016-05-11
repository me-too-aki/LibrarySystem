package com.manage.library;

import java.sql.Timestamp;

public class LendedHistorys {

  private int historyId;
  private int bookId;
  private Timestamp lendedAt;
  private Timestamp returnedAt;
  private int borrowUserId;

  public int getHistoryId() {
    return this.historyId;
  }

  public int getBookId() {
    return this.bookId;
  }

  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  public Timestamp getReturnedAt() {
    return this.returnedAt;
  }

  public int getBorrowUserId() {
    return this.borrowUserId;
  }

  public void setHistoryId(int historyId) {
    this.historyId = historyId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  public void setReturnedAt(Timestamp returnedAt) {
    this.returnedAt = returnedAt;
  }

  public void setBorrowUserId(int borrowUserId) {
    this.borrowUserId = borrowUserId;
  }

}
