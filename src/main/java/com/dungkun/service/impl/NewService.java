package com.dungkun.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.dungkun.dao.INewDAO;
import com.dungkun.model.NewModel;
import com.dungkun.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {

		return this.newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel news) {
		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//		news.setModifiedBy(null);
		Long newId = newDao.save(news);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel news) {
		news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//		news.setModifiedBy(null);
		newDao.update(news);
		return newDao.findOne(news.getId());
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids) {
			newDao.delete(id);
		}
	}

}
