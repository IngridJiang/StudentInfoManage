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
public class ZytijiaoServlet extends HttpServlet {

    
   

    
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
                String type=request.getParameter("type");
                String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
                Connection con;
                Statement sql;
                try{ Class.forName("com.mysql.jdbc.Driver");
                   }
                catch(Exception e){}
               try{ con=DriverManager.getConnection(uri);
                 sql=con.createStatement();
                 if(type.equals("choices")){
                 String question=request.getParameter("xztimu");
                 String tihao=request.getParameter("xznum");
                 String optionA=request.getParameter("optionA");
                 String optionB=request.getParameter("optionB");
                 String optionC=request.getParameter("optionC");
                 String optionD=request.getParameter("optionD");
                 String xzda=request.getParameter("xzanswer");
                 String tid=request.getParameter("tid");
                 String fenzhi=request.getParameter("xzscore");
                 String condition="insert into question values('"+tid+"','"+question+"','"+optionA+"','"+optionB+"','"+optionC+"','"+optionD+"',null,null,null,'"+xzda+"','"+fenzhi+"','"+tihao+"',null)";
                 sql.executeUpdate(condition);
                 }
                 if(type.equals("panduan")){
                 String question=request.getParameter("ctimu");
                 String tihao=request.getParameter("cnum");
                 String pdda=request.getParameter("canswer");
                 String tid=request.getParameter("tid");
                 String fenzhi=request.getParameter("cscore");
                 String condition="insert into question values('"+tid+"','"+question+"',null,null,null,null,'"+pdda+"',null,null,null,'"+fenzhi+"','"+tihao+"',null)";
                 sql.executeUpdate(condition);
                 }
                 if(type.equals("completion")){
                 String question=request.getParameter("ctimu");
                 String tihao=request.getParameter("cnum");
                 String tkda=request.getParameter("canswer");
                 String tid=request.getParameter("tid");
                 String fenzhi=request.getParameter("cscore");
                 String condition="insert into question values('"+tid+"','"+question+"',null,null,null,null,null,'"+tkda+"',null,null,'"+fenzhi+"','"+tihao+"',null)";
                 sql.executeUpdate(condition);
                 }
                 if(type.equals("question")){
                 String question=request.getParameter("jdtimu");
                 String tihao=request.getParameter("qnum");
                 String jdda=request.getParameter("jdanswer");
                 String tid=request.getParameter("tid");
                 String fenzhi=request.getParameter("jdscore");
                 String condition="insert into question values('"+tid+"','"+question+"',null,null,null,null,null,null,'"+jdda+"',null,'"+fenzhi+"','"+tihao+"',null)";
                 sql.executeUpdate(condition);
                 }
                con.close();
                response.sendRedirect("zuoyetixing.jsp");
               
               
               }
               catch(SQLException ex){}
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
