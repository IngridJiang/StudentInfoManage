/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java1234.web;

import com.java1234.dao.TiDao;
import com.java1234.model.Ti;
import com.java1234.util.DbUtil;
import com.java1234.util.ResponseUtil;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author X
 */
public class TiSaveServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		String tId=request.getParameter("tId");
		String userId=request.getParameter("userId");
		String mark=request.getParameter("mark");
		String answer=request.getParameter("answer");
                String id=request.getParameter("id");
		Ti ti=new Ti(tId,userId,mark,answer);
		ti.setId(Integer.parseInt(id));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			
				saveNums=tiDao.tiModify(con, ti);
			
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "����ʧ��");
			}
			ResponseUtil.write(response, result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

    
}
