package com.java1234.model;

import java.util.Date;

public class Student {

	
	private int id;
	private String username;
	private String pwd;
	private String name;
	private String sex;
        private String telephone;
        private String email;
        private String remark;
	
	
	
	public Student() {
		super();
	}
	
	
	public Student(String username,String pwd,String name,String sex,String telephone,String email,String remark) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.name = name;		
		this.sex = sex;
                this.telephone=telephone;
                this.email=email;
                this.remark=remark;
		
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
        public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
