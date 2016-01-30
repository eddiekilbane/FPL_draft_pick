<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>FPL - Player Selection</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/js/draftSelection.js"
	var="draftSelectionJs" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script  src="${draftSelectionJs}"></script>

<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
$(document).ready(function(){
	DraftSelection.initDraftSelection();
});

</script>

</head>

<body>
	<!-- Header  -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">FPL Draft Pick</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li id="users_team"><a href="#">Your Team</a></li>
					<li id="searchfplplayers"><a href="#">Player Search</a></li>
					<li id="draftSelection"><a href="#">Draft Selection</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><sec:authorize access="hasRole('ROLE_USER')">
							<!-- For login user -->
							<c:url value="/j_spring_security_logout" var="logoutUrl" />
							<form action="${logoutUrl}" method="post" id="logoutForm">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
							<script>
								function formSubmit() {
									document.getElementById("logoutForm")
											.submit();
								}
							</script>
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<p class="text-danger">
									${pageContext.request.userPrincipal.name} | <a
										href="javascript:formSubmit()"> Logout</a>
								</p>
							</c:if>
						</sec:authorize></li>
				</ul>
			</div>
		</div>
	</nav>


	<div id="draftPlayerTableHolder" class="container-fluid text-center">
		<div class="row content">
			<!-- <div class="col-sm-2 sidenav">
				<h4>
					<a href="#">Premier League Table</a>
				</h4>
				<p>Arsenal - 24pts</p>
				<p>Man City - 20pts</p>
				<p>Liverpool - 16pts</p>
				<h4>
					<a href="#">Top 10 Players</a>
				</h4>
				<p>Aguero (S) - 24pts</p>
				<p>Vardy (S) - 20pts</p>
				<p>Sanchez (M) - 16pts</p>
			</div> -->
			<div class="col-sm-6 text-left">
				<h1>Player selection table</h1>
				<p>datatable to go here  </p>
				<hr>
				<h3>List of player already selected</h3>
				<p>datable to go here</p>
			</div>
			<div class="col-sm-4 sidenav">
				<div class="well">
					<p>Players Turn Indicator</p>
				</div>
				
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="container-fluid text-center">

		<p>| Eddie Kilbane |</p>

	</footer>


</body>
</html>