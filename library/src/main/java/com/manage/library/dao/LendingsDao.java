package com.manage.library.dao;

import java.util.List;
import com.manage.library.Lendings;

// ���X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface LendingsDao {
	List<Lendings> findAll();

	List<Lendings> findFromId(int id);
}
