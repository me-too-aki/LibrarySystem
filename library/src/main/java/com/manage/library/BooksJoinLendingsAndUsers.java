package com.manage.library;

public class BooksJoinLendingsAndUsers {

  private Books books;
  private Lendings lendings;
  private Users users;

  public Books getBooks() {
    return this.books;
  }

  public Lendings getLendings() {
    return this.lendings;
  }

  public Users getUsers() {
    return this.users;
  }

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
