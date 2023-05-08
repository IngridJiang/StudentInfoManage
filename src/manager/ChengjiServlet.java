/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gyt
 */
public class ChengjiServlet extends HttpServlet {

    
    

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
        request.setCharacterEncoding("utf-8");
        String tid=request.getParameter("text");
        String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
         Connection con;
         Statement sql;
          try{ Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
           try{con=DriverManager.getConnection(uri);
           sql=con.createStatement();
           ResultSet rs1,rs2,rs3,rs4;
           String condition1="select userId,sum(mark) from result where tId='"+tid+"' GROUP BY userId ";
           rs1=sql.executeQuery(condition1);
           rs1.last();
           int row=rs1.getRow();
           for(int i=1;i<=row;i++){
           rs1.absolute(i);
           String studentID=rs1.getString("userId");
           String mark1=rs1.getString(2);
           int mark=Integer.parseInt(mark1);
           String condition2="update chengji set fenshu=fenshu+"+mark+" where studentID='"+studentID+"' and tID='"+tid+"'";
           sql.executeUpdate(condition2);
           }
           con.close();
           response.sendRedirect("scchengji.jsp");
           }
           catch(SQLException ex){}
        
    }

  

}
