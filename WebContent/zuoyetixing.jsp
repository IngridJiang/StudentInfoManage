<%-- 
    Document   : zuoyetixing
    Created on : 2019-7-24, 16:24:29
    Author     : gyt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="textml; charset=UTF-8">
        <title>作业发布窗口</title>
    </head>
    <body>
            <div class="header" position:fixed>
                <form action="" method="post">
              <table width="98%" border="1"bordercolor="#F0F0F0" bgcolor="#F5FEF9"align="center" cellpadding="2" cellspacing="0">
                  <tr><th colspan="2" bgcolor="#A3CBE0">题型选择</th> </tr>
                  <tr><td width="150" align="right">题目类型</td>
                      <td align="left">&nbsp;&nbsp;<input type="radio" name="Radio" value="choices">选择题
                                       &nbsp;&nbsp;<input type="radio" name="Radio" value="panduan">判断题
                                       &nbsp;&nbsp;<input type="radio" name="Radio" value="completion">填空题
                                       &nbsp;&nbsp;<input type="radio" name="Radio" value="question">简答题
                                       &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交"></td></tr>
              </form>
            
             <div class="content">
                 <%  String tmtype="";
                          tmtype=request.getParameter("Radio");
                     if(tmtype==null){
                          out.print("");
                     }
                     else{
                         if(tmtype.equals("choices")){
                  %>
                  <form action="ZytijiaoServlet?type=choices" method="post">
                      
                  <tr><th colspan="2" bgcolor="#A3CBE0">题目编辑</th> </tr>
                  <tr><td  width="80" align="right">试卷编号</td>
                      <td align="left"><input type="text" name="tid" size="80"></td></tr>
                  <tr><td  width="80" align="right">题目编号</td>
                      <td  align="left"><input type="text" name="xznum" size="80"></td></tr>
                  <tr><td  width="80" align="right">题目内容</td>
                      <td  align="left"><textarea  name="xztimu" rows="5" cols="80"></textarea></td>
                  <tr><td width="80" align="right">选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项</td>
                      <td align="left"> 
                          <table width="600" border="0" cellpadding="2" cellspacing="0">
                             <tr>  <td width="25%" align="left">A:&nbsp;</td>
                                   <td width="75%"align="left"><input type="text" name="optionA"size="80"></td></tr>
                             <tr>  <td width="25%" align="left">B:&nbsp;</td>
                                   <td width="75%" align="left"><input type="text" name="optionB" size="80"></td></tr>
                             <tr>  <td width="25%" align="left">C:&nbsp;</td>
                                   <td width="75%" align="left"><input type="text" name="optionC" size="80"></td></tr>
                             <tr>  <td width="25%" align="left">D:&nbsp;</td>
                                   <td width="75%" align="left"><input type="text" name="optionD" size="80"></td></tr>
                          </table></td></td></tr>
                  <tr> <td width="80" align="right">正确答案</td>
                          <td align="left"><input type="text" name="xzanswer" size="80"></td></tr>
                  <tr> <td width="80" align="right">题目分值</td>
                          <td align="left"><input type="text" name="xzscore" size="80"></td></tr>
             
                  <tr> <td colspan="2"><center><input type="submit" value="保存">
                        &nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></center></td></tr>
                   </table>
                       </form>
       <%     }
                         if(tmtype.equals("completion")){
                  %>     
                  <form action="ZytijiaoServlet?type=completion" method="post">
                         <tr><th colspan="2" bgcolor="#A3CBE0">题目编辑</th> </tr>
                         <tr><td  width="80" align="right">试卷编号</td>
                      <td><input type="text" name="tid" size="80"></td></tr>
                         <tr><td  align="right">题目编号</td>
                             <td><input type="text" name="cnum" size="80"></td></tr>
                         <tr><td  align="right">题目内容</td>
                             <td align="left"><textarea  name="ctimu" rows="5" cols="80"></textarea></td></tr>
                         <tr> <td width="80" align="right">正确答案</td>
                             <td align="left"><input type="text" name="canswer" size="80"></td></tr>
                         <tr> <td width="80" align="right">题目分值</td>
                             <td align="left"><input type="text" name="cscore" size="80"></td></tr>
                         <tr> <td colspan="2"><center><input type="submit" value="保存">
                             &nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></center></td></tr>
              </table>
             </form>    
                  <%     }
                         if(tmtype.equals("question")){
                  %>     
                  <form action="ZytijiaoServlet?type=question" method="post">
                        <tr><th colspan="2" bgcolor="#A3CBE0"> 题目编辑</th> </tr>
                        <tr><td  width="80" align="right">试卷编号</td>
                      <td><input type="text" name="tid" size="80"></td></tr>
                         <tr><td  align="right">题目编号</td>
                             <td><input type="text" name="qnum" size="80"></td></tr>
                         <tr><td  align="right">题目内容</td>
                             <td align="left"><textarea  name="jdtimu" rows="5" cols="80"></textarea></td></tr>
                         <tr> <td width="80" align="right">正确答案</td>
                             <td align="left"><input type="text" name="jdanswer" size="80"></td></tr>
                         <tr> <td width="80" align="right">题目分值</td>
                             <td align="left"><input type="text" name="jdscore" size="80"></td></tr>
                         <tr> <td colspan="2"><center><input type="submit" value="保存">
                             &nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></center></td></tr>
              </table>
             </form>
                   <%    }
                         if(tmtype.equals("panduan")){%>
                         <form action="ZytijiaoServlet?type=panduan" method="post">
                         <tr><th colspan="2" bgcolor="#A3CBE0">题目编辑</th> </tr>
                         <tr><td  width="80" align="right">试卷编号</td>
                      <td><input type="text" name="tid" size="80"></td></tr>
                         <tr><td  align="right">题目编号</td>
                             <td><input type="text" name="cnum" size="80"></td></tr>
                         <tr><td  align="right">题目内容</td>
                             <td align="left"><textarea  name="ctimu" rows="5" cols="80"></textarea></td></tr>
                         <tr> <td width="80" align="right">正确答案</td>
                             <td align="left"><input type="text" name="canswer" size="80"></td></tr>
                         <tr> <td width="80" align="right">题目分值</td>
                             <td align="left"><input type="text" name="cscore" size="80"></td></tr>
                         <tr> <td colspan="2"><center><input type="submit" value="保存">
                             &nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></center></td></tr>
              </table>
             </form> 
                        <% }
                   %>
                 <% }
                 %>
             </div>
         </table>
    </body>
</html>
