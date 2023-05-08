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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PanfenServlet extends HttpServlet {


   
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
        zuoyeBean zyBean=new zuoyeBean();
        String tihao1=request.getParameter("tihao");
        String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
        String gradeName=request.getParameter("gradeName");
        String cishu1=request.getParameter("cishu");
        String ID=request.getParameter("ID");
        int cishu= Integer.parseInt(cishu1);
        HttpSession session=request.getSession(true);
        Connection con;
         Statement sql ;
          try{ Class.forName("com.mysql.jdbc.Driver");
          }
           catch(Exception e){}
          try{con=DriverManager.getConnection(uri);
             sql=con.createStatement();
             ResultSet rs1,rs2,rs3,rs4;
              int tihao=0;
              if(tihao1!=null&&tihao1.length()>=1){tihao= Integer.parseInt(tihao1);}
               String condition2="SELECT * from question where tid='"+cishu1+"' and tihao='"+tihao+"'";
               rs2=sql.executeQuery(condition2);
               rs2.next();
                 zyBean.setPdda(rs2.getString("pdda"));
                 zyBean.setTkda(rs2.getString("tkda"));
                 zyBean.setJdda(rs2.getString("jdda"));
                 zyBean.setCorrectAnswer(rs2.getString("xzda"));
                 zyBean.setFenzhi(rs2.getFloat("grade"));
                  String pdda=zyBean.getPdda();
                 if(pdda!=null){
                     String studentAnswer=request.getParameter("panduan");
                         if(studentAnswer.equals(pdda)){
                             String condition3="SELECT * from chengji where tid='"+cishu+"' and studentID='"+ID+"'";
                             rs3=sql.executeQuery(condition3);
                              float fenzhi=zyBean.getFenzhi();
                             if(rs3.next()){
                
                             float score=rs3.getFloat("fenshu");
                             score=score+fenzhi;
                             String condition4="Update chengji set fenshu="+score+" where tid='"+cishu+"' and studentID='"+ID+"'";
                             sql.executeUpdate(condition4);
                             }
                             else{
                             String condition4="Update chengji set fenshu="+fenzhi+" where tid='"+cishu+"' and studentID='"+ID+"'";
                             sql.executeUpdate(condition4);
                             }
                         }
                     }
                     else{ 
                         String tkda=zyBean.getTkda();
                         if(tkda!=null){
                              String studentAnswer=request.getParameter("tiankong");
                            if(studentAnswer.equals(tkda)){
                             String condition3="SELECT * from chengji where tid='"+cishu+"' and studentID='"+ID+"'";
                             rs3=sql.executeQuery(condition3);
                              float fenzhi=zyBean.getFenzhi();
                             if(rs3.next()){
                
                             float score=rs3.getFloat("fenshu");
                             score=score+fenzhi;
                             String condition4="Update chengji set fenshu="+score+" where tid='"+cishu+"' and studentID='"+ID+"'";
                             sql.executeUpdate(condition4);
                             }
                             else{
                             String condition4="Update chengji set fenshu="+fenzhi+" where tid='"+cishu+"' and studentID='"+ID+"'";
                             sql.executeUpdate(condition4);
                             }
                         }
                     }
                         else{
                             String jdda=zyBean.getJdda();
                             if(jdda!=null){
                                 String studentAnswer=request.getParameter("jianda");
                             String condition3="insert into result values(null,'"+cishu+"','"+ID+"',0,'"+studentAnswer+"')";
                             sql.executeUpdate(condition3);
                             }
                             else{
                                 String studentAnswer=request.getParameter("xuanze");
                                 if(studentAnswer.equals(zyBean.getCorrectAnswer())){
                                 String condition3="SELECT * from chengji where tid='"+cishu+"'and studentID='"+ID+"'";
                             rs3=sql.executeQuery(condition3);
                              float fenzhi=zyBean.getFenzhi();
                             if(rs3.next()){
                
                             float score=rs3.getFloat("fenshu");
                             score=score+fenzhi;
                             String condition4="Update chengji set fenshu="+score+" where tid='"+cishu+"' and studentID='"+ID+"'";
                             sql.executeUpdate(condition4);
                             }
                             else{
                             String condition4="Update chengji set fenshu="+fenzhi+" where tid='"+cishu+"' and studentID='"+ID+"'";
                             sql.executeUpdate(condition4);
                             }
                                 }
                             }
                         } 
                     }
                 tihao=tihao+1;
                 Integer tihao4=new Integer(tihao);
                 String tihao2=tihao4.toString();
                 session.setAttribute("tihao", tihao2);
                 session.setAttribute("gradeName", gradeName);
                 session.setAttribute("cishu", cishu);
                 session.setAttribute("ID", ID);
                 response.sendRedirect("zuoye.jsp");
          }
          
          catch(SQLException ex){ Logger.getLogger(ZuoyeServlet.class.getName()).log(Level.SEVERE, null, ex);}
    }



}
