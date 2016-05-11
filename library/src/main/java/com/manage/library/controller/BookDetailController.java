// �p�b�P�[�W���B
package com.manage.library.controller;

//�K�v�ȃ��C�u�������C���|�[�g�B
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
 * �ݏo�}���ڍ׉�ʂɑΉ�����R���g���[���N���X�B
 */
@Controller
public class BookDetailController {

  // �edb����擾�����l���i�[����ׂ̃I�u�W�F�N�g��錾����B
  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView;
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * �ݏo�}���ڍ׉�ʂɑJ�ڂ��郁�\�b�h�B
   * @return view�t�@�C���B
   */
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    // db����擾�������X�g���r���[�ɓn���B
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    // db����擾�������R�[�h���r���[�ɓn���B
    Books booksRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("bookRecord", booksRecord);

    // db����擾�����ϐ����r���[�ɓn���B
    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // view�t�@�C����Ԃ��B
    return "bookDetail";
  }
}