<%-- 
    Document   : showRecord
    Created on : 2019-7-18, 19:11:58
    Author     : gyt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="resultBean"
             class="manager.ShowqdBean" scope="request"/>

<html>
    <body><font size=2 style="margin: 5px;">
        <table border=1>
            <%String []columnName=resultBean.getColumnName();%>
            <tr>
               <%for(String s:columnName){%>
               <th><%=s%></th><%
} %>     
            </tr>
            <%String [][] record= resultBean.getTableRecord();
            for(int i=0;i<record.length;i++){%><tr>
                <% for(int j=0;j<record[i].length;j++){%>
                <td><%=record[i][j]%></td><%}%>
            </tr><%}%>
            
        </table></font></body>
</html>
