package com.java1234.model;

public class Grade {

	private int id;
        private String No;
	private String gradeName;
	private String gradeTeacher;
        private String gradeIP;
	
	
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Grade(String No,String gradeName, String gradeTeacher,String gradeIP) {
		super();
                this.No = No;
		this.gradeName = gradeName;
		this.gradeTeacher = gradeTeacher;
                this.gradeIP=gradeIP;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
        public String getNo() {
		return No;
	}
	public void setNo(String No) {
		this.No = No;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeTeacher() {
		return gradeTeacher;
	}
	public void setGradeTeacher(String gradeTeacher) {
		this.gradeTeacher = gradeTeacher;
	}
        public String getGradeIP() {
		return gradeIP;
	}
	public void setGradeIP(String gradeIP) {
		this.gradeIP = gradeIP;
	}
	
	
}
