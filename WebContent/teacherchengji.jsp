<%-- 
    Document   : teacherchengji
    Created on : 2019-7-24, 18:55:13
    Author     : gyt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>成绩</title>
    </head>
    <body style="text-align: center">
        <%      String message="";
                message=(String)session.getAttribute("message");
        %>
        <div align="center" style="padding-top: 50px;">
        <form action="ShowcjtServlet" method="post" name="form">
            <table width="740" height="500" background="images/checkresult.jpg">
                <tr height="130">
				<td colspan="4"></td>
			</tr>
                <tr height="10">
                     <td width="40%"></td>
                    <td width="10%">试卷编号</td>
                    <td><input type="text" name="gradeName" id="gradeName" required="true"></td>
                    <td width="30%"></td>
                </tr>
                <tr height="10">
                    <td width="40%"></td>
                    <td width="10%"></td>
                    <td><input type="submit" name="submit" id="submit" value="查看">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" name="reset" id="reset" value="重置"></td>
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
		
	</div>
         </form>
          </div>
    </body>
</html>
