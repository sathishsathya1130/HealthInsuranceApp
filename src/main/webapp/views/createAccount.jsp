<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create ADMIN</title>
</head>
<body>
	<h1>ADMIN MODULE</h1>
	<p>
		<font color="green">${succmsg}</font>
	</p>

	<p>
		<font color="red">${Errmsg}</font>
	</p>
	<form:form action="accountRegSuccess" modelAttribute="account" method="post">
		<table>
			<tr>
				<th>First Name:</th>
				<td><form:input path="firstName" id="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="lastName" id="lastName" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="email" id="email" /></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="gender" value="M" id="gender" />
					Female:<form:radiobutton path="gender" value="F" id="gender" />
				</td>
			</tr>
			<tr>
				<th>Role</th>
				<td><select id="role" name="role">
						
						<option value="CaseWorker">CASEWORKER</option>
						<option value="Admin">ADMIN</option>
				</select></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="create"></td>
			</tr>
		</table>

	</form:form>
	<a href="viewAccounts">VIEW ALL Accounts</a>
</body>
</html>