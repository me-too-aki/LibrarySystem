/**
 *  ���f���N���X�̃p�b�P�[�W�B
 */
package com.manage.library;

/**
 * db��books,lendings,users�����������r���[�̃��f���N���X�B
 */
public class BooksJoinLendingsAndUsers {

    //���������e�e�[�u���̃��f���N���X���C���X�^���X������B
    private Books books;
    private Lendings lendings;
    private Users users;

    /**
     * books�̒l�𓾂�ׂ�getter���\�b�h�B
     *
     * @return books
     */
    public Books getBooks() {
        return this.books;
    }

    /**
     * lendings�̒l�𓾂�ׂ�getter���\�b�h�B
     *
     * @return lendings
     */
    public Lendings getLendings() {
        return this.lendings;
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
     * books�ɒl��}������ׂ�setter���\�b�h�B
     *
     * @param books
     */
    public void setBooks(Books books) {
        this.books = books;
    }

    /**
     * lendings�ɒl��}������ׂ�setter���\�b�h�B
     *
     * @param lendings
     */
    public void setLendings(Lendings lendings) {
        this.lendings = lendings;
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
