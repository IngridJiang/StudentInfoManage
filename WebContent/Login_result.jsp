<%-- 
    Document   : Login_result
    Created on : 2019-7-15, 17:56:08
    Author     : DELL
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录结果</title>
    </head>
<%!public String handleStr(String s){
     try{ byte[]bb=s.getBytes("iso-8859-1");
         s=new String(bb);
     }
     catch(Exception exp){}
        return s;
   }
%>
<body><font size="2"></font>
    <%     String identity=request.getParameter("R");
           String name=request.getParameter("name");//获取name的参数值
           String password=request.getParameter("password");//获取password的参数值
           Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "root");
           Statement stmt=conn.createStatement();
           if(identity.equals("teacher")){
           String queryNumberSQL="SELECT * from teacher where ID='"+name+"' and Password='"+password+"'";
            ResultSet rs=stmt.executeQuery(queryNumberSQL);//执行数据库查询操作并获取结果集
           boolean flag=false;//初始化flag
           if(rs.next()){//判断结果
               flag=true;
               session.setAttribute("ID", name);
               session.setAttribute("mession","");                                  //将name的内容赋值给UserName
           }else{
               flag=false;
             }
           rs.close();
           if(flag){
              response.sendRedirect("teacher.jsp"); 
           }
           else{
               response.sendRedirect("login_failed.jsp");}
           }
           else{String queryNumberSQL="SELECT * from user_info where username='"+name+"' and pwd='"+password+"'";
           ResultSet rs=stmt.executeQuery(queryNumberSQL);//执行数据库查询操作并获取结果集
           boolean flag=false;//初始化flag
           if(rs.next()){//判断结果
               flag=true;
               session.setAttribute("ID", name);
               session.setAttribute("mession","");                                  //将name的内容赋值给UserName
           }else{
               flag=false;
             }rs.close();
           if(flag){
                response.sendRedirect("student.jsp"); 
           }
           else{
               response.sendRedirect("login_failed.jsp");
              //out.print("账号或密码错误");
           }}
           
           stmt.close();
           conn.close();
    %>      
    </body>
</html>
