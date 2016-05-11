// パッケージ名。
package com.manage.library.controller;

//必要なライブラリをインポート。
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

//各dbから取得した値を格納する為のオブジェクトを宣言する。
  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;

  /**
   * 書籍一覧画面に遷移するメソッド。
   * 
   * @return viewファイル。
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // dbから取得したリストをビューに渡す。
    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    model.addAttribute("books", homeList);

    // viewファイルを返す。
    return "home";
  }
}