/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java1234.model;

/**
 *
 * @author gyt
 */
public class Teacher {
    private int No;
        private String ID;
	private String Name;
	private String Password;
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Teacher(String ID,String Password,String Name) {
		super();
                this.ID=ID;
		this.Name = Name;
		this.Password = Password;
	}


	public int getNo() {
		return No;
	}
	public void setNo(int No) {
		this.No = No;
	}
        public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
}
