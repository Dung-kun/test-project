package com.dungkun.dao.impl;

import java.util.List;

import com.dungkun.dao.INewDAO;
import com.dungkun.mapper.NewMapper;
import com.dungkun.model.NewModel;

public class NewDAO extends GenericDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel news) {
		String sql = "insert into news (title, thumbnail, shortdecription, content, categoryid, createddate, createdby) values(?,?,?,?,?,?,?)";
		return insert(sql, news.getTitle(), news.getThumbnail(), news.getShortDescription(), news.getContent(),
				news.getCategoryId(), news.getCreatedDate(), news.getCreatedBy());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewModel> lists = query(sql, new NewMapper(), id);
		return lists.isEmpty() ? null : lists.get(0);
	}

	@Override
	public void update(NewModel news) {
		String sql = "update news set title = ?, content = ?, thumbnail = ?, shortdescription = ?, categoryid = ?, modifieddate = ?, modifiedby = ?";
		sql += " where id = ?";
		update(sql, news.getTitle(), news.getContent(), news.getThumbnail(), news.getShortDescription(),
				news.getCategoryId(), news.getId(), news.getModifiedDate(), news.getModifiedBy());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(int currentPage, int maxPageItem) {
		String sql = "select * from news limit ?, ?";
		return  query(sql, new NewMapper(), currentPage, maxPageItem);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return count(sql);
	}

}
