package com.manage.library;

import java.sql.Timestamp;

// �擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class LendedHistorysJoinUsers {
	
	private int historyId; // �ݏo������ID�B
	private int bookId; // �{��ID�B
	private Timestamp lendedAt; // �{�̎ؓ��Җ��B
	private Timestamp returnedAt; // �ԋp�����B
	private int borrowUserId; // �ؓ��҂̃��[�UID�B
	private int userId; // ���[�U��ID�B
	private String userName; // ���[�U���B

	// jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
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

	// DaoImpl�N���X�Œl������ׂɁAsetter���\�b�h����������B
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
