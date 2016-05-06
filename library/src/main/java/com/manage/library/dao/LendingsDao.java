package com.manage.library.dao;

import java.util.List;
import com.manage.library.Lendings;

// リストを得るDaoのインターフェイス。
public interface LendingsDao {
	List<Lendings> findAll();

	List<Lendings> findFromId(int id);
}
