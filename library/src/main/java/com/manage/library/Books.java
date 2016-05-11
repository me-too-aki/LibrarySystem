// パッケージ名。
package com.manage.library;

// 必要なライブラリをインポート。
import java.sql.Date;
import java.sql.Timestamp;

// dbのbooksテーブルのモデルクラス。
public class Books {

  // booksテーブルのカラム。
  private int bookId;
  private String bookTitle;
  private String writterName;
  private String publisher;
  private Date publishedAt;
  private int ownerUserId;
  private Timestamp registeredAt;

  // booksテーブルからbook_idを取得する為のgetterメソッド。
  public int getBookId() {
    return this.bookId;
  }

  // booksテーブルからbook_titleを取得する為のgetterメソッド。
  public String getBookTitle() {
    return this.bookTitle;
  }

  // booksテーブルからwirrter_nameを取得する為のgetterメソッド。
  public String getWritterName() {
    return this.writterName;
  }

  // booksテーブルからpublisherを取得する為のgetterメソッド。
  public String getPublisher() {
    return this.publisher;
  }

  // booksテーブルからpublished_atを取得する為のgetterメソッド。
  public Date getpublishedAt() {
    return this.publishedAt;
  }

  // booksテーブルからowner_user_idを取得する為のgetterメソッド。
  public int getOwnerUserId() {
    return this.ownerUserId;
  }

  // booksテーブルからregistered_atを取得する為のgetterメソッド。
  public Timestamp getRegisteredAt() {
    return this.registeredAt;
  }

  // book_idに値を挿入するsetterメソッド。
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  // book_titleに値を挿入するsetterメソッド。
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  // writter_nameに値を挿入するsetterメソッド。
  public void setWritterName(String writterName) {
    this.writterName = writterName;
  }

  // publisherに値を挿入するsetterメソッド。
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  // published_atに値を挿入するsetterメソッド。
  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  // owner_user_idに値を挿入するsetterメソッド。
  public void setOwnerUserId(int ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  // registered_atに値を挿入するsetterメソッド。
  public void setRegisteredAt(Timestamp registeredAt) {
    this.registeredAt = registeredAt;
  }

}
