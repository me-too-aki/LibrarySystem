/**
 *  コントローラクラスのパッケージ。
 */
package com.manage.library.controller;

//必要なライブラリをインポート。

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.manage.library.Books;
import com.manage.library.LendedHistorysJoinUsers;
import com.manage.library.dao.BooksDao;
import com.manage.library.dao.LendedHistorysJoinUsersDao;
import com.manage.library.dao.UsersDao;

/**
 * 貸出図書詳細画面のコントローラクラス。
 */
@Controller
public class BookDetailController {

  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView; // dbからlended_historysテーブルとusersテーブルのレコードを全て持ってくる為のオブジェクト。
  @Autowired
  private BooksDao booksDaoView;// dbからbooksテーブルのレコードを持ってくる為のオブジェクト。
  @Autowired
  private UsersDao usersDaoView; // dbからusersテーブルのレコードを持ってくる為のオブジェクト。

  /**
   * 貸出図書詳細画面を表示するメソッド。bookDetailへのGETリクエストが来た時に実行される。
   * 前画面から送られるbookIdによって、表示される内容を変える。
   * 
   * @return bookDetail
   */
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    // 詳細画面の表示に必要なデータを得る為、dbのlended_historys、usersテーブルから、
    // findFromIdメソッドを用いて、欲しいレコードを取得する。
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    // 取得したデータを画面に表示する為、historyJoinUsersという名前でviewに渡す。
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    // 詳細画面の表示に必要なデータを得る為、dbのbooksテーブルから、
    // findFromBookIdメソッドを用いて、欲しいレコードを取得する。
    Books booksRecord = booksDaoView.findFromBookId(id);
    // 取得したデータを画面に表示する為、bookRecordという名前でviewに渡す。
    model.addAttribute("bookRecord", booksRecord);

    // 詳細画面の表示に必要なデータを得る為、dbのusersテーブルから、
    // findUserNameFromUserIdメソッドを用いて、欲しいユーザ名を取得する。
    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    // 取得したデータを画面に表示する為、ownerUserNameという名前でviewに渡す。
    model.addAttribute("ownerUserName", ownerUserName);

    // viewファイルが返され、bookDetail.jspが表示される。
    return "bookDetail";
  }
}