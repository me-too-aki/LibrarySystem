package com.manage.library;

import java.sql.Timestamp;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class LendedHistorys {

  private int historyId; // 貸出履歴のID。
  private int bookId; // 本のID。
  private Timestamp lendedAt; // 貸出日時。
  private Timestamp returnedAt; // 返却日時。
  private int borrowUserId; // 借入者のユーザID。

  // jspファイル側で値を取得する為に、getterメソッドを実装する。
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

  // DaoImplクラスで値を入れる為に、setterメソッドを実装する。
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
