/**
 *  �R���g���[���N���X�̃p�b�P�[�W�B
 */
package com.manage.library.controller;

// �K�v�ȃ��C�u�������C���|�[�g����B
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
 * �ݏo�}���ꗗ��ʂ̃R���g���[���N���X�B
 */
@Controller
public class HomeController {

  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView; // db����books�e�[�u����lendings�e�[�u����users�e�[�u���̂��ꂼ��̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B

  /**
   * �ݏo�}���ꗗ��ʂ�\�����郁�\�b�h�B �z�[����ʂւ�GET���N�G�X�g���������Ɏ��s�����B
   * 
   * @return home
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // �ꗗ��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��books�Alendings�Ausers�e�[�u������f�[�^��S�Ď擾����B
    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    // �擾�����f�[�^����ʂɕ\������ׁAbooks�Ƃ������O��view�ɓn���B
    model.addAttribute("books", homeList);

    // view�t�@�C�����Ԃ���Ahome.jsp���\�������B
    return "home";
  }
}