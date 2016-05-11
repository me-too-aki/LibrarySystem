/**
 *  �p�b�P�[�W���B
 */
package com.manage.library.controller;

/**
 * �K�v�ȃ��C�u�������C���|�[�g�B
 */
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
  /**
   * �l�𒍓�����ׂ̃I�u�W�F�N�g��錾����B
   * 
   * @param booksDaoView
   *          books�e�[�u������擾�����l�𒍓�����I�u�W�F�N�g
   * @param usersDaoView
   *          users�e�[�u������擾�����l�𒍓�����I�u�W�F�N�g
   */
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  /**
   * �}���ݏo��ʂɑJ�ڂ��郁�\�b�h�B GET������lend�̃��N�G�X�g���������Ɏ��s�����B
   * �O��ʂ��瑗����bookId�ɂ���āA�\���������e��ς���B
   * 
   * @return lend
   */
  @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
  public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

    /**
     * db����擾�������R�[�h���r���[�ɕԂ������B
     * booksDao�C���^�[�t�F�[�X��findFromBookId���\�b�h���g���A�e�[�u������Ή����郌�R�[�h���擾���A
     * �擾�������R�[�h���AlendBookDetail�Ƃ������O�Ń��f���ɓn���B
     */
    Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("lendBookDetail", lendBookDetailRecord);

    /**
     * db����擾�������X�g���r���[�ɕԂ������B
     * usersDao�C���^�[�t�F�[�X��findAll���\�b�h���g���A�e�[�u������Ή�����f�[�^��S�Ď擾���A
     * �擾�����f�[�^���Ausers�Ƃ������O��Model�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    List<Users> UsersList = usersDaoView.findAll();
    model.addAttribute("users", UsersList);

    /**
     * db����擾�����l���r���[�ɕԂ������B
     * usersDao�C���^�[�t�F�[�X��findUserNameFromUserId���\�b�h���g���A�e�[�u������Ή�����l���擾����B
     * findUserNameFromUserId�̈����ɂ́A ����擾����books�e�[�u���̃��R�[�h����AOwnerUserId���擾���p����B
     * �擾�����l���AownerUserName�Ƃ������O��Model�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    /**
     * �ݏo���ɕK�v�Ȍ��݂̓��t�ƁA�ԋp�\����f�t�H���g�l��7����̓��t���擾���鏈���B
     * �܂����t�̕\�L�̃t�H�[�}�b�g���`���A���݂̓��t�ƁA7����̓��t��Calendar�^�Ŏ擾����B
     * �t�H�[�}�b�g�Ɍ��݂̓��t�𗎂Ƃ������̂�lendDate�A�ԋp�\����̃f�t�H���g�l�𗎂Ƃ������̂�dueDate�Ƃ������O�ŁAModel�^�I�u�W�F�N�g�ɐݒ肷��B
     */
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar lendDate = Calendar.getInstance();
    Calendar dueDate = Calendar.getInstance();
    dueDate.add(Calendar.DAY_OF_MONTH, 7);
    model.addAttribute("lendDate", df.format(lendDate.getTime()));
    model.addAttribute("dueDate", df.format(dueDate.getTime()));

    /**
     *  view�t�@�C����Ԃ��B
     */
    return "lend";
  }
}