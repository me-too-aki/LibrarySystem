package com.manage.library;

import java.sql.Date;
import java.sql.Timestamp;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class Lendings {
	
	private int bookId; // 本のID。
	private boolean lendingStatus; // 本の貸出状況。
	private Timestamp lendedAt; // 本の貸出日時。
	private Date dueDate; // 本の返却予定日。
	private int borrowUserId; // 本の借入者のID。

	// jspファイル側で値を取得する為に、getterメソッドを実装する。
	public int getBookId() {
		return this.bookId;
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

	public int getBorrowUserId() {
		return this.borrowUserId;
	}

	// DaoImplクラスで値を入れる為に、setterメソッドを実装する。
	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public void setBorrowUserId(int borrowUserId) {
		this.borrowUserId = borrowUserId;
	}

}
