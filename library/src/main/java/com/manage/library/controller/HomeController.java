/**
 *  コントローラクラスのパッケージ。
 */
package com.manage.library.controller;

// 必要なライブラリをインポートする。
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
 * 貸出図書一覧画面のコントローラクラス。
 */
@Controller
public class HomeController {

  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView; // dbからbooksテーブルとlendingsテーブルとusersテーブルのそれぞれのレコードを持ってくる為のオブジェクト。

  /**
   * 貸出図書一覧画面を表示するメソッド。 ホーム画面へのGETリクエストが来た時に実行される。
   * 
   * @return home
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // 一覧画面の表示に必要なデータを得る為、dbのbooks、lendings、usersテーブルからデータを全て取得する。
    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    // 取得したデータを画面に表示する為、booksという名前でviewに渡す。
    model.addAttribute("books", homeList);

    // viewファイルが返され、home.jspが表示される。
    return "home";
  }
}