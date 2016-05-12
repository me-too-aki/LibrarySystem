/**
 *  �R���g���[���N���X�̃p�b�P�[�W�B
 */
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
 * �}���ݏo��ʂ̃R���g���[���N���X�B
 */
@Controller
public class LendController {

  @Autowired
  private BooksDao booksDaoView; // db����books�e�[�u���̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B
  @Autowired
  private UsersDao usersDaoView;// db����users�e�[�u���̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B

  /**
   * �}���ݏo��ʂ�\�����郁�\�b�h�Blend�ւ�GET���N�G�X�g���������Ɏ��s�����B �O��ʂ��瑗����bookId�ɂ���āA�\���������e��ς���B
   * 
   * @return lend
   */
  @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
  public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

    // �ݏo��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��books�e�[�u������A
    // findFromBookId���\�b�h��p���āA�~�������R�[�h���擾����B
    Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
    // �擾�����f�[�^����ʂɕ\������ׁAlendBookDetail�Ƃ������O��view�ɓn���B
    model.addAttribute("lendBookDetail", lendBookDetailRecord);

    // �ݏo��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��users�e�[�u������A
    // findFromUserId���\�b�h��p���āA�f�[�^��S�Ď擾����B
    List<Users> UsersList = usersDaoView.findAll();
    // �擾�����f�[�^����ʂɕ\������ׁAusers�Ƃ������O��view�ɓn���B
    model.addAttribute("users", UsersList);

    // �ݏo��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��users�e�[�u������A
    // findUserNameFromUserId���\�b�h��p���āA�~�������[�U�����擾����B
    String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    // ���݂̓��t���擾����ׂ̃I�u�W�F�N�g�B
    Calendar lendDate = Calendar.getInstance();
    // �ԋp�\����̃f�t�H���g�l�Ƃ��āA7����̓��t���擾����ׂ̃I�u�W�F�N�g�B
    Calendar dueDate = Calendar.getInstance();
    // 7��������B
    dueDate.add(Calendar.DAY_OF_MONTH, 7);
    // �t�H�[�}�b�g�Ɍ��݂̓��t�𗎂Ƃ������̂��AlendDate�Ƃ������O��view�ɓn���B
    model.addAttribute("lendDate", df.format(lendDate.getTime()));
    // �t�H�[�}�b�g�Ɍ���7����̓��t�𗎂Ƃ������̂��AdueDate�Ƃ������O��view�ɓn���B
    model.addAttribute("dueDate", df.format(dueDate.getTime()));

    // view�t�@�C�����Ԃ���Alend.jsp���\�������B

    return "lend";
  }
}