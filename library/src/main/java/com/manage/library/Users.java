package com.manage.library;

// �擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class Users {

	private int userId; // ���[�U��ID�B
	private String userName; // ���[�U���B

	// jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
	public int getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	// DaoImpl�N���X�Œl������ׂɁAsetter���\�b�h����������B
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
