// パッケージ名。
package com.manage.library;

//必要なライブラリをインポート。
import java.sql.Date;
import java.sql.Timestamp;

//dbのlendingsテーブルのモデルクラス。
public class Lendings {

  // lendingsテーブルのカラム。
  private int bookId;
  private boolean lendingStatus;
  private Timestamp lendedAt;
  private Date dueDate;
  private int borrowUserId;

  // lendingsテーブルからbook_idを取得する為のgetterメソッド。
  public int getBookId() {
    return this.bookId;
  }

  // lendingsテーブルからlending_statusを取得する為のgetterメソッド。
  public boolean getLendingStatus() {
    return this.lendingStatus;
  }

  // lendingsテーブルからlended_atを取得する為のgetterメソッド。
  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  // lendingsテーブルからdue_dateを取得する為のgetterメソッド。
  public Date getDueDate() {
    return this.dueDate;
  }

  // lendingsテーブルからborrow_user_idを取得する為のgetterメソッド。
  public int getBorrowUserId() {
    return this.borrowUserId;
  }

  // book_idに値を挿入するsetterメソッド。
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  // lending_statusに値を挿入するsetterメソッド。
  public void setLendingStatus(boolean lendingStatus) {
    this.lendingStatus = lendingStatus;
  }

  // lended_atに値を挿入するsetterメソッド。
  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  // due_dateに値を挿入するsetterメソッド。
  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  // borrow_user_idに値を挿入するsetterメソッド。
  public void setBorrowUserId(int borrowUserId) {
    this.borrowUserId = borrowUserId;
  }
}
