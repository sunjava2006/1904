<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<style>
     body{
       background:gray;
     }
     #addtable{
         border: solid gray 2px;
         border-collapse: collapse;
         margin: auto;
         width:1000px;
     }
     #addtable td{
         /* border: solid gray 1px; */
     }
     #addtable tr:last-child>td>input{
         float: right;
     }
     #page{
         width: 80%;
         margin: auto;
         background:white;
     }
     #list-table{
         margin: auto;
         width:1000px;
         border: solid gray 2px;
         border-collapse: collapse;
     }
     #list-table>tr{
        border: solid gray 1px;
     }
</style>
</head>
<body>
    <div id="page">
        <form action="/add" method="POST">
            <table id="addtable">
                <tr>
                    <td>商品名</td>
                    <td>商品介绍</td>
                </tr>
                <tr>
                    <td><input type="text" name="name"></td>
                    <td rowspan="5"><textarea name="desc" cols="100" rows="10"></textarea></td>
                </tr>
                <tr>
                    <td>单价</td>
                
                </tr>
                <tr>
                    <td><input type="text" name="price"></td>
                
                </tr>
                <tr>
                    <td>单位</td>
                    
                </tr>
                <tr>
                    <td><input type="text" name="unit"></td>
                    
                </tr>
                <tr>
                    <td colspan="2" >
	<c:choose>
	    <c:when test="${ empty msg }">
	       <c:if test="${ !empty list }">
	                          添加成功
	       </c:if>
	    </c:when>
	   
	    <c:otherwise>
	       ${msg}
	    
	    </c:otherwise>
	</c:choose>                    
                    
                    
                        
                        <input type="reset" value="清除">
                        <input type="submit" value="添加">
                    </td>
                </tr>
            </table>
        </form>
 <c:if test="${ !empty requestScope.list }">
        <table id="list-table">
            <tr>
                <td>名称</td>
                <td>单价</td>
                <td>单位</td>
                <td>描述</td>
                <td>发布日期</td>
                <td></td>
            </tr>
  <c:forEach items="${requestScope.list}" var="i">          
            <tr>
                <td>${i.name}</td>
                <td>${i.price}</td>
                <td>${i.unit}</td>
                <td>${fn:substring(i.desc,0,20) }
             
                </td>
                <td><f:formatDate value="${i.publishDate}" pattern="yyyy-MM-dd"/></td>
                <td><button>删除</button></td>
            </tr>
  </c:forEach>         
        </table>
 </c:if>       
        

    </div>

    
</body>
</html>