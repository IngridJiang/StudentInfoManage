

package com.java1234.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.Teacher;
import com.java1234.model.PageBean;
import com.java1234.util.StringUtil;
/**
 *
 * @author gyt
 */
public class TeacherDao {
    public ResultSet teacherList(Connection con,PageBean pageBean,Teacher teacher)throws Exception{
		StringBuffer sb=new StringBuffer("select * from teacher");
		if(teacher!=null && StringUtil.isNotEmpty(teacher.getName())){
			sb.append(" and Name like '%"+teacher.getName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int teacherCount(Connection con,Teacher teacher)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from teacher");
		if(StringUtil.isNotEmpty(teacher.getName())){
			sb.append(" and Name like '%"+teacher.getName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
        
        public int teacherDelete(Connection con,String delIds)throws Exception{
		String sql="delete from teacher where No in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	public int teacherAdd(Connection con,Teacher teacher)throws Exception{
		String sql="insert into teacher values(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, teacher.getID());
		pstmt.setString(2, teacher.getName());
                pstmt.setString(3, teacher.getPassword());
		return pstmt.executeUpdate();
	}
	
	public int teacherModify(Connection con,Teacher teacher)throws Exception{
		String sql="update teacher set ID=?, Name=?,Password=? where No=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, teacher.getID());
                pstmt.setString(3, teacher.getName());
		pstmt.setString(2, teacher.getPassword());
		pstmt.setInt(4, teacher.getNo());
		return pstmt.executeUpdate();
	}
}
