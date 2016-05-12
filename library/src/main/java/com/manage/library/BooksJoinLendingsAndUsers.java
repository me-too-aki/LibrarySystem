/**
 *  モデルクラスのパッケージ。
 */
package com.manage.library;

/**
 * dbのbooks,lendings,usersを結合したビューのモデルクラス。
 */
public class BooksJoinLendingsAndUsers {

    //結合した各テーブルのモデルクラスをインスタンス化する。
    private Books books;
    private Lendings lendings;
    private Users users;

    /**
     * booksの値を得る為のgetterメソッド。
     *
     * @return books
     */
    public Books getBooks() {
        return this.books;
    }

    /**
     * lendingsの値を得る為のgetterメソッド。
     *
     * @return lendings
     */
    public Lendings getLendings() {
        return this.lendings;
    }

    /**
     * usersの値を得る為のgetterメソッド。
     *
     * @return users
     */
    public Users getUsers() {
        return this.users;
    }

    /**
     * booksに値を挿入する為のsetterメソッド。
     *
     * @param books
     */
    public void setBooks(Books books) {
        this.books = books;
    }

    /**
     * lendingsに値を挿入する為のsetterメソッド。
     *
     * @param lendings
     */
    public void setLendings(Lendings lendings) {
        this.lendings = lendings;
    }

    /**
     * usersに値を挿入する為のsetterメソッド。
     *
     * @param users
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
