package com.manage.library;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 一覧画面(home)のコントローラ。
@Controller
public class HomeController {

  //dbからデータを得るhomeDaoを用意する。
  @Autowired
  private HomeDao homeDao;

  // Viewに渡したいオブジェクトを、アノテーションで設定する。
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    // dbから得たデータをList型変数に格納し、そのhome_listをmodelに格納する。
    List<Home> homeList = homeDao.findAll();
    model.addAttribute("books", homeList);

    // view名を返却する。
    // web.xmlの【value="/WEB-INF/views/】により、
    // WEB-INF/views/home.jspがレンダリングされる。
    return "home";
  }
}