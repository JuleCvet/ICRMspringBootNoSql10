<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>

<title>Create a User - Assignment</title>
<jsp:include page="cssandjs.jsp"/>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" />
</head>

<body>
<jsp:include page="menu.jsp"/>
<div class="container">
		<br/>
		<form:form method="POST" modelAttribute="createUserAssignment" class="form-signin">
		<!--<form action="#" th:action="@{/greeting}" th:object="${greeting}" method="post">-->
		<p>Today's date:<%= (new java.util.Date()).toLocaleString()%></p>
		<div class="form-group"></div>
		
			<h2>Select User</h2>
			<spring:bind path="id">
				<form:select class="form-control" style="padding-bottom:5px; padding-top:5px;" path="id">
				
					<c:forEach var="user" items="${listUsers}">
						<option value="${user.id}">${user.email}</option>
					</c:forEach>
				</form:select>
			</spring:bind>
			
			<h2>Select Assignment</h2>
			<spring:bind path="assignmentId">
				<form:select class="form-control" style="padding-bottom:5px; padding-top:5px;" path="assignmentId">
					<c:forEach var="assignment" items="${listAssignments}">
						<option value="${assignment.assignmentId}">${assignment.customer}</option>
					</c:forEach>
				</form:select>
			</spring:bind>	
						
			<button class="btn btn-lg btn-primary btn-block" type="submit" style="background-color:#337ab7;" >Submit</button>
		</form:form>
	</div>
</body>
</html>