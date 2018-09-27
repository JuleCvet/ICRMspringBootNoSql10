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
<title>Create an assignment</title>
	<jsp:include page="cssandjs.jsp"/>
	<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>
	
</head>
<body>
<jsp:include page="menu.jsp"/>

	<div class="container">
    <form:form method="POST" modelAttribute="assignmentForm" class="form-signin">
        <h2 class="form-heading">Create assignment</h2>
        
        <spring:bind path="assignmentId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="assignmentId" class="form-control" placeholder="Assignment-Id"
                            autofocus="true"></form:input>
                <form:errors path="assignmentId"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="customer">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="customer" class="form-control" placeholder="Customer"
                            autofocus="true"></form:input>
                <form:errors path="customer"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="partner">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="partner" class="form-control" placeholder="Partner"></form:input>
                <form:errors path="partner"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="role">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="role" path="role" class="form-control"
                            placeholder="Role"></form:input>
                <form:errors path="role"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="extend">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="extend" path="extend" class="form-control"
                            placeholder="Extend period"></form:input>
                <form:errors path="extend"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="startDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="startDate" path="startDate" class="form-control"
                            placeholder="Starting Date"></form:input>
                <form:errors path="startDate"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="endDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="endDate" path="endDate" class="form-control"
                            placeholder="Ending Date"></form:input>
                <form:errors path="endDate"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="comment">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="comment" path="comment" class="form-control"
                            placeholder="Comment"></form:input>
                <form:errors path="comment"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" style="background-color:#004077; border-color:#004077;" type="submit">Submit</button>
    </form:form>
</div>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>