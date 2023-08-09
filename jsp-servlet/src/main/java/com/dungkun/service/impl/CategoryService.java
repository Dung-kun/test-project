package com.dungkun.service.impl;

import java.util.List;

import com.dungkun.dao.ICategoryDAO;
import com.dungkun.model.CategoryModel;
import com.dungkun.service.ICategoryService;
import javax.inject.Inject;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return this.categoryDao.findAll();
	}

	@Override
	public Long save(CategoryModel category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}
	
}
