package manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.ShowqdBean;

/**
 *
 * @author gyt
 */
public class ShowqdServlet extends HttpServlet {
    

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
       ShowqdBean resultBean=null;
       try{ resultBean=(ShowqdBean)request.getAttribute("resultBean");
               if(resultBean==null){
                 resultBean= new ShowqdBean();
                 request.setAttribute("resultBean", resultBean); 
               }
       }catch(Exception exp){
           resultBean= new ShowqdBean();
                 request.setAttribute("resultBean", resultBean); 
       }
       String gradeName=request.getParameter("gradeName");
        String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
         Connection con;
         Statement sql;
         HttpSession session=request.getSession(true);
          try{ Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
           try{con=DriverManager.getConnection(uri);
       sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs1,rs2;
       String condition1="SELECT * from grade where gradeName='"+gradeName+"'";
         rs1=sql.executeQuery(condition1);
         if(rs1.next()){
           String No=rs1.getString("No");
           String condition2="SELECT * from qiandao where classID='"+No+"'";
           rs2=sql.executeQuery(condition2);
           ResultSetMetaData metaData = rs2.getMetaData();
           int columnCount = metaData.getColumnCount();
           String[]columnName = new String[columnCount];
           for(int i=0;i<columnName.length;i++){
              columnName[i]=metaData.getColumnName(i+1);}
            resultBean.setColumnName(columnName);
              rs2.last();
              int rowNumber = rs2.getRow();
              String[][] tableRecord=resultBean.getTableRecord();
              tableRecord =new String[rowNumber][columnCount];
              rs2.beforeFirst();
              int i=0;
              while(rs2.next()){
               for(int k=0; k<columnCount;k++){
                 tableRecord[i][k]= rs2.getString(k+1);
                }  i++;}
               resultBean.setTableRecord(tableRecord);
               RequestDispatcher dispatcher=request.getRequestDispatcher("showRecord.jsp");
               dispatcher.forward(request,response);
           }
          else {session.setAttribute("message", "课程不存在");
                 response.sendRedirect("teacherqiandao.jsp");
         }
        con.close();
        
       } catch (SQLException ex) {
          
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
