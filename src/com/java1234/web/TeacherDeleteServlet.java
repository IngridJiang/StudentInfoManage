/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java1234.web;

import com.java1234.dao.TeacherDao;
import com.java1234.util.DbUtil;
import com.java1234.util.ResponseUtil;
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
public class TeacherDeleteServlet extends HttpServlet {

  DbUtil dbUtil=new DbUtil();
	TeacherDao teacherDao=new TeacherDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String delIds=request.getParameter("delIds");
		Connection con=null;
                try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			int delNums=teacherDao.teacherDelete(con, delIds);
                        if(delNums>0){
                            result.put("success","true");
                            result.put("delNums", delNums);
                        }else{
                            result.put("errorMag", "删除失败");
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
