<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<script>
	function deleteConfirm() {
		return confirm("Are you sure, you want to delete?");
	}
</script>
<script>
	$(document).ready(function() {
		$('#adminTbL').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
</head>

<body>
	<h1>This is ADMIN View page</h1>

	<label for="role" >Select Role:</label>
	<select  name="role">
		<option value="CaseWorker">CASEWORKER</option>
		<option value="Admin">ADMIN</option>
	</select>

	<table border="1" id="adminTbL">


		<thead>
			<tr>
				<th>id</th>
				<th>Name</th>
				<!-- <th>LastName</th> -->
				<th>Email</th>
				<th>Gender</th>
				<th>Role</th>
				<th>Action</th>
				<!-- <th>Created Date</th>
				<th>Updated Date</th> -->
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${account}" var="a" varStatus="index">

				<tr>
					<td>${index.count}</td>
					<td>${a.firstName} ${a.lastName}</td>
					<%-- <td>${a.lastName}</td> --%>
					<td>${a.email}</td>
					<td>${a.gender}</td>
					<td>${a.role}</td>
					<td><a href="editAccount?id=${a.id} ">EDIT</a>
						&nbsp;&nbsp;||&nbsp;<a href="deleteAccount?id=${a.id}"
						onclick=" return deleteConfirm()">DELETE</a></td>
					<%-- <th>${a.createdDate}</th>
					<th>${a.updatedDate}</th> --%>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>