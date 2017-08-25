<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工显示</title>
<script type="text/javascript" src="/springLianBiao/js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 $("#tian1").click(function(){
			document.forms[1].action="/springLianBiao/item/depttian";
			document.forms[1].submit();
   });
	 $("#tian2").click(function(){
			document.forms[1].action="/springLianBiao/item/todeptAdd";
			document.forms[1].submit();
   });	 
});	 
function fun(){
	document.forms[0].action="/springLianBiao/item/mohu";
	document.forms[0].submit();

}
$(document).ready(function(){
	  $("#did").val(${udid});
});
</script>
</head>
<body>
<form action="/springLianBiao/item/mohu" method="post">

<!-- onkeyup当键盘上某个按键被按放开时触发的事件[注意:页面内必须有被聚焦的对象] -->
<input type="text" name="ename" value="${ename }" onkeyup="fun();" />

<!-- onchange 在内容改变发生 -->
部门<select id="did" name="did" onchange="fun();">
<option value=-1 >部门名</option>
<c:forEach items="${deptlist}" var="dept">
<option value=${dept.id } >${dept.dname }</option>
</c:forEach>
</select>
</form>

<!-- action="/springLianBiao/item/emptian" -->
<form method="post"  action="/springLianBiao/item/emptian">
<input type="button" value="添加员工" id="tian1">
<input type="button" value="添加部门" id="tian2">
 
<table width="100%" cellpadding="5" cellspacing="0" border="1">
<tr>
<td>编号</td><td>姓名</td><td>部门</td><td>操作</td>
</tr>
<c:forEach items="${userlist }" var="e" varStatus="stat">
<tr>
<td>${stat.index+1 }</td><td>${e.ename }</td><td>${e.dept.dname }</td>
<td><a href="/springLianBiao/item/initData/${e.id }">修改</a>
<a href="/springLianBiao/item/delete/${e.id }">删除</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>