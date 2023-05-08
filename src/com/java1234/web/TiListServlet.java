/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java1234.web;

import com.java1234.dao.TiDao;
import com.java1234.model.PageBean;
import com.java1234.model.Ti;
import com.java1234.util.DbUtil;
import com.java1234.util.JsonUtil;
import com.java1234.util.ResponseUtil;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author X
 */
public class TiListServlet extends HttpServlet {

   DbUtil dbUtil=new DbUtil();
	TiDao tiDao=new TiDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		String tId=request.getParameter("tId");
		if(tId==null){
			tId="";
		}
		Ti ti=new Ti();
		ti.setTId(tId);
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(tiDao.tiList(con, pageBean,ti));
			int total=tiDao.tiCount(con,ti);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);

		}catch(Exception e){e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {e.printStackTrace();
			}
		}
	}

    
   
}
