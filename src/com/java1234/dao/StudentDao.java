package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.PageBean;
import com.java1234.model.Student;
import com.java1234.util.StringUtil;

public class StudentDao {

	public ResultSet studentList(Connection con,PageBean pageBean,Student student)throws Exception{
		StringBuilder sb=new StringBuilder("select * from user_info");
		if(StringUtil.isNotEmpty(student.getUsername())){
			sb.append(" and username like '%"+student.getUsername()+"%'");
		}
                if(StringUtil.isNotEmpty(student.getName())){
			sb.append(" and name like '%"+student.getName()+"%'");
		}
                if(StringUtil.isNotEmpty(student.getPwd())){
			sb.append(" and pwd like '%"+student.getPwd()+"%'");
		}
                if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and sex like '%"+student.getSex()+"%'");
		}
                if(StringUtil.isNotEmpty(student.getEmail())){
			sb.append(" and email like '%"+student.getEmail()+"%'");
		}
                if(StringUtil.isNotEmpty(student.getTelephone())){
			sb.append(" and telephone like '%"+student.getTelephone()+"%'");
		}
                if(StringUtil.isNotEmpty(student.getRemark())){
			sb.append(" and remark like '%"+student.getRemark()+"%'");
		}
		
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int studentCount(Connection con,Student student)throws Exception{
		StringBuilder sb=new StringBuilder("select count(*) as total from user_info");
		if(StringUtil.isNotEmpty(student.getUsername())){
			sb.append(" and username like '%").append(student.getUsername()).append("%'");
		}
		if(StringUtil.isNotEmpty(student.getName())){
			sb.append(" and name like '%").append(student.getName()).append("%'");
		}
                if(StringUtil.isNotEmpty(student.getPwd())){
			sb.append(" and pwd like '%").append(student.getPwd()).append("%'");
		}
                if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and sex like '%").append(student.getSex()).append("%'");
		}
		if(StringUtil.isNotEmpty(student.getEmail())){
			sb.append(" and email like '%").append(student.getEmail()).append("%'");
		}
                if(StringUtil.isNotEmpty(student.getTelephone())){
			sb.append(" and teleohone like '%").append(student.getTelephone()).append("%'");
		}
                if(StringUtil.isNotEmpty(student.getRemark())){
			sb.append(" and remark like '%").append(student.getRemark()).append("%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int studentDelete(Connection con,String delIds)throws Exception{
		String sql="delete from user_info where id in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int studentAdd(Connection con,Student student)throws Exception{
		String sql="insert into user_info values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getUsername());
		pstmt.setString(2, student.getPwd());
		pstmt.setString(3, student.getName());
		pstmt.setString(4, student.getSex());
		pstmt.setString(5, student.getTelephone());
                pstmt.setString(6, student.getEmail());
                pstmt.setString(7, student.getRemark());

	
		return pstmt.executeUpdate();
	}
	
	public int studentModify(Connection con,Student student)throws Exception{
		String sql="update user_info set username=?,name=?,pwd=?,sex=?,email=?,telephone=?,remark=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getUsername());
		pstmt.setString(2, student.getName());
		pstmt.setString(3, student.getPwd());
		pstmt.setString(4, student.getSex());
		pstmt.setString(5, student.getEmail());
                pstmt.setString(6, student.getTelephone());
                pstmt.setString(7, student.getRemark());
		pstmt.setInt(8, student.getId());
		return pstmt.executeUpdate();
	}
	
}
