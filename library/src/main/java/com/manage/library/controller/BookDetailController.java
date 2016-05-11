/**
 *  パッケージ名。
 */
package com.manage.library.controller;

/**
 * 必要なライブラリをインポート。
 */
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

  /**
   * 値を注入する為のオブジェクトを宣言する。
   * 
   * @param lendedHistorysDaoView
   *          lendedHistorysテーブルから取得した値を注入するオブジェクト
   * @param booksDaoView
   *          booksテーブルから取得した値を注入するオブジェクト
   * @param usersDaoView
   *          usersテーブルから取得した値を注入するオブジェクト
   */
  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView;
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * 貸出図書詳細画面に遷移するメソッド。 GET方式でbookDetailのリクエストが来た時に実行される。
   * 前画面から送られるbookIdによって、表示される内容を変える。
   * 
   * @return bookDetail
   */
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    /**
     * dbから取得したリストをビューに返す処理。
     * lendedHistorysJoinUsersDaoインターフェースのfindFromIdメソッドを使い、結合したテーブルから
     * 対応するレコードを取得し、 取得したレコードを、historysJoinUsersという名前でModel型オブジェクトに設定する。
     */
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    /**
     * dbから取得したリストをビューに返す処理。
     * BooksDaoインターフェースのfindFromBookIdメソッドを使い、テーブルから対応するレコードを取得し、
     * 取得したレコードを、bookRecordという名前でModel型オブジェクトに設定する。
     */
    Books booksRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("bookRecord", booksRecord);

    /**
     * dbから取得した値をビューに返す処理。
     * UsersDaoインターフェースのfindUserNameFromUserIdメソッドを使い、テーブルから対応する値を取得する。
     * findUserNameFromUserIdの引数には、 先程取得したbooksテーブルのレコードから、OwnerUserIdを取得し用いる。
     * テーブルから取得した値を、ownerUserNameという名前でModel型オブジェクトに設定する。
     */
    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    /**
     * viewファイルを返す。
     */
    return "bookDetail";
  }
}