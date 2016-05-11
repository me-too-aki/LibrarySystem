package com.manage.library.dao;

import java.util.List;
import com.manage.library.Lendings;

public interface LendingsDao {
  List<Lendings> findAll();

  List<Lendings> findFromId(int id);
}
