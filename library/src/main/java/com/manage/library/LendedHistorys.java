/**
 *  ���f���N���X�̃p�b�P�[�W�B
 */
package com.manage.library;

// �K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.Timestamp;

/**
 * db��lended_historys�e�[�u���̃��f���N���X�B
 */
public class LendedHistorys {

    // lended_historys�e�[�u���̃J�����B
    private int historyId;
    private int bookId;
    private Timestamp lendedAt;
    private Timestamp returnedAt;
    private int borrowUserId;

    /**
     * historyId���擾����ׂ�getter���\�b�h�B
     *
     * @return historyId
     */
    public int getHistoryId() {
        return this.historyId;
    }

    /**
     * bookId���擾����ׂ�getter���\�b�h�B
     *
     * @return bookId
     */
    public int getBookId() {
        return this.bookId;
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
     * returnedAt���擾����ׂ�getter���\�b�h�B
     *
     * @return returnedAt
     */
    public Timestamp getReturnedAt() {
        return this.returnedAt;
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
     * historyId�ɒl��}������setter���\�b�h�B
     *
     * @param historyId
     */
    public void setHistoryId(int historyId) {
        this.historyId = historyId;
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
     * lendedAt�ɒl��}������setter���\�b�h�B
     *
     * @param lendedAt
     */
    public void setLendedAt(Timestamp lendedAt) {
        this.lendedAt = lendedAt;
    }

    /**
     * returnedAt�ɒl��}������setter���\�b�h�B
     *
     * @param returnedAt
     */
    public void setReturnedAt(Timestamp returnedAt) {
        this.returnedAt = returnedAt;
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
