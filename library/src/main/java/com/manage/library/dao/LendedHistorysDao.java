package com.manage.library.dao;

import java.util.List;
import com.manage.library.LendedHistorys;

// ���X�g�𓾂�Dao�̃C���^�[�t�F�C�X�B
public interface LendedHistorysDao {
	List<LendedHistorys> findAll();

	List<LendedHistorys> findFromId(int id);
}
