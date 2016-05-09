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

// �ݏo�}���ڍ׉�ʂ̃R���g���[���B
@Controller
public class BookDetailController {

  // db����f�[�^�𓾂�Dao�����ꂼ��p�ӂ���B
  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView;
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  // View�ɓn�������I�u�W�F�N�g���A�A�m�e�[�V�����Őݒ肷��B
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    // View�ɓn���e�[�u���f�[�^��p�ӂ���B
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    Books booksRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("bookRecord", booksRecord);

    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // view����ԋp����B
    // web.xml�́yvalue="/WEB-INF/views/�z�ɂ��A
    // WEB-INF/views/bookDetail.jsp�������_�����O�����B
    return "bookDetail";
  }
}