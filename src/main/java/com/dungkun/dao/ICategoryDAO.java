package com.dungkun.dao;

import java.util.List;

import com.dungkun.model.CategoryModel;


public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	Long save(CategoryModel category);
//	void update(CategoryModel category);
}
