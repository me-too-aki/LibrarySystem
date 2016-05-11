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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.dao.BooksJoinLendingsAndUsersDao;

/**
 * �ݏo�}���ꗗ��ʂɑΉ�����R���g���[���N���X�B
 */
@Controller
public class HomeController {

  /**
   * �l�𒍓�����ׂ̃I�u�W�F�N�g��錾����B
   * 
   * @param BooksJoinLendingsAndUsersDaoView
   *          ���������e�[�u������擾�����l�𒍓�����I�u�W�F�N�g
   */
  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;

  /**
   * �ݏo�}���ꗗ��ʂɑJ�ڂ��郁�\�b�h�B �z�[����ʂւ̃��N�G�X�g���������Ɏ��s�����B
   * 
   * @return bookDetail
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    /**
     * db����擾�������X�g���r���[�ɕԂ������B
     * BooksJoinLendingsAndUsersDao�C���^�[�t�F�[�X��findAll���\�b�h���g���A�e�[�u������Ή�����f�[�^��S�Ď擾���A
     * �擾�����f�[�^���Abooks�Ƃ������O��Model�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    model.addAttribute("books", homeList);

    /**
     * view�t�@�C����Ԃ��B
     */
    return "home";
  }
}