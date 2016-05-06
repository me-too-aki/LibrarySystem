package com.manage.library.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.LendedHistorysJoinUsers;
import com.manage.library.dao.BooksJoinLendingsAndUsersDao;
import com.manage.library.dao.LendedHistorysJoinUsersDao;

// 貸出図書詳細画面のコントローラ。
@Controller
public class BookDetailController {

	// dbからデータを得るDaoをそれぞれ用意する。
	@Autowired
	private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;
	@Autowired
	private LendedHistorysJoinUsersDao lendedHistorysDaoView;

	// Viewに渡したいオブジェクトを、アノテーションで設定する。
	@RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
	public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {
		
		// Viewに渡すテーブルデータを用意する。
		List<BooksJoinLendingsAndUsers> booksJoinLendingsAndUsersList = booksJoinLendingsAndUsersDaoView.findFromId(id);
		model.addAttribute("booksJoinLendingsAndUsers", booksJoinLendingsAndUsersList);
		
		List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
		model.addAttribute("historysJoinUsers", historysJoinUsersList);

		// view名を返却する。
		// web.xmlの【value="/WEB-INF/views/】により、
		// WEB-INF/views/bookDetail.jspがレンダリングされる。
		return "bookDetail";
	}
}