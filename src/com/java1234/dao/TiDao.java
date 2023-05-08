/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java1234.dao;

import com.java1234.model.PageBean;
import com.java1234.model.Ti;
import com.java1234.util.StringUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author X
 */
public class TiDao {
    public ResultSet tiList(Connection con,PageBean pageBean,Ti ti)throws Exception{
		StringBuffer sb=new StringBuffer("select * from result");
		if(ti!=null &&StringUtil.isNotEmpty(ti.getTId())){
			sb.append(" and tId like '%"+ti.getTId()+"%'");
		}
                
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int tiCount(Connection con,Ti ti)throws Exception{
		StringBuilder sb=new StringBuilder("select count(*) as total from result");
		if(StringUtil.isNotEmpty(ti.getTId())){
			sb.append(" and tId like '%"+ti.getTId()+"%'");
		}
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	
	
	
	
	public int tiModify(Connection con,Ti ti)throws Exception{
		String sql="update result set mark=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, ti.getMark());
                
		pstmt.setInt(2, ti.getId());
		return pstmt.executeUpdate();
	}
    
}
