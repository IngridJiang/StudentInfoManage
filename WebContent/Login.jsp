<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>平时作业发布与平时成绩管理系统</title>
    </head>
    <body style="text-align: center;" >
        <div class="center">
           <!--动态通知 start-->
       <div class="main_dttz">
         <div class="main_dttz_name f_l">
            </div>    
         <%-- 使用marquee标签, 在其中使用表达式进行输出 --%>
         <% request.setCharacterEncoding("UTF-8");  // 设置编码防止中文出现乱码
            Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "root");
            Statement sql=con.createStatement();
            ResultSet rs;
            String condition="SELECT * from notice order by ID desc limit 1 ";
            rs=sql.executeQuery(condition);
            rs.next();
            String info=rs.getString("Content");
            con.close();
         %> 
         <div class="main_dttz_news f_l">
             <marquee behavior="scroll" direction="left" onmouseover="this.stop()" onmouseout="this.start()" loop="-1" scrolldelay="200">
                 <%=info %>
             </marquee>
            <div align="center">
             <table background="images/login2.jpg"  width="740" height="500">
               <form action="Login_result.jsp" method="post">
                 <tr height="130"></tr>
                <tr height="10"> 
                   <td width="50%"></td>
                   <td width="10"> ID:</td>
                   <td><input type="text" name="name"></td>
                   <td width="30%"></td>
                </tr>
                <tr height="10"></tr>
                <tr height="10">
                    <td width="50%"></td>
                    <td width="10"> 密码:</td>
                    <td><input type="password" name="password"></td>
                    <td width="30%"></td>
                </tr> 
                <tr height="10">
                    <td width="50%"></td>
                    <td width="10%"></td>
                    <td><input type="radio" name="R" value="teacher">教师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="R" value="student">学生<td>
                    <td width="30%"></td>
                </tr>
                <tr height="10">
                    <td width="50%"></td>
                    <td width="10%"></td>
                    <td> <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重置"></td>
                </tr></form>
                <tr height="10"> </tr>
                <tr height="10">
                    <td width="50%"></td>
                    <td width="10%"></td>
                <td colspan="2"><a href="ChangePasswordForm.jsp">学生修改密码</a>
                &nbsp;&nbsp;&nbsp;<a href="TChangePasswordForm.jsp">教师修改密码</a></td>
                </tr>
                <tr height="20"></tr>
             </table></div></body>
</html>