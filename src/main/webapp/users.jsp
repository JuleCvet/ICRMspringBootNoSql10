<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
				doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" omit-xml-declaration="true"/>

	<html xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jsp/jstl/core"
		  xmlns:security="http://www.springframework.org/security/tags">

	<head>
		<title>Users</title>
		<jsp:include page="cssandjs.jsp"/>
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>
	</head>

	<body>
	<jsp:include page="menu.jsp"/>
	<div class="container">
		<br/>
		<h1>All Employees</h1>
		<table class="table table-striped table-bordered">
			<tr>
				<th>Employee email</th>
				<th>Full name</th>
				<th>Update employee</th>
				<th>Delete account</th>
				<th>View status</th>
				<th>View assignment</th>
				
			</tr>
			<c:forEach var="user" items="${list}">
				<tr>
					<td>${user.email}</td>
					<td>${user.fullName}</td>
					<td><a href="${pageContext.request.contextPath}/updateuser/${user.id}" style="color:#004085;"><b>Update</b></a></td>
					<td><a href="${pageContext.request.contextPath}/delete/${user.id}" style="color:#004085;"><b>Delete</b></a></td>
					<td><a href="${pageContext.request.contextPath}//${user.id}" style="color:#004085;"><b>Status</b></a></td>
					<td><a href="${pageContext.request.contextPath}/viewAllAssignments" style="color:#004085;"><b>Assignment</b></a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
	</html>
</jsp:root>