/**
 *  パッケージ名。
 */
package com.manage.library;

/**
 *  必要なライブラリをインポート。
 */
import java.sql.Date;
import java.sql.Timestamp;

/**
 * dbのbooksテーブルのモデルクラス。
 */
public class Books {

  /**
   * booksテーブルのカラム。
   */
  private int bookId;
  private String bookTitle;
  private String writterName;
  private String publisher;
  private Date publishedAt;
  private int ownerUserId;
  private Timestamp registeredAt;

  /**
   * bookIdを取得する為のgetterメソッド。
   * 
   * @return bookId
   */
  public int getBookId() {
    return this.bookId;
  }

  /**
   * bookTitleを取得する為のgetterメソッド。
   * 
   * @return bookTitle
   */
  public String getBookTitle() {
    return this.bookTitle;
  }

  /**
   * writterNameを取得する為のgetterメソッド。
   * 
   * @return writterName
   */
  public String getWritterName() {
    return this.writterName;
  }

  /**
   * publisherを取得する為のgetterメソッド。
   * 
   * @return publisher
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * publishedAtを取得する為のgetterメソッド。
   * 
   * @return publishedAt
   */
  public Date getpublishedAt() {
    return this.publishedAt;
  }

  /**
   * ownerUserIdを取得する為のgetterメソッド。
   * 
   * @return ownerUserId
   */
  public int getOwnerUserId() {
    return this.ownerUserId;
  }

  /**
   * registeredAtを取得する為のgetterメソッド。
   * 
   * @return registeredAt
   */
  public Timestamp getRegisteredAt() {
    return this.registeredAt;
  }

  /**
   * bookIdに値を挿入するsetterメソッド。
   * 
   * @param bookId
   */
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  /**
   * bookTitleに値を挿入するsetterメソッド。
   * 
   * @param bookTitle
   */
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  /**
   * writterNameに値を挿入するsetterメソッド。
   * 
   * @param writterName
   */
  public void setWritterName(String writterName) {
    this.writterName = writterName;
  }

  /**
   * publisherに値を挿入するsetterメソッド。
   * 
   * @param publisher
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * publishedAtに値を挿入するsetterメソッド。
   * 
   * @param publishedAt
   */
  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  /**
   * ownerUserIdに値を挿入するsetterメソッド。
   * 
   * @param ownerUserId
   */
  public void setOwnerUserId(int ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  /**
   * registeredAtに値を挿入するsetterメソッド。
   * 
   * @param registeredAt
   */
  public void setRegisteredAt(Timestamp registeredAt) {
    this.registeredAt = registeredAt;
  }

}
