package com.dungkun.model.input;

import com.dungkun.model.CategoryModel;

public class CategoryModelInput extends BasicModelInput<CategoryModel>{
	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
