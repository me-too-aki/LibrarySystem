package com.manage.library;

import java.sql.Timestamp;
import java.sql.Date;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class BooksJoinLendingsAndUsers {

	private int bookId; // 本のID。
	private String bookTitle; // 本のタイトル。
	private String writterName; // 本の著者名。
	private String publisher; // 本の出版社名。
	private Date publishedAt; // 本の出版日。
	private int ownerUserId; // 本の所有者のユーザID。
	private Timestamp registeredAt; // 本の登録日時。
	private boolean lendingStatus; // 本の貸出状況。
	private Timestamp lendedAt; // 本の貸出日時。
	private Date dueDate; // 本の返却予定日。
	private int borrowUserId; // 本の借入者のユーザID。
	private int userId; // ユーザのID。
	private String userName; // ユーザ名。

	// jspファイル側で値を取得する為に、getterメソッドを実装する。
	public int getBookId() {
		return this.bookId;
	}

	public String getBookTitle() {
		return this.bookTitle;
	}

	public String getWritterName() {
		return this.writterName;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public Date getpublishedAt() {
		return this.publishedAt;
	}

	public int getOwnerUserId() {
		return this.ownerUserId;
	}

	public Timestamp getRegisteredAt() {
		return this.registeredAt;
	}

	public boolean getLendingStatus() {
		return this.lendingStatus;
	}

	public Timestamp getLendedAt() {
		return this.lendedAt;
	}

	public int getBorrowUserId() {
		return this.borrowUserId;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public int getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	// DaoImplクラスで値を入れる為に、setterメソッドを実装する。
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setWritterName(String writterName) {
		this.writterName = writterName;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public void setRegisteredAt(Timestamp registeredAt) {
		this.registeredAt = registeredAt;
	}

	public void setLendingStatus(boolean lendingStatus) {
		this.lendingStatus = lendingStatus;
	}

	public void setLendedAt(Timestamp lendedAt) {
		this.lendedAt = lendedAt;
	}

	public void setBorrowUserId(int borrowUserId) {
		this.borrowUserId = borrowUserId;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
