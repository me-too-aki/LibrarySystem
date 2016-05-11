/**
 *  �p�b�P�[�W���B
 */
package com.manage.library;

/**
 *  �K�v�ȃ��C�u�������C���|�[�g�B
 */
import java.sql.Date;
import java.sql.Timestamp;

/**
 * db��books�e�[�u���̃��f���N���X�B
 */
public class Books {

  /**
   * books�e�[�u���̃J�����B
   */
  private int bookId;
  private String bookTitle;
  private String writterName;
  private String publisher;
  private Date publishedAt;
  private int ownerUserId;
  private Timestamp registeredAt;

  /**
   * bookId���擾����ׂ�getter���\�b�h�B
   * 
   * @return bookId
   */
  public int getBookId() {
    return this.bookId;
  }

  /**
   * bookTitle���擾����ׂ�getter���\�b�h�B
   * 
   * @return bookTitle
   */
  public String getBookTitle() {
    return this.bookTitle;
  }

  /**
   * writterName���擾����ׂ�getter���\�b�h�B
   * 
   * @return writterName
   */
  public String getWritterName() {
    return this.writterName;
  }

  /**
   * publisher���擾����ׂ�getter���\�b�h�B
   * 
   * @return publisher
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * publishedAt���擾����ׂ�getter���\�b�h�B
   * 
   * @return publishedAt
   */
  public Date getpublishedAt() {
    return this.publishedAt;
  }

  /**
   * ownerUserId���擾����ׂ�getter���\�b�h�B
   * 
   * @return ownerUserId
   */
  public int getOwnerUserId() {
    return this.ownerUserId;
  }

  /**
   * registeredAt���擾����ׂ�getter���\�b�h�B
   * 
   * @return registeredAt
   */
  public Timestamp getRegisteredAt() {
    return this.registeredAt;
  }

  /**
   * bookId�ɒl��}������setter���\�b�h�B
   * 
   * @param bookId
   */
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  /**
   * bookTitle�ɒl��}������setter���\�b�h�B
   * 
   * @param bookTitle
   */
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  /**
   * writterName�ɒl��}������setter���\�b�h�B
   * 
   * @param writterName
   */
  public void setWritterName(String writterName) {
    this.writterName = writterName;
  }

  /**
   * publisher�ɒl��}������setter���\�b�h�B
   * 
   * @param publisher
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * publishedAt�ɒl��}������setter���\�b�h�B
   * 
   * @param publishedAt
   */
  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  /**
   * ownerUserId�ɒl��}������setter���\�b�h�B
   * 
   * @param ownerUserId
   */
  public void setOwnerUserId(int ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  /**
   * registeredAt�ɒl��}������setter���\�b�h�B
   * 
   * @param registeredAt
   */
  public void setRegisteredAt(Timestamp registeredAt) {
    this.registeredAt = registeredAt;
  }

}
