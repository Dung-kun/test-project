package com.dungkun.service;

import java.util.List;

import com.dungkun.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	Long save(CategoryModel category);
	void update(CategoryModel category);
}
