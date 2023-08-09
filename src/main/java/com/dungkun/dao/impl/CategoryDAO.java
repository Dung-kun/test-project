package com.dungkun.dao.impl;

import java.util.List;

import com.dungkun.dao.ICategoryDAO;
import com.dungkun.mapper.CategoryMapper;
import com.dungkun.model.CategoryModel;

public class CategoryDAO extends GenericDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sqlQuery = "select * from category";
		return query(sqlQuery, new CategoryMapper());
	}

	@Override
	public Long save(CategoryModel category) {
		String sql = "insert into news (code, name) values(?,?)";
		return insert(sql, category.getCode(), category.getName());
	}

}
