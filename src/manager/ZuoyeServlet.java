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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gyt
 */
public class ZuoyeServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         zuoyeBean testBean=null;
         HttpSession session=request.getSession(true);
         String ID1=request.getParameter("ID");
         session.setAttribute("ID", ID1);
         String ID=(String)session.getAttribute("ID");
         try{ testBean=(zuoyeBean)request.getAttribute("testBean");
               if(testBean==null){
                 testBean= new zuoyeBean();
                 session.setAttribute("testBean", testBean); 
               }
       }catch(Exception exp){
           testBean= new zuoyeBean();
                 session.setAttribute("testBean", testBean); 
       }
         String cishu1=request.getParameter("cishu");
         session.setAttribute("cishu", cishu1);
         String cishu=(String)session.getAttribute("cishu");
         String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
         Connection con;
         Statement sql ;
         try{ Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
          try{con=DriverManager.getConnection(uri);
             sql=con.createStatement();
             ResultSet rs1,rs2,rs3,rs4;
             String condition2="SELECT * from question where tid='"+cishu+"'order by tihao";
             rs2=sql.executeQuery(condition2);
             if(rs2.next()){
               String condition3="Select * from chengji where tid='"+cishu+"'and studentID='"+ID+"'";
               rs3=sql.executeQuery(condition3);
               if(rs3.next()){}
               else{String condition4="insert into chengji values(null,'"+ID+"','"+cishu+"',0)";
               sql.executeUpdate(condition4);
               }
               session.setAttribute("tihao", "1");
               response.sendRedirect("zuoye.jsp");
            }
            else {session.setAttribute("message2", "老师未发布该次作业");con.close();response.sendRedirect("showzy.jsp");}
             con.close();
          } catch (SQLException ex) {
            Logger.getLogger(ZuoyeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   // </editor-fold>

}
