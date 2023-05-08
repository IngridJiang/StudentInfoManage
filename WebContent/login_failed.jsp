<%-- 
    Document   : login_failed
    Created on : 2019-7-14, 14:57:38
    Author     : X
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>登录失败</title>
    </head>
<body>
<hr><br>
  <h1><font color="red">账号或密码错误！</font></h1><br>
  <% 
     response.setHeader("Refresh","3;URL=Login.jsp"); 
  %> 
  3秒钟后页面将自动跳转到登录界面
<font color="red"><a href="Login.jsp">立即返回</a> </font>
</body>
</html>
