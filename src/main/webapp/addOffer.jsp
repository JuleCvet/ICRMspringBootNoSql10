<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="org.ungur.clouddatastore.model.StatusEnum"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" type="text/javascript"></script>

<title>Create an offer</title>
<jsp:include page="cssandjs.jsp"/>
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet"/>	
</head>

<body>
<jsp:include page="menu.jsp"/>
<script type="text/javascript">

var dates = ['01/01/2018', '01/06/2018', '03/30/2018','04/01/2018', '04/02/2018', '05/01/2018', '05/10/2018', '05/20/2018', 
	 '06/06/2018', '06/22/2018','06/23/2018', '11/03/2018', '12/24/2018',  '12/25/2018',  '12/26/2018',  '12/31/2018'];
	 
  $( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd', firstDay: 1 , beforeShowDay: highlightDays});
  } );
  $( function() {
	    $( "#datepicker1" ).datepicker({ dateFormat: 'yy-mm-dd', firstDay: 1 , beforeShowDay: highlightDays});
 } );
  $( function() {
	    $( "#datepicker2" ).datepicker({ dateFormat: 'yy-mm-dd', firstDay: 1 , beforeShowDay: highlightDays});
} );

  function highlightDays(date) {
	    for (var i = 0; i < dates.length; i++) {
	        if (new Date(dates[i]).toString() == date.toString()) {
	            return [true, 'highlight'];
	        }
	    }
	    return [true, ''];
	} 
</script>
	<div class="container">
    <form:form method="POST" modelAttribute="addForm" class="form-signin">
        <h2 class="form-heading">Create Offer</h2>
        
        <spring:bind path="offerId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="offerId" class="form-control" placeholder="Offer-Id"
                            autofocus="true"></form:input>
                <form:errors path="offerId"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="assignmentID">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="assignmentID" class="form-control" placeholder="Assignment-Id"
                            autofocus="true"></form:input>
                <form:errors path="assignmentID"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="offerDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="offerDate" id="datepicker"
                class="form-control" placeholder="Offer Date"></form:input>
                <form:errors path="offerDate"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastUpdateDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="lastUpdateDate" path="lastUpdateDate"   
                class="form-control" placeholder="last Update Date" id="datepicker1"></form:input>
                <form:errors path="lastUpdateDate"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="agreementDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="agreementDate" path="agreementDate"   
                class="form-control" placeholder="Agreement Date" id="datepicker2"></form:input>
                <form:errors path="agreementDate"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="lastContact">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="lastContact" path="lastContact" class="form-control"
                            placeholder="Last contacted person"></form:input>
                <form:errors path="lastContact"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="comment">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="comment" path="comment" class="form-control"
                            placeholder="Comment"></form:input>
                <form:errors path="comment"></form:errors>
            </div>
        </spring:bind>
        
        <div class="form-group ${status.error ? 'has-error' : ''}">
			<form:select path="status" name="status" class="form-control" style="padding-bottom:5px; padding-top:5px;">
				<c:forEach items="<%=StatusEnum.values()%>" var="status">
					<option>${status}</option>
				</c:forEach>
			</form:select>
		</div>
        

        <button class="btn btn-lg btn-primary btn-block" style="background-color:#004077; border-color:#004077;" type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>