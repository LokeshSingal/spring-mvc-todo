<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo Update</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/Todo/TodoManagement">Todo
		Home</a>

	<h3>Todo Detail</h3>
	<form:form method="POST" commandName="todo"
		action="${pageContext.request.contextPath}/Todo/update">
		<table>
			<tr>
				<td>Id:</td>
				<td><form:input path="id" readonly="true"/></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><form:input path="title"/></td>
			</tr>
		
			<tr>
				<td>Date:</td>
				<td><form:input path="date" /></td>
			</tr>
		
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="update"/></td>
			</tr>
		

		</table>
	</form:form>

</body>
</html>