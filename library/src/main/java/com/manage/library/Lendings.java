package com.manage.library;

import java.sql.Date;
import java.sql.Timestamp;

// �擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class Lendings {
	
	private int bookId; // �{��ID�B
	private boolean lendingStatus; // �{�̑ݏo�󋵁B
	private Timestamp lendedAt; // �{�̑ݏo�����B
	private Date dueDate; // �{�̕ԋp�\����B
	private int borrowUserId; // �{�̎ؓ��҂�ID�B

	// jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
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

	// DaoImpl�N���X�Œl������ׂɁAsetter���\�b�h����������B
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
