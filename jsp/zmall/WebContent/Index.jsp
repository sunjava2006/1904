<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.wangrui.zmall.entity.Product"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<style>
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
                        ${msg}
                        <input type="reset" value="清除">
                        <input type="submit" value="添加">
                    </td>
                </tr>
            </table>
        </form>
<%
		Object o =  request.getAttribute("list");
		if(null != o){
%>
        <table id="list-table">
            <tr>
                <td>名称</td>
                <td>单价</td>
                <td>单位</td>
                <td>描述</td>
                <td></td>
            </tr>
<%
       
        	
            List<Product> list= (List<Product>)o;
            for( Product p : list ){
%>            
            <tr>
                <td><%=p.getName() %></td>
                <td><%=p.getPrice() %></td>
                <td><%=p.getUnit() %></td>
                <td><%=p.getDesc() %></td>
                <td><button>删除</button></td>
            </tr>
<%
            }
        }
%>            
        </table>

    </div>

    
</body>
</html>