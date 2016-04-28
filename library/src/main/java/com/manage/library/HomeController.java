package com.manage.library;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//�ꗗ���(home)�̃R���g���[���B
@Controller
public class HomeController {

  // Mysql�������ׂɕK�v��jdbc�e���v���[�g��p�ӂ���B
  @Autowired
  private JdbcTemplate jdbcTemplate;

  // View�ɓn�������I�u�W�F�N�g���A�A�m�e�[�V�����Őݒ肷��B
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // sql���ɂ���ăf�[�^���擾���AList�^�̕ϐ��Ɋi�[����B
    String sql = "select * from books inner join users on owner_user_id = user_id inner join lendings on borrow_user_id = user_id;";
    List<Map<String, Object>> home_list = jdbcTemplate.queryForList(sql);

    // sql���Ŏ擾����list���Amodel�Ɋi�[�B
    model.addAttribute("books", home_list);

    // view����ԋp����B
    // web.xml�́yvalue="/WEB-INF/views/�z�ɂ��A
    // WEB-INF/views/home.jsp�������_�����O�����B
    return "home";
  }
}