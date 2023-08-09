package com.dungkun.model.input;

import com.dungkun.model.CommentModel;

public class CommentModelInput extends BasicModelInput<CommentModel> {
	private Long newid;
	private Long userid;
	public Long getNewid() {
		return newid;
	}
	public void setNewid(Long newid) {
		this.newid = newid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String content;	
}
