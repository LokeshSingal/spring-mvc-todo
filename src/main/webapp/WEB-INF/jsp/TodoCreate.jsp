<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Todo</title>
<a href="${pageContext.request.contextPath}/Todo/TodoManagement">Todos Home</a>
	<h3>Add New Todo</h3>
	<form:form method="POST" commandName="todo" action="add">
		<table>
			<tr>
				<td>Date</td>
				<td><form:input path="date" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</head>
<body>

</body>
</html>