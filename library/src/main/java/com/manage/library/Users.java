/**
 *  ���f���N���X�̃p�b�P�[�W�B
 */
package com.manage.library;

/**
 * db��users�e�[�u���̃��f���N���X�B
 */
public class Users {

    //  users�e�[�u���̃J�����B
    private int userId;
    private String userName;

    /**
     * userId���擾����ׂ�getter���\�b�h�B
     *
     * @return userId
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * userName���擾����ׂ�getter���\�b�h�B
     *
     * @return userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * userId�ɒl��}������setter���\�b�h�B
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * userName�ɒl��}������setter���\�b�h�B
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
