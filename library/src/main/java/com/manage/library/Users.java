// �p�b�P�[�W���B
package com.manage.library;

//db��books�e�[�u���̃��f���N���X�B
public class Users {

  // books�e�[�u���̃J�����B
  private int userId;
  private String userName;

  // users�e�[�u������user_id���擾����ׂ�getter���\�b�h�B
  public int getUserId() {
    return this.userId;
  }

  // users�e�[�u������user_name���擾����ׂ�getter���\�b�h�B
  public String getUserName() {
    return this.userName;
  }

  // user_id�ɒl��}������setter���\�b�h�B
  public void setUserId(int userId) {
    this.userId = userId;
  }

  // user_name�ɒl��}������setter���\�b�h�B
  public void setUserName(String userName) {
    this.userName = userName;
  }

}
