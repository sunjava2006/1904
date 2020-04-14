<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>大家好</h1>

   
   <form action="/regist" method="post">
       <input type="text" name="userName">
       <input type="password" name="pwd">
       <input type="submit" value="注册">
   </form>
   
   <a href="./stuList?page=1&len=3">学生列表</a>
   ${applicationScope.accessCount}
</body>
</html>