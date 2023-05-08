/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java1234.model;

public class Notice {

	private String ID;
	private String Title;
	private String Content;
        private String Time;
	
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Notice(String ID, String Title,String Content,String Time) {
		super();
		this.ID = ID;
		this.Title = Title;
                this.Content=Content;
                this.Time=Time;
	}


	public String getID() {
		return ID;
	}
	public void setID(String id) {
		this.ID = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String gradeName) {
		this.Content = gradeName;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String gradeDesc) {
		this.Title = gradeDesc;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String gradeDesc) {
		this.Time = gradeDesc;
	}
	
}
