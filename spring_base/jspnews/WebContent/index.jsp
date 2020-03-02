<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
     String userName = request.getParameter("userName");
     if("Wang".equals(userName)){
    	 out.print("你好：" + userName);
     }
     else if ("Zhang".equals(userName)){
    	 out.print("很不好");
     }
     else{
    	 response.sendRedirect("http://www.qq.com");
     }
 %>

</body>
</html>