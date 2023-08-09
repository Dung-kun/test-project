package com.dungkun.model.input;

import java.util.ArrayList;
import java.util.List;

public class BasicModelInput<T> {
	private Long id;
	private int page = 1;
	private int maxPageItem = 10;
	private int totalItem = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(int maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	private List<T> list = new ArrayList<T>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

}
