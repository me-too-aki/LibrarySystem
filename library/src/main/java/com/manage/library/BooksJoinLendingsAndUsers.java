/**
 *  �p�b�P�[�W���B
 */
package com.manage.library;

/**
 * db��books,lendings,users�������������r���[�̃��f���N���X�B
 */
public class BooksJoinLendingsAndUsers {

  /**
   * ���������e�e�[�u���̃��f���N���X���C���X�^���X���B
   */
  private Books books;
  private Lendings lendings;
  private Users users;

  /**
   * Books�N���X����l�𓾂�ׂ�getter���\�b�h�B
   * 
   * @return books
   */
  public Books getBooks() {
    return this.books;
  }

  /**
   * Lendings�N���X����l�𓾂�ׂ�getter���\�b�h�B
   * 
   * @return lendings
   */
  public Lendings getLendings() {
    return this.lendings;
  }

  /**
   * Users�N���X����l�𓾂�ׂ�getter���\�b�h�B
   * 
   * @return users
   */
  public Users getUsers() {
    return this.users;
  }

  /**
   * Books�N���X�ɒl��}������ׂ�setter���\�b�h�B
   * 
   * @param books
   */
  public void setBooks(Books books) {
    this.books = books;
  }

  /**
   * Lendings�N���X�ɒl��}������ׂ�setter���\�b�h�B
   * 
   * @param lendings
   */
  public void setLendings(Lendings lendings) {
    this.lendings = lendings;
  }

  /**
   * Users�N���X�ɒl��}������ׂ�setter���\�b�h�B
   * 
   * @param users
   */
  public void setUsers(Users users) {
    this.users = users;
  }
}
