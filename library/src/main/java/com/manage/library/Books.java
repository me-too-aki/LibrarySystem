// �p�b�P�[�W���B
package com.manage.library;

// �K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.Date;
import java.sql.Timestamp;

// db��books�e�[�u���̃��f���N���X�B
public class Books {

  // books�e�[�u���̃J�����B
  private int bookId;
  private String bookTitle;
  private String writterName;
  private String publisher;
  private Date publishedAt;
  private int ownerUserId;
  private Timestamp registeredAt;

  // books�e�[�u������book_id���擾����ׂ�getter���\�b�h�B
  public int getBookId() {
    return this.bookId;
  }

  // books�e�[�u������book_title���擾����ׂ�getter���\�b�h�B
  public String getBookTitle() {
    return this.bookTitle;
  }

  // books�e�[�u������wirrter_name���擾����ׂ�getter���\�b�h�B
  public String getWritterName() {
    return this.writterName;
  }

  // books�e�[�u������publisher���擾����ׂ�getter���\�b�h�B
  public String getPublisher() {
    return this.publisher;
  }

  // books�e�[�u������published_at���擾����ׂ�getter���\�b�h�B
  public Date getpublishedAt() {
    return this.publishedAt;
  }

  // books�e�[�u������owner_user_id���擾����ׂ�getter���\�b�h�B
  public int getOwnerUserId() {
    return this.ownerUserId;
  }

  // books�e�[�u������registered_at���擾����ׂ�getter���\�b�h�B
  public Timestamp getRegisteredAt() {
    return this.registeredAt;
  }

  // book_id�ɒl��}������setter���\�b�h�B
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  // book_title�ɒl��}������setter���\�b�h�B
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  // writter_name�ɒl��}������setter���\�b�h�B
  public void setWritterName(String writterName) {
    this.writterName = writterName;
  }

  // publisher�ɒl��}������setter���\�b�h�B
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  // published_at�ɒl��}������setter���\�b�h�B
  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  // owner_user_id�ɒl��}������setter���\�b�h�B
  public void setOwnerUserId(int ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  // registered_at�ɒl��}������setter���\�b�h�B
  public void setRegisteredAt(Timestamp registeredAt) {
    this.registeredAt = registeredAt;
  }

}
