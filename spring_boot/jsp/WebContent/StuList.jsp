<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.thzhima.fuxi.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <%
       List<Student> list = (List<Student>)request.getAttribute("list");
       
   %>
   <table>
      <%
          for(Student s : list){
      %>  
      <tr>
         <td><%=s.getID() %></td>
         <td><% out.print(s.getStudentName()); %></td>
      </tr>  
      <%  	  
          }
      
      %>
   
   </table>
   <%
       long totalPage = (long)request.getAttribute("totalPage");
       long currPage = (long)request.getAttribute("currPage");
       long totalCount = (long)request.getAttribute("totalCount");
   %>
   <%
       if(currPage>1){
    	   System.out.println(currPage);
   %>
   <a href="./stuList?page=<%=currPage-1 %>&len=3">上一页</a>
   <%
       }
   %>
   <%
       if(currPage<totalPage){
   %>
   <a href="./stuList?page=<%=currPage+1 %>&len=3">下一页</a>
   <%
       }
   %>
</body>
</html>