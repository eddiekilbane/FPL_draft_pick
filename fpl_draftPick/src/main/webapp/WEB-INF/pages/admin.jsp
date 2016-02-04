<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>FPL - Draft Admin</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/js/draftGenerator.js"
	var="draftGeneratorJs" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${flipClockCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${draftGeneratorJs}"></script>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.js"></script>

<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
$(document).ready(function(){
	DraftGenerator.initDraftGenerator();
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
					<li id="home"><a href="#">Home</a></li>
					<li id="users_team"><a href="#">Your Team</a></li>
					<li id="searchfplplayers"><a href="#">Player Search</a></li>
					<li id="draftSelection"><a href="draftSelection">Draft Selection</a></li>
					<li class="active" id="admin"><a href="admin">Draft Admin</a></li>

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


<div id="draftPlayerPickGeneratorHolder" class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-4 text-center">
				<div id="playerDraftOrderTable-holder">
					<table id="playerOrderDatatable" class="stripe row-border hover compact"></table>
				</div>
			</div>
			<div class="col-sm-4 text-center">

				<button id="startDraftGeneratorBtn" type="button" class="btn-lg btn-success">Generate Draft Pick</button>
			</div>
		
			
		</div>
	</div>
	<!-- Footer -->
	<footer class="container-fluid text-center">

		<p>| Eddie Kilbane |</p>

	</footer>


</body>
</html>