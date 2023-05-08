<%-- 
    Document   : zuoye
    Created on : 2019-7-21, 16:30:17
    Author     : gyt
--%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="testBean" class="manager.zuoyeBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>平时作业</title>
    </head>
    <body>
        <%
          String ID=session.getAttribute("ID").toString();
          String cishu=session.getAttribute("cishu").toString();
          String tihao1=session.getAttribute("tihao").toString();
          int tihao=Integer.parseInt(tihao1);
          String uri="jdbc:mysql://localhost:3306/system?"+"user=root&password=root&characterEncoding=gb2312";
          Connection con;
          Statement sql ;
          try{ Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
          try{con=DriverManager.getConnection(uri);
             sql=con.createStatement();
               ResultSet rs1,rs2,rs3,rs4;
            String condition2="SELECT * from question where tid='"+cishu+"' order by tihao";
           rs2=sql.executeQuery(condition2);
           if(rs2.next()){
  
            if(tihao!=0){
            String condition4="SELECT * from question where tid='"+cishu+"' and tihao='"+tihao1+"'";
            rs4=sql.executeQuery(condition4);
            if(rs4.next()){
                 testBean.setQuestion(rs4.getString("question"));
                 testBean.setChoiceA(rs4.getString("A"));
                 testBean.setChoiceB(rs4.getString("B"));
                 testBean.setChoiceC(rs4.getString("C"));
                 testBean.setChoiceD(rs4.getString("D"));
                 testBean.setPdda(rs4.getString("pdda"));
                 testBean.setTkda(rs4.getString("tkda"));
                 testBean.setJdda(rs4.getString("jdda"));
                 testBean.setCorrectAnswer(rs4.getString("xzda"));
                 testBean.setFenzhi(rs4.getFloat("grade"));
                 testBean.setMess("现在是第"+tihao+"题");
                 session.setAttribute("tihao",tihao1);
           
          String pdda=testBean.getPdda();
                     if(pdda!=null){%>
                     <br><b><jsp:getProperty name="testBean" property="question"/></b>
                     
                     <form action="PanfenServlet?tihao=<%= tihao1%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <input type="radio" name="panduan" value="T">正确
                         <input type="radio" name="panduan" value="F">错误
                         <br><input type="submit" name="submit" value="提交">
                     </form>
                    <% }
                     else{ 
                         String tkda=testBean.getTkda();
                         if(tkda!=null){%>
                             <br><b><jsp:getProperty name="testBean" property="question"/></b>
                             <%request.setCharacterEncoding("UTF-8");
                             String studentAnswer=request.getParameter("tiankong");
                       if(studentAnswer!=null&&studentAnswer.length()>=1){
                          testBean.setAnswer(studentAnswer.trim());
                       }
                     %>
                     <form action="PanfenServlet?tihao=<%= tihao1%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <br><input type="text" name="tiankong">
                         <br><input type="submit" value="提交" name="submit">
                     </form>
                         <%}
                         else{
                             String jdda=testBean.getJdda();
                             if(jdda!=null){%>
                             <br><b><jsp:getProperty name="testBean" property="question"/></b>
                             <% request.setCharacterEncoding("UTF-8");
                                 String studentAnswer=request.getParameter("jianda");
                       if(studentAnswer!=null&&studentAnswer.length()>=1){
                          testBean.setAnswer(studentAnswer.trim());
                       }
                     %>
                     <form action="PanfenServlet?tihao=<%= tihao1%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <br><textArea name="jianda" rows="10" cols="30"></textarea>
                         <br><input type="submit" value="提交" name="submit">
                     </form>
                            <% }
                             else{{%>
                                 <br><b><jsp:getProperty name="testBean" property="question"/></b>
                                 <br><br><jsp:getProperty name="testBean" property="choiceA"/>
                                 <br><br><jsp:getProperty name="testBean" property="choiceB"/>
                                 <br><br><jsp:getProperty name="testBean" property="choiceC"/>
                                 <br><br><jsp:getProperty name="testBean" property="choiceD"/>
                     <%String studentAnswer=request.getParameter("xuanze");
                       if(studentAnswer!=null&&studentAnswer.length()>=1){
                          testBean.setAnswer(studentAnswer.trim());
                       }
                     %>
                     <form action="PanfenServlet?tihao=<%= tihao1%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <input type="radio" name="xuanze" value="A">A
                         <input type="radio" name="xuanze" value="B">B
                         <input type="radio" name="xuanze" value="C">C
                         <input type="radio" name="xuanze" value="D">D
                         <br><input type="submit" name="submit" value="提交">
                     </form>
                     
                             <% }
                            }
                         } 
                     }}
            else{response.sendRedirect("showzy.jsp");}
            }
                     else{tihao++;
                     Integer tihao3=new Integer(tihao);
                     String tihao2=tihao3.toString();
                      String condition4="SELECT * from question where cishu='"+cishu+"' and tihao='"+tihao2+"'";
            rs4=sql.executeQuery(condition4);
            if(rs4.next()){
                 testBean.setQuestion(rs4.getString("question"));
                 testBean.setChoiceA(rs4.getString("A"));
                 testBean.setChoiceB(rs4.getString("B"));
                 testBean.setChoiceC(rs4.getString("C"));
                 testBean.setChoiceD(rs4.getString("D"));
                 testBean.setPdda(rs4.getString("pdda"));
                 testBean.setTkda(rs4.getString("tkda"));
                 testBean.setJdda(rs4.getString("jdda"));
                 testBean.setCorrectAnswer(rs4.getString("xzda"));
                 testBean.setFenzhi(rs4.getFloat("grade"));
                 testBean.setMess("现在是第"+tihao2+"题");
                 session.setAttribute("tihao",tihao2);
           
          String pdda=testBean.getPdda();
                     if(pdda!=null){%>
                     <br><b><jsp:getProperty name="testBean" property="question"/></b>
                     
                     <form action="PanfenServlet?tihao=<%= tihao2%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <input type="radio" name="panduan" value="T">正确
                         <input type="radio" name="panduan" value="F">错误
                         <br><input type="submit" name="submit" value="提交">
                     </form>
                     
                    <% }
                     else{ 
                         String tkda=testBean.getTkda();
                         if(tkda!=null){%>
                             <br><b><jsp:getProperty name="testBean" property="question"/></b>
                             <%request.setCharacterEncoding("UTF-8");
                             String studentAnswer=request.getParameter("tiankong");
                       if(studentAnswer!=null&&studentAnswer.length()>=1){
                          testBean.setAnswer(studentAnswer.trim());
                       }
                     %>
                     <form action="PanfenServlet?tihao=<%= tihao2%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <br><input type="text" name="tiankong">
                         <br><input type="submit" value="提交" name="submit">
                     </form>
                     
                         <%}
                         else{
                             String jdda=testBean.getJdda();
                             if(jdda!=null){%>
                             <br><b><jsp:getProperty name="testBean" property="question"/></b>
                             <% request.setCharacterEncoding("UTF-8");
                                 String studentAnswer=request.getParameter("jianda");
                       if(studentAnswer!=null&&studentAnswer.length()>=1){
                          testBean.setAnswer(studentAnswer.trim());
                       }
                     %>
                     <form action="PanfenServlet?tihao=<%= tihao2%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <br><textArea name="jianda" rows="10" cols="30"></textarea>
                         <br><input type="submit" value="提交" name="submit">
                     </form>
                       
                            <% }
                             else{{%>
                                 <br><b><jsp:getProperty name="testBean" property="question"/></b>
                                 <br><br><jsp:getProperty name="testBean" property="choiceA"/>
                                 <br><br><jsp:getProperty name="testBean" property="choiceB"/>
                                 <br><br><jsp:getProperty name="testBean" property="choiceC"/>
                                 <br><br><jsp:getProperty name="testBean" property="choiceD"/>
                     <%String studentAnswer=request.getParameter("xuanze");
                       if(studentAnswer!=null&&studentAnswer.length()>=1){
                          testBean.setAnswer(studentAnswer.trim());
                       }
                     %>
                     <form action="PanfenServlet?tihao=<%= tihao2%>&cishu=<%= cishu%>&ID=<%= ID%>" method="post" name="form">
                         <input type="radio" name="xuanze" value="A">A
                         <input type="radio" name="xuanze" value="B">B
                         <input type="radio" name="xuanze" value="C">C
                         <input type="radio" name="xuanze" value="D">D
                         <br><input type="submit" name="submit" value="提交">
                     </form>
                             <% }
                            }
                         } 
                     }
                     
                     
            }else{response.sendRedirect("showzy.jsp");}
            
            }
           
           }else {session.setAttribute("message", "老师未发布该次作业");con.close();response.sendRedirect("showzy.jsp");}
             
             con.close();
          }
        catch(SQLException ex){}
        
        
        
        %>
    </body>
</html>
