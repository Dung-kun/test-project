package com.dungkun.dao;

import java.util.List;

import com.dungkun.mapper.IRowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql, IRowMapper<T> mapper, Object... parameters);
	Long insert(String sql, Object...parameters);
	void update(String sql, Object...parameters);
	int count(String sql, Object...parameters);
}
