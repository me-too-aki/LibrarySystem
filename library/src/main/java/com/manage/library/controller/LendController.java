package com.manage.library.controller;

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

// �}���ݏo��ʂ̃R���g���[���B
@Controller
public class LendController {

  // db����f�[�^�𓾂�Dao��p�ӂ���B
  @Autowired
  private BooksDao booksDaoView;
  @Autowired
  private UsersDao usersDaoView;

  // View�ɓn�������I�u�W�F�N�g���A�A�m�e�[�V�����Őݒ肷��B
  @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
  public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

    // View�ɓn���e�[�u���f�[�^��p�ӂ���B
    Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
    model.addAttribute("lendBookDetail", lendBookDetailRecord);

    List<Users> UsersList = usersDaoView.findAll();
    model.addAttribute("users", UsersList);
    
    String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
    model.addAttribute("ownerUserName", ownerUserName);

    // �ݏo��ʂɕ\������ׁA���݂̓��t(�ݏo��)��7����̓��t(�ԋp�\����̃f�t�H���g�l)���擾����B
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar lendDate = Calendar.getInstance();
    Calendar dueDate = Calendar.getInstance();
    dueDate.add(Calendar.DAY_OF_MONTH, 7);

    model.addAttribute("lendDate", df.format(lendDate.getTime()));
    model.addAttribute("dueDate", df.format(dueDate.getTime()));

    // view����ԋp����B
    // web.xml�́yvalue="/WEB-INF/views/�z�ɂ��A
    // WEB-INF/views/lend.jsp�������_�����O�����B
    return "lend";
  }
}