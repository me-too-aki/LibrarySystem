/**
 *  �R���g���[���N���X�̃p�b�P�[�W�B
 */
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
 * �ݏo�}���ڍ׉�ʂ̃R���g���[���N���X�B
 */
@Controller
public class BookDetailController {

  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView; // db����lended_historys�e�[�u����users�e�[�u���̃��R�[�h��S�Ď����Ă���ׂ̃I�u�W�F�N�g�B
  @Autowired
  private BooksDao booksDaoView;// db����books�e�[�u���̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B
  @Autowired
  private UsersDao usersDaoView; // db����users�e�[�u���̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B

  /**
   * �ݏo�}���ڍ׉�ʂ�\�����郁�\�b�h�BbookDetail�ւ�GET���N�G�X�g���������Ɏ��s�����B
   * �O��ʂ��瑗����bookId�ɂ���āA�\���������e��ς���B
   * 
   * @return bookDetail
   */
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    // �ڍ׉�ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��lended_historys�Ausers�e�[�u������A
    // findFromId���\�b�h��p���āA�~�������R�[�h���擾����B
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    // �擾�����f�[�^����ʂɕ\������ׁAhistoryJoinUsers�Ƃ������O��view�ɓn���B
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    // �ڍ׉�ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��books�e�[�u������A
    // findFromBookId���\�b�h��p���āA�~�������R�[�h���擾����B
    Books booksRecord = booksDaoView.findFromBookId(id);
    // �擾�����f�[�^����ʂɕ\������ׁAbookRecord�Ƃ������O��view�ɓn���B
    model.addAttribute("bookRecord", booksRecord);

    // �ڍ׉�ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��users�e�[�u������A
    // findUserNameFromUserId���\�b�h��p���āA�~�������[�U�����擾����B
    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    // �擾�����f�[�^����ʂɕ\������ׁAownerUserName�Ƃ������O��view�ɓn���B
    model.addAttribute("ownerUserName", ownerUserName);

    // view�t�@�C�����Ԃ���AbookDetail.jsp���\�������B
    return "bookDetail";
  }
}