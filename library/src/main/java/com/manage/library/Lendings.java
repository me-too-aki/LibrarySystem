// �p�b�P�[�W���B
package com.manage.library;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.Date;
import java.sql.Timestamp;

//db��lendings�e�[�u���̃��f���N���X�B
public class Lendings {

  // lendings�e�[�u���̃J�����B
  private int bookId;
  private boolean lendingStatus;
  private Timestamp lendedAt;
  private Date dueDate;
  private int borrowUserId;

  // lendings�e�[�u������book_id���擾����ׂ�getter���\�b�h�B
  public int getBookId() {
    return this.bookId;
  }

  // lendings�e�[�u������lending_status���擾����ׂ�getter���\�b�h�B
  public boolean getLendingStatus() {
    return this.lendingStatus;
  }

  // lendings�e�[�u������lended_at���擾����ׂ�getter���\�b�h�B
  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  // lendings�e�[�u������due_date���擾����ׂ�getter���\�b�h�B
  public Date getDueDate() {
    return this.dueDate;
  }

  // lendings�e�[�u������borrow_user_id���擾����ׂ�getter���\�b�h�B
  public int getBorrowUserId() {
    return this.borrowUserId;
  }

  // book_id�ɒl��}������setter���\�b�h�B
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  // lending_status�ɒl��}������setter���\�b�h�B
  public void setLendingStatus(boolean lendingStatus) {
    this.lendingStatus = lendingStatus;
  }

  // lended_at�ɒl��}������setter���\�b�h�B
  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  // due_date�ɒl��}������setter���\�b�h�B
  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  // borrow_user_id�ɒl��}������setter���\�b�h�B
  public void setBorrowUserId(int borrowUserId) {
    this.borrowUserId = borrowUserId;
  }
}
