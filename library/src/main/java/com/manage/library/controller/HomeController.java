// �p�b�P�[�W���B
package com.manage.library.controller;

//�K�v�ȃ��C�u�������C���|�[�g�B
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

//�edb����擾�����l���i�[����ׂ̃I�u�W�F�N�g��錾����B
  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;

  /**
   * ���Јꗗ��ʂɑJ�ڂ��郁�\�b�h�B
   * 
   * @return view�t�@�C���B
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // db����擾�������X�g���r���[�ɓn���B
    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    model.addAttribute("books", homeList);

    // view�t�@�C����Ԃ��B
    return "home";
  }
}