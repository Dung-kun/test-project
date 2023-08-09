package com.dungkun.service;

import java.util.List;

import com.dungkun.model.NewModel;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel news);
	NewModel update(NewModel news);
	void delete(List<Long> ids);
}	
