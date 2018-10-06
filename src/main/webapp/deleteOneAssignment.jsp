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
<title>Delete an assignment</title>
<jsp:include page="cssandjs.jsp"/>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>

</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <br/>
    <div class="alert alert-danger" role="alert" style="width:68%">
        <h4 class="alert-heading">Are you sure that you want to delete this assignment?</h4>
    </div>
    <div class="container">
        <form:form method="POST" modelAttribute="deleteAssignment" class="form-signin">
            <h2 class="form-heading">Delete assignment</h2>

            <spring:bind path="customer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="customer" class="form-control" placeholder="Customer"
                                autofocus="true" disabled="true"></form:input>
                    <form:errors path="customer"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="partner">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="partner" path="partner" class="form-control"
                                placeholder="Partner" disabled="true"></form:input>
                    <form:errors path="partner"></form:errors>
                </div>
            </spring:bind>
            
              <spring:bind path="role">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="role" path="role" class="form-control"
                                placeholder="Role" disabled="true"></form:input>
                    <form:errors path="role"></form:errors>
                </div>
            </spring:bind>
            
              <spring:bind path="extend">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="extend" path="extend" class="form-control"
                                placeholder="Extended period" disabled="true"></form:input>
                    <form:errors path="extend"></form:errors>
                </div>
            </spring:bind>
            
              <spring:bind path="startDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="startDate" path="startDate" class="form-control"
                                placeholder="Starting Date" disabled="true"></form:input>
                    <form:errors path="startDate"></form:errors>
                </div>
            </spring:bind>
            
              <spring:bind path="endDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="endDate" path="endDate" class="form-control"
                                placeholder="Ending Date" disabled="true"></form:input>
                    <form:errors path="endDate"></form:errors>
                </div>
            </spring:bind>
            
              <spring:bind path="comment">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="comment" path="comment" class="form-control"
                                placeholder="Comment" disabled="true"></form:input>
                    <form:errors path="comment"></form:errors>
                </div>
            </spring:bind>
            

            <button class="btn btn-lg btn-primary btn-block" style="background-color:#004077; border-color:#004077;" type="submit">Delete</button>
        </form:form>
    </div>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
   </div>
</body>
</html>