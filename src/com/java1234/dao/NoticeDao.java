/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.java1234.model.Notice;
import com.java1234.model.PageBean;
import com.java1234.util.StringUtil;

public class NoticeDao {

	public ResultSet noticeList(Connection con,PageBean pageBean,Notice notice)throws Exception{
		StringBuffer sb=new StringBuffer("select * from notice");
		if(notice!=null && StringUtil.isNotEmpty(notice.getID())){
			sb.append(" and ID like '%"+notice.getID()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int noticeCount(Connection con,Notice notice)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from notice");
		if(StringUtil.isNotEmpty(notice.getID())){
			sb.append(" and ID like '%"+notice.getID()+"%'");
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
	
	
	public int noticeAdd(Connection con,Notice notice)throws Exception{
		String sql="insert into notice values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, notice.getID());
		pstmt.setString(2, notice.getTitle());
                pstmt.setString(3, notice.getContent());pstmt.setString(4, notice.getTime());
		return pstmt.executeUpdate();
	}
	
	
}