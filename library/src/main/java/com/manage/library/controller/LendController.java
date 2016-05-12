/**
 *  コントローラクラスのパッケージ。
 */
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
 * 図書貸出画面のコントローラクラス。
 */
@Controller
public class LendController {

    @Autowired
    private BooksDao booksDaoView; // dbからbooksテーブルのレコードを持ってくる為のオブジェクト。
    @Autowired
    private UsersDao usersDaoView; // dbからusersテーブルのレコードを持ってくる為のオブジェクト。

    /**
     * 図書貸出画面を表示するメソッド。lendへのGETリクエストが来た時に実行される。
     * 前画面から送られるbookIdによって、表示される内容を変える。
     *
     * @return lend 図書貸出画面
     */
    @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
    public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

        // 貸出画面の表示に必要なデータを得る為、dbのbooksテーブルから、idに対応するレコードを取得する。
        Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
        // 取得したデータを画面に表示する為、lendBookDetailという名前でmodelに設定する。
        model.addAttribute("lendBookDetail", lendBookDetailRecord);

        // 貸出画面の表示に必要なデータを得る為、dbのusersテーブルからデータを全て取得する。
        List<Users> UsersList = usersDaoView.findAll();
        // 取得したデータを画面に表示する為、usersという名前でmodelに設定する。
        model.addAttribute("users", UsersList);

        // 貸出画面の表示に必要なデータを得る為、dbのusersテーブルから、
        // 本所有者のidに対応するユーザ名を取得する。
        String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
        // 取得したデータを画面に表示する為、ownerUserNameという名前でmodelに設定する。
        model.addAttribute("ownerUserName", ownerUserName);

        // 日付のフォーマット。
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 現在の日付を取得する為のオブジェクト。
        Calendar lendDate = Calendar.getInstance();
        // 返却予定日のデフォルト値として、7日後の日付を取得する為のオブジェクト。
        Calendar dueDate = Calendar.getInstance();
        // 7日加える。
        dueDate.add(Calendar.DAY_OF_MONTH, 7);
        // 現在日付をフォーマットで変換したものを、lendDateという名前でmodelに設定する。
        model.addAttribute("lendDate", df.format(lendDate.getTime()));
        // 7日後の日付をフォーマットで変換したものを、dueDateという名前でmodelに設定する。
        model.addAttribute("dueDate", df.format(dueDate.getTime()));

        // lend.jspが表示される。
        return "lend";
    }
}
