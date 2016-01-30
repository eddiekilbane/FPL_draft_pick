<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>FPL - Draft Pick</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>

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
					<li ><a href="draftSelection">Draft Selection</a></li>

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
			<div class="col-sm-2 sidenav">
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
			</div>
			<div id="main_body" class="col-sm-8 text-left">
				<h1>Welcome</h1>
				<p>Draft League To go here!!!!!</p>
				<hr>
				<h3>Test</h3>
				<p>Lorem ipsum...</p>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
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