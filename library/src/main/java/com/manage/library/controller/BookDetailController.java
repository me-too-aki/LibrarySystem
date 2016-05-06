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

// �ݏo�}���ڍ׉�ʂ̃R���g���[���B
@Controller
public class BookDetailController {

	// db����f�[�^�𓾂�Dao�����ꂼ��p�ӂ���B
	@Autowired
	private BooksJoinLendingsAndUsersDao booksJoinLendingsAndUsersDaoView;
	@Autowired
	private LendedHistorysJoinUsersDao lendedHistorysDaoView;

	// View�ɓn�������I�u�W�F�N�g���A�A�m�e�[�V�����Őݒ肷��B
	@RequestMapping(value = "bookDetail/{bookId}", method = RequestMethod.GET)
	public String bookDetail(@PathVariable("bookId") int id, Locale locale, Model model) {
		
		// View�ɓn���e�[�u���f�[�^��p�ӂ���B
		List<BooksJoinLendingsAndUsers> booksJoinLendingsAndUsersList = booksJoinLendingsAndUsersDaoView.findFromId(id);
		model.addAttribute("booksJoinLendingsAndUsers", booksJoinLendingsAndUsersList);
		
		List<LendedHistorysJoinUsers> historysJoinUsersList = lendedHistorysDaoView.findFromId(id);
		model.addAttribute("historysJoinUsers", historysJoinUsersList);

		// view����ԋp����B
		// web.xml�́yvalue="/WEB-INF/views/�z�ɂ��A
		// WEB-INF/views/bookDetail.jsp�������_�����O�����B
		return "bookDetail";
	}
}