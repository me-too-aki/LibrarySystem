package com.manage.library.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.dao.BooksJoinLendingsAndUsersDao;

@Controller
public class HomeController {

  @Autowired
  private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {

    List<BooksJoinLendingsAndUsers> homeList = booksJoinLendingsAndUsersDaoView.findAll();
    model.addAttribute("books", homeList);

    return "home";
  }
}