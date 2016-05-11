/**
 *  パッケージ名。
 */
package com.manage.library.controller;

/**
 * 必要なライブラリをインポート。
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.manage.library.Books;
import com.manage.library.Users;
import com.manage.library.dao.BooksDao;
import com.manage.library.dao.UsersDao;

/**
 * 図書貸出画面に対応するコントローラクラス。
 */
@Controller
public class LendController {
  /**
   * 値を注入する為のオブジェクトを宣言する。
   * 
   * @param booksDaoView
   *          booksテーブルから取得した値を注入するオブジェクト
   * @param usersDaoView
   *          usersテーブルから取得した値を注入するオブジェクト
   */
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * 図書貸出画面に遷移するメソッド。 GET方式でlendのリクエストが来た時に実行される。
   * 前画面から送られるbookIdによって、表示される内容を変える。
   * 
   * @return lend
   */
  @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
  public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

    /**
     * dbから取得したレコードをビューに返す処理。
     * booksDaoインターフェースのfindFromBookIdメソッドを使い、テーブルから対応するレコードを取得し、
     * 取得したレコードを、lendBookDetailという名前でモデルに渡す。
     */
    Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("lendBookDetail", lendBookDetailRecord);

    /**
     * dbから取得したリストをビューに返す処理。
     * usersDaoインターフェースのfindAllメソッドを使い、テーブルから対応するデータを全て取得し、
     * 取得したデータを、usersという名前でModel型オブジェクトに設定する。
     */
    List<Users> UsersList = usersDaoView.findAll();
    model.addAttribute("users", UsersList);

    /**
     * dbから取得した値をビューに返す処理。
     * usersDaoインターフェースのfindUserNameFromUserIdメソッドを使い、テーブルから対応する値を取得する。
     * findUserNameFromUserIdの引数には、 先程取得したbooksテーブルのレコードから、OwnerUserIdを取得し用いる。
     * 取得した値を、ownerUserNameという名前でModel型オブジェクトに設定する。
     */
    String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    /**
     * 貸出情報に必要な現在の日付と、返却予定日デフォルト値の7日後の日付を取得する処理。
     * まず日付の表記のフォーマットを定義し、現在の日付と、7日後の日付をCalendar型で取得する。
     * フォーマットに現在の日付を落としたものをlendDate、返却予定日のデフォルト値を落としたものをdueDateという名前で、Model型オブジェクトに設定する。
     */
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar lendDate = Calendar.getInstance();
    Calendar dueDate = Calendar.getInstance();
    dueDate.add(Calendar.DAY_OF_MONTH, 7);
    model.addAttribute("lendDate", df.format(lendDate.getTime()));
    model.addAttribute("dueDate", df.format(dueDate.getTime()));

    /**
     *  viewファイルを返す。
     */
    return "lend";
  }
}