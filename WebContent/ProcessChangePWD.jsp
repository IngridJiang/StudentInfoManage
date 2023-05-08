<%-- 
    Document   : ProcessChangePWD
    Created on : 2019-7-19, 15:35:54
    Author     : X
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
    String identity=request.getParameter("R");
String ID=request.getParameter("ID");
String OldPassword = request.getParameter("OldPassword");
String Newpass = request.getParameter("newpassword");
String conpass = request.getParameter("conpassword");


Connection con = null;
Statement st = null;
String pass = "";

try {
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/system";
con = DriverManager.getConnection(url, "root", "root");
st = con.createStatement();
ResultSet rs = st.executeQuery("select * from user_info where pwd= '"+ OldPassword + "' and username= '"+ ID + "'");
if (rs.next()) { 
pass = rs.getString("pwd");
} 
if(Newpass.equals(conpass))
{
if (pass.equals(OldPassword)) {
st = con.createStatement();
int i = st.executeUpdate("update user_info set pwd='"+ Newpass + "'where pwd= '"+ OldPassword + "' and username= '"+ ID + "'");
out.println("修改成功");%><a href="Login.jsp">返回登录界面<%
st.close();
con.close();
} else {
out.println("旧密码不正确");%><a href="Login.jsp">返回登录界面<%
}}
else{
out.println("二次输入密码不匹配");%><a href="Login.jsp">返回登录界面</a><%
}

} catch (Exception e) {
out.println(e);
}
%>
