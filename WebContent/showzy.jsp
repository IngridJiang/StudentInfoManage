<%-- 
    Document   : showzy
    Created on : 2019-7-20, 17:39:35
    Author     : gyt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userBean" class="manager.QiandaoBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>提交平时作业</title>
    </head>
    <body style="text-align: center">
        <%      String message="";
                message=(String)session.getAttribute("message2");
                String ID=request.getParameter("ID");
        %>
        <div align="center" style="padding-top: 50px;">
        <form action="ZuoyeServlet?ID=<%= ID%>" method="post" name="form">
            <table width="740" height="500" background="images/choice.jpg" >
                <tr height="130">
				<td colspan="4"></td>
			</tr>
                <tr height="10">
                    <td width="43%"></td>
                    <td width="10%">平时作业序号</td>
                    <td><input type="text" name="cishu" id="cishu" required="true"></td>
                    <td width="30%"></td>
                </tr>
                <tr height="10">
                    <td width="40%"></td>
                    <td width="10%"></td>
                    <td><input type="submit" name="submit" id="submit" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" name="reset" id="reset" value="重置"></td>
                    <td width="30%"></td>
                </tr>
                <tr height="10">
                    <td width="40%"></td>
                    <td width="10%"></td>
                    <td><div>&nbsp;<font color="red" >${message2}</font></div></td>
                    <td width="30%"></td>
                </tr>
                <tr height="100">    
                </tr>
            </table>
         </form>
                    
        </div>
    </body>
</html>
