<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
				doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" omit-xml-declaration="true"/>

	<html xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jsp/jstl/core"
		  xmlns:security="http://www.springframework.org/security/tags">

	<head>
		<title>Offers</title>
		<jsp:include page="cssandjs.jsp"/>
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>
	</head>

	<body>
	<jsp:include page="menu.jsp"/>
	<div class="container">
		<br/>
		<h1>All Offers</h1>
		<table class="table table-striped table-bordered">
			<tr>
				<th>Assignment Id</th>
				<th>Offer Date</th>
				<th>Last Updated Date</th>
				<th>Agreement Date</th>
				<th>last contacted person</th>
				<th>Comment</th>
				<th>Status</th>
				<th>Update Assignment</th>
				<th>Delete Assignment</th>		
			</tr>
			<c:forEach var="offer" items="${list}">
				<tr>
					<td>${offer.assignmentID}</td>
					<td>${offer.offerDate}</td>
					<td>${offer.lastUpdateDate}</td>
					<td>${offer.agreementDate}</td>
					<td>${offer.lastContact}</td>
					<td>${offer.comment}</td>
					<td>${offer.status}</td>
					<td><a href="${pageContext.request.contextPath}/updateOffer/${offer.offerId}" style="color:#004085;"><b>Update</b></a></td>
					<td><a href="${pageContext.request.contextPath}/deleteOffer/${offer.offerId}" style="color:#004085;"><b>Delete</b></a></td>
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