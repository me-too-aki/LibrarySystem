package com.manage.library;

import java.sql.Date;
import java.sql.Timestamp;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class Books {

  private int bookId; // 本のID。
  private String bookTitle; // 本のタイトル。
  private String writterName; // 本の著者名。
  private String publisher; // 本の出版社名。
  private Date publishedAt; // 本の出版日。
  private int ownerUserId; // 本の所有者名。
  private Timestamp registeredAt; // 本の登録日時。

  // jspファイル側で値を取得する為に、getterメソッドを実装する。
  public int getBookId() {
    return this.bookId;
  }

  public String getBookTitle() {
    return this.bookTitle;
  }

  public String getWritterName() {
    return this.writterName;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public Date getpublishedAt() {
    return this.publishedAt;
  }

  public int getOwnerUserId() {
    return this.ownerUserId;
  }

  public Timestamp getRegisteredAt() {
    return this.registeredAt;
  }

  // DaoImplクラスで値を入れる為に、setterメソッドを実装する。
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void setWritterName(String writterName) {
    this.writterName = writterName;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  public void setOwnerUserId(int ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  public void setRegisteredAt(Timestamp registeredAt) {
    this.registeredAt = registeredAt;
  }

}
