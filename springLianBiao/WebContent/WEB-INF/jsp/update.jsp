<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页面</title>

<script type="text/javascript" src="/springLianBiao/js/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
   $("#did").val(${emp.dept.id});
});

</script>
</head>
<body>
<form method="post" action="/springLianBiao/item/update">
<input type="hidden" name="id" value="${emp.id }"/>
用户名<input type="text" name="ename" value="${emp.ename }"/><br>

部门<select name="did" id="did">
<option value="-1">选择部门</option>
<c:forEach items="${deptlist}" var="dept">
<option value=${dept.id }>${dept.dname }</option>
</c:forEach>
</select><br>
<input type="submit" value="提交"/>
</form>
</body>
</html>