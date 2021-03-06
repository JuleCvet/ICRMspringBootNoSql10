<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="primary-nav">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">
			<img style="width: 100px;" src="${pageContext.request.contextPath}/resources/img/logo.png">
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav w-75 justify-content-center" style="width:100%!important;">
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/users" style="color:#004085;" ><b>Show all employees</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/registration" style="color:#004085;"><b>Create new employee</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/addNyAssignment" style="color:#004085;"><b>Create new Assignment</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/viewAllAssignments" style="color:#004085;"><b>Show all Assignments</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/viewAlllUserAssignments" style="color:#004085;"><b>Show User-Assignments</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/create-userAssignment" style="color:#004085;"><b>Create User-Assignment</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/addOffer" style="color:#004085;"><b>Add Offer</b></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/viewOffers" style="color:#004085;"><b>View all Offers</b></a>
				</li>
				
			</ul>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				<ul class="nav navbar-nav ml-auto w-25 justify-content-end">
					<li class="nav-item">
						<a class="nav-link" onclick="document.forms['logoutForm'].submit()"style="color:#004085;" href="/welcome" ><b>Logout</b></a>
					</li>
				</ul>
			</c:if>
		</div>
	</nav>
</div>