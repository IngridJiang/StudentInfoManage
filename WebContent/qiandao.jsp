<%-- 
    Document   : qiandao
    Created on : 2019-7-19, 15:37:45
    Author     : gyt
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<jsp:useBean id="userBean" class="manager.QiandaoBean" scope="session"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>签到</title>
    </head>
    <center>
    <body style="text-align: center">
        <%      String message="";
                message=(String)session.getAttribute("message");
                String ID=request.getParameter("ID");
        %>
        <div align="center" style="padding-top: 50px;">
        <form action="QiandaoServlet?ID=<%= ID%>" method="post" name="form">
            <table width="740" height="500" background="images/check.jpg" >
                <tr height="130">
				<td colspan="4"></td>
			</tr>
                <tr height="10">
                    <td width="43%"></td>
                    <td width="10%">课程名称</td>
                    <td><input type="text" name="gradeName" id="gradeName" required="true"></td>
                    <td width="30%"></td>
                </tr>
                <tr height="10">
                    <td width="40%"></td>
                    <td width="10%"></td>
                    <td><input type="submit" name="submit" id="submit" value="签到">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" name="reset" id="reset" value="重置"></td>
                    <td width="30%"></td>
                </tr>
                <tr height="10">
                    <td width="40%"></td>
                    <td width="10%"></td>
                    <td><div>&nbsp;<font color="red" >${message}</font></div></td>
                    <td width="30%"></td>
                </tr>
                <tr height="100">    
                </tr>
            </table>
         </form>
        </div>
    </body>
    </center>
</html>
