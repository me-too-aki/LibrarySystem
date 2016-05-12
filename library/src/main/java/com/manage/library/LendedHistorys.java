/**
 *  モデルクラスのパッケージ。
 */
package com.manage.library;

// 必要なライブラリをインポート。
import java.sql.Timestamp;

/**
 * dbのlended_historysテーブルのモデルクラス。
 */
public class LendedHistorys {

    // lended_historysテーブルのカラム。
    private int historyId;
    private int bookId;
    private Timestamp lendedAt;
    private Timestamp returnedAt;
    private int borrowUserId;

    /**
     * historyIdを取得する為のgetterメソッド。
     *
     * @return historyId
     */
    public int getHistoryId() {
        return this.historyId;
    }

    /**
     * bookIdを取得する為のgetterメソッド。
     *
     * @return bookId
     */
    public int getBookId() {
        return this.bookId;
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
     * returnedAtを取得する為のgetterメソッド。
     *
     * @return returnedAt
     */
    public Timestamp getReturnedAt() {
        return this.returnedAt;
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
     * historyIdに値を挿入するsetterメソッド。
     *
     * @param historyId
     */
    public void setHistoryId(int historyId) {
        this.historyId = historyId;
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
     * lendedAtに値を挿入するsetterメソッド。
     *
     * @param lendedAt
     */
    public void setLendedAt(Timestamp lendedAt) {
        this.lendedAt = lendedAt;
    }

    /**
     * returnedAtに値を挿入するsetterメソッド。
     *
     * @param returnedAt
     */
    public void setReturnedAt(Timestamp returnedAt) {
        this.returnedAt = returnedAt;
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
