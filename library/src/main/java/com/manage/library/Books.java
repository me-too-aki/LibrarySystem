package com.manage.library;

import java.sql.Date;
import java.sql.Timestamp;

public class Books {

  private int bookId;
  private String bookTitle;
  private String writterName;
  private String publisher;
  private Date publishedAt;
  private int ownerUserId;
  private Timestamp registeredAt;

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
