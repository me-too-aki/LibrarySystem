/**
 *  モデルクラスのパッケージ。
 */
package com.manage.library;

// 必要なライブラリをインポート。
import java.sql.Date;
import java.sql.Timestamp;

/**
 * dbのlendingsテーブルのモデルクラス。
 */
public class Lendings {

    // lendingsテーブルのカラム。
    private int bookId;
    private boolean lendingStatus;
    private Timestamp lendedAt;
    private Date dueDate;
    private int borrowUserId;

    /**
     * bookIdを取得する為のgetterメソッド。
     *
     * @return bookId
     */
    public int getBookId() {
        return this.bookId;
    }

    /**
     * lendingStatusを取得する為のgetterメソッド。
     *
     * @return lendedStatus
     */
    public boolean getLendingStatus() {
        return this.lendingStatus;
    }

    /**
     * lendedAtを取得する為のgetterメソッド。
     *
     * @return lendedAt
     */
    public Timestamp getLendedAt() {
        return this.lendedAt;
    }

    /**
     * dueDateを取得する為のgetterメソッド。
     *
     * @return dueDate
     */
    public Date getDueDate() {
        return this.dueDate;
    }

    /**
     * borrowUserIdを取得する為のgetterメソッド。
     *
     * @return borrowUserId
     */
    public int getBorrowUserId() {
        return this.borrowUserId;
    }

    /**
     * bookIdに値を挿入するsetterメソッド。
     *
     * @param bookId
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * lendingStatusに値を挿入するsetterメソッド。
     *
     * @param lendingStatus
     */
    public void setLendingStatus(boolean lendingStatus) {
        this.lendingStatus = lendingStatus;
    }

    /**
     * lendedAtに値を挿入するsetterメソッド。
     *
     * @param lendedAt
     */
    public void setLendedAt(Timestamp lendedAt) {
        this.lendedAt = lendedAt;
    }

    /**
     * dueDateに値を挿入するsetterメソッド。
     *
     * @param dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * borrowUserIdに値を挿入するsetterメソッド。
     *
     * @param borrowUserId
     */
    public void setBorrowUserId(int borrowUserId) {
        this.borrowUserId = borrowUserId;
    }
}
