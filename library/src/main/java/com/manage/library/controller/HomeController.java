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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.dao.BooksJoinLendingsAndUsersDao;

/**
 * 貸出図書一覧画面に対応するコントローラクラス。
 */
@Controller
public class HomeController {

  /**
   * 値を注入する為のオブジェクトを宣言する。
   * 
   * @param BooksJoinLendingsAndUsersDaoView
   *          結合したテーブルから取得した値を注入するオブジェクト
   */
  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;

  /**
   * 貸出図書一覧画面に遷移するメソッド。 ホーム画面へのリクエストが来た時に実行される。
   * 
   * @return bookDetail
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    /**
     * dbから取得したリストをビューに返す処理。
     * BooksJoinLendingsAndUsersDaoインターフェースのfindAllメソッドを使い、テーブルから対応するデータを全て取得し、
     * 取得したデータを、booksという名前でModel型オブジェクトに設定する。
     */
    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    model.addAttribute("books", homeList);

    /**
     * viewファイルを返す。
     */
    return "home";
  }
}