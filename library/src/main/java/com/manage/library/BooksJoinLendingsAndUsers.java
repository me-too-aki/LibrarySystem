// �p�b�P�[�W���B
package com.manage.library;

//db��books,lendings,Users�������������r���[�̃��f���N���X�B
public class BooksJoinLendingsAndUsers {

  // ���������e�e�[�u���̃��f���N���X���C���X�^���X���B
  private Books books;
  private Lendings lendings;
  private Users users;

  // books�e�[�u������l�𓾂�ׂ�getter���\�b�h�B
  public Books getBooks() {
    return this.books;
  }

  // lendings�e�[�u������l�𓾂�ׂ�getter���\�b�h�B
  public Lendings getLendings() {
    return this.lendings;
  }

  // users�e�[�u������l�𓾂�ׂ�getter���\�b�h�B
  public Users getUsers() {
    return this.users;
  }

  // books�e�[�u���ɒl��}������ׂ�setter���\�b�h�B
  public void setBooks(Books books) {
    this.books = books;
  }

  // lendings�e�[�u���ɒl��}������ׂ�setter���\�b�h�B
  public void setLendings(Lendings lendings) {
    this.lendings = lendings;
  }

  // users�e�[�u���ɒl��}������ׂ�setter���\�b�h�B
  public void setUsers(Users users) {
    this.users = users;
  }
}
