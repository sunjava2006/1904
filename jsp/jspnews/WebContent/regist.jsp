<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    table{border:solid black 1px}
    td{border-bottom:solid black 1px;}

</style>
</head>
<body>
   <form action="/regist" method="post">
	   <table style="width:400px;height:300px; margin:auto;">
	       <tr>
	           <td>用户名</td>
	           <td><input type="text" name="userName"></td>
	       </tr>
	        <tr>
	           <td>密码</td>
	           <td><input type="password" name="password"></td>
	       </tr>
	        <tr>
	           <td>验证码</td>
	           <td>
	               <input type="text" name="code">
	               <img src="/code" onclick="this.src='/code?1='+Math.random()"  title="点击更换验证码">
	           
	           </td>
	           
	       </tr>
	       <tr>
	           <td>
	           </td>
	         
	           <td>
	             ${msg}<!-- EL 表达式 -->
	           <%--
	               String msg = (String)request.getAttribute("msg");
	               if(null != msg){
	            	   out.print(msg);
	               }
	               
	           --%>
	           
	           <input type="submit" name="注册" style="float:right"></td>
	       </tr>
	   </table>
   </form>
</body>
</html>