// パッケージ名。
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
 * 貸出図書詳細画面に対応するコントローラクラス。
 */
@Controller
public class BookDetailController {

  // 各dbから取得した値を格納する為のオブジェクトを宣言する。
  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView;
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * 貸出図書詳細画面に遷移するメソッド。
   * @return viewファイル。
   */
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    // dbから取得したリストをビューに渡す。
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    // dbから取得したレコードをビューに渡す。
    Books booksRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("bookRecord", booksRecord);

    // dbから取得した変数をビューに渡す。
    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // viewファイルを返す。
    return "bookDetail";
  }
}