// �p�b�P�[�W���B
package com.manage.library.controller;

//�K�v�ȃ��C�u�������C���|�[�g�B
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
 * �}���ݏo��ʂɑΉ�����R���g���[���N���X�B
 */
@Controller
public class LendController {

  // �edb����擾�����l���i�[����ׂ̃I�u�W�F�N�g��錾����B
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * �}���ݏo��ʂɑJ�ڂ��郁�\�b�h�B
   * 
   * @return view�t�@�C���B
   */
  @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
  public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

    // db����擾�������R�[�h���r���[�ɓn���B
    Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("lendBookDetail", lendBookDetailRecord);

    // db����擾�������X�g���r���[�ɓn���B
    List<Users> UsersList = usersDaoView.findAll();
    model.addAttribute("users", UsersList);

    // db����擾�����ϐ����r���[�ɓn���B
    String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // �ݏo���ɕK�v�Ȍ��݂̓��t�ƁA�ԋp�\����f�t�H���g�l��7����̓��t���擾���A�r���[�ɓn���B
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar lendDate = Calendar.getInstance();
    Calendar dueDate = Calendar.getInstance();
    dueDate.add(Calendar.DAY_OF_MONTH, 7);
    model.addAttribute("lendDate", df.format(lendDate.getTime()));
    model.addAttribute("dueDate", df.format(dueDate.getTime()));

    // view�t�@�C����Ԃ��B
    return "lend";
  }
}