package com.dungkun.dao;

import java.util.List;

import com.dungkun.model.NewModel;

public interface INewDAO extends IGenericDAO<NewModel>{
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel news);
	void update(NewModel news);
	void delete(Long id);
	List<NewModel> findAll(int page, int maxPageItem);
	int getTotalItem();
}
