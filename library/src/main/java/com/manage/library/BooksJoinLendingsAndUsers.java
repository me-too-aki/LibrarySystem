package com.manage.library;

// �擾����l��p�ӂ��Agetter��setter��p�ӂ���N���X�B
public class BooksJoinLendingsAndUsers {

  private Books books;  //�{(books)�̃e�[�u��
  private Lendings lendings; //�ݏo��(lendings)�̃e�[�u��
  private Users users; //���[�U(users)�̃e�[�u��

  // jsp�t�@�C�����Œl���擾����ׂɁAgetter���\�b�h����������B
  public Books getBooks() {
    return this.books;
  }

  public Lendings getLendings() {
    return this.lendings;
  }

  public Users getUsers() {
    return this.users;
  }

  // DaoImpl�N���X�Œl������ׂɁAsetter���\�b�h����������B
  public void setBooks(Books books) {
    this.books = books;
  }

  public void setLendings(Lendings lendings) {
    this.lendings = lendings;
  }

  public void setUsers(Users users) {
    this.users = users;
  }
}
