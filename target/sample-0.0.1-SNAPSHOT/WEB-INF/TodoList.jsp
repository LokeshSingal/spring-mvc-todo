<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo List</title>
</head>
<body>
	<table>
		<tr>
			<td>Id</td>
			<td>Title</td>
			<td>Description</td>
			<td>Date</td>
		</tr>
		<c:forEach items="${todos}" var="todo">
			<tr>
			<td>${todo.id}</td>
			<td>${todo.title}</td>
			<td>${todo.description}</td>
			<td>${todo.date}</td>
			<td><a href ="${pageContext.request.contextPath}/Todo/${todo.id}">View/Edit</a></td>
			<td><a href ="${pageContext.request.contextPath}/Todo/delete/${todo.id}">Delete</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>