/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java1234.web;

import com.java1234.dao.TeacherDao;
import com.java1234.model.Grade;
import com.java1234.model.Teacher;
import com.java1234.util.DbUtil;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author gyt
 */
public class TeacherSaveServlet extends HttpServlet {
        DbUtil dbUtil=new DbUtil();
	TeacherDao teacherDao=new TeacherDao();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
                String No=request.getParameter("No");
		String Name=request.getParameter("Name");
		String Password=request.getParameter("Password");
		String ID=request.getParameter("ID");
		Teacher teacher=new Teacher(ID,Name,Password);
		if(StringUtil.isNotEmpty(No)){
                  teacher.setNo(Integer.parseInt(No));
                }
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(No)){
				saveNums=teacherDao.teacherModify(con, teacher);
			}else{
				saveNums=teacherDao.teacherAdd(con, teacher);
			}
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "修改失败");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
}
