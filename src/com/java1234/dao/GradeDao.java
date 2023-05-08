package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.Grade;
import com.java1234.model.PageBean;
import com.java1234.util.StringUtil;

public class GradeDao {

	public ResultSet gradeList(Connection con,PageBean pageBean,Grade grade)throws Exception{
		StringBuffer sb=new StringBuffer("select * from grade");
		if(grade!=null && StringUtil.isNotEmpty(grade.getGradeName())){
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int gradeCount(Connection con,Grade grade)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from grade");
		if(StringUtil.isNotEmpty(grade.getGradeName())){
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	/**
	 * delete from tableName where field in (1,3,5)
	 * @param con
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int gradeDelete(Connection con,String delIds)throws Exception{
		String sql="delete from grade where id in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int gradeAdd(Connection con,Grade grade)throws Exception{
		String sql="insert into grade values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1, grade.getNo());
		pstmt.setString(2, grade.getGradeName());
		pstmt.setString(3, grade.getGradeTeacher());
                pstmt.setString(4, grade.getGradeIP());
		return pstmt.executeUpdate();
	}
	
	public int gradeModify(Connection con,Grade grade)throws Exception{
		String sql="update grade set No=?,gradeName=?,gradeTeacher=?,gradeIP=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, grade.getNo());
		pstmt.setString(2, grade.getGradeName());
                pstmt.setString(3, grade.getGradeTeacher());
                pstmt.setString(4, grade.getGradeIP());
		pstmt.setInt(5, grade.getId());
                
		return pstmt.executeUpdate();
	}
	
}
