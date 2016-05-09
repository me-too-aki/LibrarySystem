package com.manage.library;

import java.sql.Date;
import java.sql.Timestamp;

// �擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class Books {

  private int bookId; // �{��ID�B
  private String bookTitle; // �{�̃^�C�g���B
  private String writterName; // �{�̒��Җ��B
  private String publisher; // �{�̏o�ŎЖ��B
  private Date publishedAt; // �{�̏o�œ��B
  private int ownerUserId; // �{�̏��L�Җ��B
  private Timestamp registeredAt; // �{�̓o�^�����B

  // jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
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

  // DaoImpl�N���X�Œl������ׂɁAsetter���\�b�h����������B
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
