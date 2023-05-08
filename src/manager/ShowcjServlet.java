/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ShowcjServlet extends HttpServlet {


   
  
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
       String ID=request.getParameter("ID");
       String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
         Connection con;
         Statement sql;
        try{ Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
         try{con=DriverManager.getConnection(uri);
       sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet rs;
        String condition="SELECT * from chengji where studentID='"+ID+"'";
         rs=sql.executeQuery(condition);
          ResultSetMetaData metaData = rs.getMetaData();
           int columnCount = metaData.getColumnCount();
           String[]columnName = new String[columnCount];
           for(int i=0;i<columnName.length;i++){
              columnName[i]=metaData.getColumnName(i+1);}
            resultBean.setColumnName(columnName);
              rs.last();
              int rowNumber = rs.getRow();
              String[][] tableRecord=resultBean.getTableRecord();
              tableRecord =new String[rowNumber][columnCount];
              rs.beforeFirst();
              int i=0;
              while(rs.next()){
               for(int k=0; k<columnCount;k++){
                 tableRecord[i][k]= rs.getString(k+1);
                }  i++;}
               resultBean.setTableRecord(tableRecord);
               RequestDispatcher dispatcher=request.getRequestDispatcher("showRecord.jsp");
               dispatcher.forward(request,response);
               con.close();
                 } catch (SQLException ex) {}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 

}
