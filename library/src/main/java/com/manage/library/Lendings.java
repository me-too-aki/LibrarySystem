package com.manage.library;

import java.sql.Date;
import java.sql.Timestamp;

public class Lendings {

  private int bookId;
  private boolean lendingStatus;
  private Timestamp lendedAt;
  private Date dueDate;
  private int borrowUserId;

  public int getBookId() {
    return this.bookId;
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

  public int getBorrowUserId() {
    return this.borrowUserId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
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

  public void setBorrowUserId(int borrowUserId) {
    this.borrowUserId = borrowUserId;
  }

}
