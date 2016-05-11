// �p�b�P�[�W���B
package com.manage.library;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.Timestamp;

//db��lended_historys�e�[�u���̃��f���N���X�B
public class LendedHistorys {

  // lended_historys�e�[�u���̃J�����B
  private int historyId;
  private int bookId;
  private Timestamp lendedAt;
  private Timestamp returnedAt;
  private int borrowUserId;

  // lended_historys�e�[�u������history_id���擾����ׂ�getter���\�b�h�B
  public int getHistoryId() {
    return this.historyId;
  }

  // lended_historys�e�[�u������book_id���擾����ׂ�getter���\�b�h�B
  public int getBookId() {
    return this.bookId;
  }

  // lended_historys�e�[�u������lended_at���擾����ׂ�getter���\�b�h�B
  public Timestamp getLendedAt() {
    return this.lendedAt;
  }

  // lended_historys�e�[�u������returned_at���擾����ׂ�getter���\�b�h�B
  public Timestamp getReturnedAt() {
    return this.returnedAt;
  }

  // lended_historys�e�[�u������borrow_user_id���擾����ׂ�getter���\�b�h�B
  public int getBorrowUserId() {
    return this.borrowUserId;
  }

  // history_id�ɒl��}������setter���\�b�h�B
  public void setHistoryId(int historyId) {
    this.historyId = historyId;
  }

  // book_id�ɒl��}������setter���\�b�h�B
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  // lended_at�ɒl��}������setter���\�b�h�B
  public void setLendedAt(Timestamp lendedAt) {
    this.lendedAt = lendedAt;
  }

  // returned_at�ɒl��}������setter���\�b�h�B
  public void setReturnedAt(Timestamp returnedAt) {
    this.returnedAt = returnedAt;
  }

  // borrow_user_id�ɒl��}������setter���\�b�h�B
  public void setBorrowUserId(int borrowUserId) {
    this.borrowUserId = borrowUserId;
  }
}
