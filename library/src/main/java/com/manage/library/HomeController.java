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

//一覧画面(home)のコントローラ。
@Controller
public class HomeController {

  // Mysqlを扱う為に必要なjdbcテンプレートを用意する。
  @Autowired
  private JdbcTemplate jdbcTemplate;

  // Viewに渡したいオブジェクトを、アノテーションで設定する。
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // sql文によってデータを取得し、List型の変数に格納する。
    String sql = "select * from books inner join users on owner_user_id = user_id inner join lendings on borrow_user_id = user_id;";
    List<Map<String, Object>> home_list = jdbcTemplate.queryForList(sql);

    // sql文で取得したlistを、modelに格納。
    model.addAttribute("books", home_list);

    // view名を返却する。
    // web.xmlの【value="/WEB-INF/views/】により、
    // WEB-INF/views/home.jspがレンダリングされる。
    return "home";
  }
}