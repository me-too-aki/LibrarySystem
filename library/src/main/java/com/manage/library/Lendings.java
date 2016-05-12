/**
 *  ���f���N���X�̃p�b�P�[�W�B
 */
package com.manage.library;

// �K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.Date;
import java.sql.Timestamp;

/**
 * db��lendings�e�[�u���̃��f���N���X�B
 */
public class Lendings {

    // lendings�e�[�u���̃J�����B
    private int bookId;
    private boolean lendingStatus;
    private Timestamp lendedAt;
    private Date dueDate;
    private int borrowUserId;

    /**
     * bookId���擾����ׂ�getter���\�b�h�B
     *
     * @return bookId
     */
    public int getBookId() {
        return this.bookId;
    }

    /**
     * lendingStatus���擾����ׂ�getter���\�b�h�B
     *
     * @return lendedStatus
     */
    public boolean getLendingStatus() {
        return this.lendingStatus;
    }

    /**
     * lendedAt���擾����ׂ�getter���\�b�h�B
     *
     * @return lendedAt
     */
    public Timestamp getLendedAt() {
        return this.lendedAt;
    }

    /**
     * dueDate���擾����ׂ�getter���\�b�h�B
     *
     * @return dueDate
     */
    public Date getDueDate() {
        return this.dueDate;
    }

    /**
     * borrowUserId���擾����ׂ�getter���\�b�h�B
     *
     * @return borrowUserId
     */
    public int getBorrowUserId() {
        return this.borrowUserId;
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
     * lendingStatus�ɒl��}������setter���\�b�h�B
     *
     * @param lendingStatus
     */
    public void setLendingStatus(boolean lendingStatus) {
        this.lendingStatus = lendingStatus;
    }

    /**
     * lendedAt�ɒl��}������setter���\�b�h�B
     *
     * @param lendedAt
     */
    public void setLendedAt(Timestamp lendedAt) {
        this.lendedAt = lendedAt;
    }

    /**
     * dueDate�ɒl��}������setter���\�b�h�B
     *
     * @param dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * borrowUserId�ɒl��}������setter���\�b�h�B
     *
     * @param borrowUserId
     */
    public void setBorrowUserId(int borrowUserId) {
        this.borrowUserId = borrowUserId;
    }
}
