<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Update an User-Assignment</title>
<jsp:include page="cssandjs.jsp"/>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>
	
</head>
<body>
<jsp:include page="menu.jsp"/>

	<div class="container">
    <form:form method="POST" modelAttribute="updateForm" class="form-signin">
        <h2 class="form-heading">Update User- Assignment</h2>
        
        <spring:bind path="userID">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userID" class="form-control" placeholder="User id"
                            autofocus="true"></form:input>
                <form:errors path="userID"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="assignmentId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="assignmentId" class="form-control"
                            placeholder="Assignment-Id"></form:input>
                <form:errors path="assignmentId"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" style="background-color:#004077; border-color:#004077;" type="submit">Submit</button>
    </form:form>
</div>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>