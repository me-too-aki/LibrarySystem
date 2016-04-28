package com.manage.library;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// �ꗗ���(home)�̃R���g���[���B
@Controller
public class HomeController {

  //db����f�[�^�𓾂�homeDao��p�ӂ���B
  @Autowired
  private HomeDao homeDao;

  // View�ɓn�������I�u�W�F�N�g���A�A�m�e�[�V�����Őݒ肷��B
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // db���瓾���f�[�^��List�^�ϐ��Ɋi�[���A����home_list��model�Ɋi�[����B
    List<Home> homeList = homeDao.findAll();
    model.addAttribute("books", homeList);

    // view����ԋp����B
    // web.xml�́yvalue="/WEB-INF/views/�z�ɂ��A
    // WEB-INF/views/home.jsp�������_�����O�����B
    return "home";
  }
}