// パッケージ名。
package com.manage.library.controller;

//必要なライブラリをインポート。
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

  // 各dbから取得した値を格納する為のオブジェクトを宣言する。
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * 図書貸出画面に遷移するメソッド。
   * 
   * @return viewファイル。
   */
  @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
  public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

    // dbから取得したレコードをビューに渡す。
    Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("lendBookDetail", lendBookDetailRecord);

    // dbから取得したリストをビューに渡す。
    List<Users> UsersList = usersDaoView.findAll();
    model.addAttribute("users", UsersList);

    // dbから取得した変数をビューに渡す。
    String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // 貸出情報に必要な現在の日付と、返却予定日デフォルト値の7日後の日付を取得し、ビューに渡す。
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar lendDate = Calendar.getInstance();
    Calendar dueDate = Calendar.getInstance();
    dueDate.add(Calendar.DAY_OF_MONTH, 7);
    model.addAttribute("lendDate", df.format(lendDate.getTime()));
    model.addAttribute("dueDate", df.format(dueDate.getTime()));

    // viewファイルを返す。
    return "lend";
  }
}