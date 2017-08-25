<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加员工</title>
</head>
<body>
<form method="post" action="/springLianBiao/item/saveEmp">
用户名:<input type="text" name="ename"/><br>
部门:<select name="did" id="did">

<option value="-1">请选择</option>
<c:forEach items="${userlist }" var="d">
<option value="${d.id }">${d.dname }</option>
</c:forEach>
</select><br>
<input type="submit" value="提交"/>
</form>

</body>
</html>