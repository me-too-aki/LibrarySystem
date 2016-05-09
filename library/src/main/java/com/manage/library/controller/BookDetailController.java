package com.manage.library.controller;

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

// 貸出図書詳細画面のコントローラ。
@Controller
public class BookDetailController {

  // dbからデータを得るDaoをそれぞれ用意する。
  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView;
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  // Viewに渡したいオブジェクトを、アノテーションで設定する。
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    // Viewに渡すテーブルデータを用意する。
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    Books booksRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("bookRecord", booksRecord);

    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // view名を返却する。
    // web.xmlの【value="/WEB-INF/views/】により、
    // WEB-INF/views/bookDetail.jspがレンダリングされる。
    return "bookDetail";
  }
}