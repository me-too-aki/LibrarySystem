/**
 *  ���f���N���X�̃p�b�P�[�W�B
 */
package com.manage.library;

/**
 * db��lended_historys,users�����������r���[�̃��f���N���X�B
 */
public class LendedHistorysJoinUsers {

    // ���������e�e�[�u���̃��f���N���X���C���X�^���X������B
    private LendedHistorys lendedHistorys;
    private Users users;

    /**
     * lendedHistorys�̒l�𓾂�ׂ�getter���\�b�h�B
     *
     * @return lendedHistorys
     */
    public LendedHistorys getLendedHistorys() {
        return this.lendedHistorys;
    }

    /**
     * users�̒l�𓾂�ׂ�getter���\�b�h�B
     *
     * @return users
     */
    public Users getUsers() {
        return this.users;
    }

    /**
     * lendedHistorys�ɒl��}������ׂ�setter���\�b�h�B
     *
     * @param lendedHistorys
     */
    public void setLendedHistorys(LendedHistorys lendedHistorys) {
        this.lendedHistorys = lendedHistorys;
    }

    /**
     * users�ɒl��}������ׂ�setter���\�b�h�B
     *
     * @param users
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
