package com.manage.library;

import java.sql.Timestamp;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class LendedHistorysJoinUsers {
	
	private int historyId; // 貸出履歴のID。
	private int bookId; // 本のID。
	private Timestamp lendedAt; // 本の借入者名。
	private Timestamp returnedAt; // 返却日時。
	private int borrowUserId; // 借入者のユーザID。
	private int userId; // ユーザのID。
	private String userName; // ユーザ名。

	// jspファイル側で値を取得する為に、getterメソッドを実装する。
	public int getHistoryId() {
		return this.historyId;
	}

	public int getBookId() {
		return this.bookId;
	}

	public Timestamp getLendedAt() {
		return this.lendedAt;
	}

	public Timestamp getReturnedAt() {
		return this.returnedAt;
	}

	public int getBorrowUserId() {
		return this.borrowUserId;
	}

	public int getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	// DaoImplクラスで値を入れる為に、setterメソッドを実装する。
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setLendedAt(Timestamp lendedAt) {
		this.lendedAt = lendedAt;
	}

	public void setReturnedAt(Timestamp returnedAt) {
		this.returnedAt = returnedAt;
	}

	public void setBorrowUserId(int borrowUserId) {
		this.borrowUserId = borrowUserId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
