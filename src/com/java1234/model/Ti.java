/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java1234.model;

/**
 *
 * @author X
 */
public class Ti {
    private int id;
	private String tId;
	private String userId;
	private String mark;
	private String answer;
        
	
	
	
	public Ti() {
		super();
	}
	
	
	/**
     *
     * @param tId
     * @param userId
     * @param mark
     * @param answer
     
     */
    public Ti(String tId, String userId, String mark,String answer) {
		super();
		this.tId = tId;
		this.userId = userId;
		this.mark = mark;		
		this.answer = answer;
                
	}



	public int getId() {
		return id;
	}
	public void setId(int a) {
		this.id = a;
	}
        public String getTId() {
		return tId;
	}
	public void setTId(String a) {
		this.tId = a;
	}
        public String getUserId() {
		return userId;
	}
	public void setUserId(String a) {
		this.userId = a;
	}
        public String getMark() {
		return mark;
	}
	public void setMark(String ID) {
		this.mark = ID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String Name) {
		this.answer = Name;
	}
	
	
    
}
