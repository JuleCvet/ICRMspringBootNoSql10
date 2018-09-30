<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
				doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" omit-xml-declaration="true"/>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jsp/jstl/core"
		  xmlns:security="http://www.springframework.org/security/tags">

<head>
	<title>User-Assignments</title>
	<jsp:include page="cssandjs.jsp"/>
	<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>
</head>

<body>
	<jsp:include page="menu.jsp"/>
	<div class="container">
		<br/>
		<h1>All User - Assignments</h1>
		<table class="table table-striped table-bordered">
			<tr>
				<th>User Id</th>
				<th>Assignment-Id</th>
				<th>Update User-Assignment</th>
				<th>Delete User-Assignment</th>
				<th>View status</th>
				
			</tr>
			<c:forEach var="userAssignment" items="${list}">
				<tr>
					<td>${userAssignment.id}</td>
					<td>${userAssignment.assignmentId}</td>
					<td><a href="${pageContext.request.contextPath}/updateUserAssignment/${userAssignment.userAssignmentId}" style="color:#004085;"><b>Update</b></a></td>
					<td><a href="${pageContext.request.contextPath}/deleteUserAssignment/${userAssignment.userAssignmentId}" style="color:#004085;"><b>Delete</b></a></td>
					<td><a href="${pageContext.request.contextPath}/viewStatus" style="color:#004085;"><b>Status</b></a></td>
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