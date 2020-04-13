<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="login" method="post">
      <input type="text" name="userName">
      <input type="password" name="pwd">
      <input type="submit" value="登录">
   </form>
   <%
     application.setAttribute("msg", "HI");
   %>
</body>
</html>