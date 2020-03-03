<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="Error.jsp"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小猪拼货</title>
</head>
<body>
    <div>
       总访问数：${applicationScope.totalAccess}
    </div>
    <div>
      当前在线用户数：${currentAccess}
    </div>
    
    <div>
      当前在线会员数：${memberAccess}
    </div>
</body>
</html>