/**
 *  �p�b�P�[�W���B
 */
package com.manage.library.controller;

/**
 * �K�v�ȃ��C�u�������C���|�[�g�B
 */
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

  /**
   * �l�𒍓�����ׂ̃I�u�W�F�N�g��錾����B
   * 
   * @param lendedHistorysDaoView
   *          lendedHistorys�e�[�u������擾�����l�𒍓�����I�u�W�F�N�g
   * @param booksDaoView
   *          books�e�[�u������擾�����l�𒍓�����I�u�W�F�N�g
   * @param usersDaoView
   *          users�e�[�u������擾�����l�𒍓�����I�u�W�F�N�g
   */
  @Autowired
  private LendedHistorysJoinUsersDao lendedHistorysDaoView;
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * �ݏo�}���ڍ׉�ʂɑJ�ڂ��郁�\�b�h�B GET������bookDetail�̃��N�G�X�g���������Ɏ��s�����B
   * �O��ʂ��瑗����bookId�ɂ���āA�\���������e��ς���B
   * 
   * @return bookDetail
   */
  @RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
  public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {

    /**
     * db����擾�������X�g���r���[�ɕԂ������B
     * lendedHistorysJoinUsersDao�C���^�[�t�F�[�X��findFromId���\�b�h���g���A���������e�[�u������
     * �Ή����郌�R�[�h���擾���A �擾�������R�[�h���AhistorysJoinUsers�Ƃ������O��Model�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
    model.addAttribute("historysJoinUsers", historysJoinUsersList);

    /**
     * db����擾�������X�g���r���[�ɕԂ������B
     * BooksDao�C���^�[�t�F�[�X��findFromBookId���\�b�h���g���A�e�[�u������Ή����郌�R�[�h���擾���A
     * �擾�������R�[�h���AbookRecord�Ƃ������O��Model�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    Books booksRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("bookRecord", booksRecord);

    /**
     * db����擾�����l���r���[�ɕԂ������B
     * UsersDao�C���^�[�t�F�[�X��findUserNameFromUserId���\�b�h���g���A�e�[�u������Ή�����l���擾����B
     * findUserNameFromUserId�̈����ɂ́A ����擾����books�e�[�u���̃��R�[�h����AOwnerUserId���擾���p����B
     * �e�[�u������擾�����l���AownerUserName�Ƃ������O��Model�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    String ownerUserName = usersDaoView.findUserNameFromUserId(booksRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    /**
     * view�t�@�C����Ԃ��B
     */
    return "bookDetail";
  }
}