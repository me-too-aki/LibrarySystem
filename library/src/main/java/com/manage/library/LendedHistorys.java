// パッケージ名。
package com.manage.library;

//必要なライブラリをインポート。
import java.sql.Timestamp;

//dbのlended_historysテーブルのモデルクラス。
public class LendedHistorys {

  // lended_historysテーブルのカラム。
  private int historyId;
  private int bookId;
  private Timestamp lendedAt;
  private Timestamp returnedAt;
  private int borrowUserId;

  // lended_historysテーブルからhistory_idを取得する為のgetterメソッド。
  public int getHistoryId() {
    return this.historyId;
  }

  // lended_historysテーブルからbook_idを取得する為のgetterメソッド。
  public int getBookId() {
    return this.bookId;
  }

  // lended_historysテーブルからlended_atを取得する為のgetterメソッド。
  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  // lended_historysテーブルからreturned_atを取得する為のgetterメソッド。
  public Timestamp getReturnedAt() {
    return this.returnedAt;
  }

  // lended_historysテーブルからborrow_user_idを取得する為のgetterメソッド。
  public int getBorrowUserId() {
    return this.borrowUserId;
  }

  // history_idに値を挿入するsetterメソッド。
  public void setHistoryId(int historyId) {
    this.historyId = historyId;
  }

  // book_idに値を挿入するsetterメソッド。
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  // lended_atに値を挿入するsetterメソッド。
  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  // returned_atに値を挿入するsetterメソッド。
  public void setReturnedAt(Timestamp returnedAt) {
    this.returnedAt = returnedAt;
  }

  // borrow_user_idに値を挿入するsetterメソッド。
  public void setBorrowUserId(int borrowUserId) {
    this.borrowUserId = borrowUserId;
  }
}
