package com.dungkun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dungkun.model.NewModel;

public class NewMapper implements IRowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		NewModel news = new NewModel();
		try {
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setContent(resultSet.getString("content"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
