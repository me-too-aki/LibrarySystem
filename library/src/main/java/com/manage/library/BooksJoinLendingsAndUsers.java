package com.manage.library;

import java.sql.Timestamp;
import java.sql.Date;

// �ꗗ��ʂŎ擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class BooksJoinLendingsAndUsers {

  //�ꗗ��ʂɕ\�����鍀�ځB
  private int bookId;                //�{��ID�B
  private String bookTitle;          //�{�̃^�C�g���B
  private boolean lendingStatus;     //�{�̑ݏo�󋵁B
  private Timestamp lendedAt;        //�{�̑ݏo�����B
  private Date dueDate;              //�{�̕ԋp�\����B
  private String userName;           //�{�̎ؓ��Җ��B

  public BooksJoinLendingsAndUsers() {
  }
  
  //jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
  public int getBookId() {
    return this.bookId;
  }

  public String getBookTitle() {
    return this.bookTitle;
  }

  public boolean getLendingStatus() {
    return this.lendingStatus;
  }

  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  public String getUserName() {
    return this.userName;
  }

  
  //DaoImpl�N���X�Œl������ׂɁAsetter���\�b�h����������B
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void setLendingStatus(boolean lendingStatus) {
    this.lendingStatus = lendingStatus;
  }

  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
