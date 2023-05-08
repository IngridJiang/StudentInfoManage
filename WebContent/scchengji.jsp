<%-- 
    Document   : scchengji
    Created on : 2019-7-25, 15:03:43
    Author     : gyt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>生成成绩</title>
    </head>
    <body>
        <div align="center" style="padding-top: 50px;">
        <form action="ChengjiServlet" method="post" name="form">
            <table width="740" height="500" background="images/sccj.jpg" >
                <tr height="130">
				<td colspan="4"></td>
			</tr>
                <tr height="10">
                    <td width="43%"></td>
                    <td width="10%">平时作业序号</td>
                    <td><input type="text" name="text" id="text" required="true"></td>
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
                    <td></td>
                    <td width="30%"></td>
                </tr>
                <tr height="100">    
                </tr>
            </table>
         </form>
                    
        </div>
    </body>
</html>
