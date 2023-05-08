/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gyt
 */
public class QiandaoServlet extends HttpServlet {
    private QiandaoBean qiandaoBean;

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
       PrintWriter out=response.getWriter();
        qiandaoBean=new QiandaoBean();
        String gradeName=request.getParameter("gradeName");
        String useriP=request.getRemoteAddr();
        String ID=request.getParameter("ID");
        HttpSession session=request.getSession(true);
         String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
         Connection con;
         Statement sql;
         try{ Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
         try{con=DriverManager.getConnection(uri);
        ResultSet rs1,rs2;
       sql=con.createStatement();
        String condition1="SELECT * from grade where gradeName='"+gradeName+"'";
        rs1=sql.executeQuery(condition1);
        if(rs1.next()){
           String No=rs1.getString("No");
           String ip=rs1.getString("gradeIP");
           String condition2="select * from qiandao where classID='"+No+
                   "' and studentID='"+ID+"'";
           rs2=sql.executeQuery(condition2);
           if(rs2.next()) {   
               if(useriP.equals(ip)){
               String condition3="update qiandao set qdnum=qdnum+1 where classID='"+No+
                   "' and studentID='"+ID+"'";
            sql.executeUpdate(condition3);
           session.setAttribute("message", "签到成功");}
        else{session.setAttribute("message", "你不在上课地点");}
          }
           
           else{session.setAttribute("message", "你未选该课程");}
        }
        else {session.setAttribute("message", "课程不存在");}
        con.close();
       } catch (SQLException ex) {
          out.print(ex);
    }
  

         response.sendRedirect("qiandao.jsp");
}
}