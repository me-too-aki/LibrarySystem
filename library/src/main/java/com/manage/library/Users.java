package com.manage.library;

// 取得する値を用意し、getterとsetterを用意するクラス。
public class Users {

	private int userId; // ユーザのID。
	private String userName; // ユーザ名。

	// jspファイル側で値を取得する為に、getterメソッドを実装する。
	public int getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	// DaoImplクラスで値を入れる為に、setterメソッドを実装する。
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
