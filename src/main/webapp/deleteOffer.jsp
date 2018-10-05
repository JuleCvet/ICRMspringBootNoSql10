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
    <title>Delete an offer</title>
    <jsp:include page="cssandjs.jsp"/>
    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>

</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <br/>
    <div class="alert alert-danger" role="alert" style="width:64%">
        <h4 class="alert-heading">Are you sure that you want to delete this offer?</h4>
    </div>
    <div class="container">
        <form:form method="POST" modelAttribute="deleteForm" class="form-signin">
            <h2 class="form-heading">Delete offer</h2>

        <spring:bind path="offerId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="offerId" class="form-control" placeholder="Offer-Id"
                            autofocus="true" disabled="true"></form:input>
                <form:errors path="offerId"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="assignmentID">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="assignmentID" class="form-control" placeholder="Assignment-Id"
                            autofocus="true" disabled="true"></form:input>
                <form:errors path="assignmentID"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="offerDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="offerDate" id="datepicker"
                class="form-control" placeholder="Offer Date" disabled="true"></form:input>
                <form:errors path="offerDate"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastUpdateDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="lastUpdateDate" path="lastUpdateDate"   id="datepicker" 
                class="form-control" placeholder="last Update Date" disabled="true"></form:input>
                <form:errors path="lastUpdateDate"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="agreementDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="agreementDate" path="agreementDate"   id="datepicker" 
                class="form-control" placeholder="Agreement Date" disabled="true"></form:input>
                <form:errors path="agreementDate"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="lastContact">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="lastContact" path="lastContact" class="form-control"
                            placeholder="Last contacted person" disabled="true"></form:input>
                <form:errors path="lastContact"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="comment">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="comment" path="comment" class="form-control"
                            placeholder="Comment" disabled="true"></form:input>
                <form:errors path="comment"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="status">        
        <div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type = "status" path="status" class="form-control"
				 placeholder="status" disabled="true"></form:input>
			<form:errors path="status"></form:errors>
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