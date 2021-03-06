<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>FPL - Player Selection</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/css/flipclock.css" var="flipClockCss" />



<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<spring:url value="/resources/core/js/draftSelection.js"
	var="draftSelectionJs" />
<spring:url value="/resources/core/js/stompClient.js"
	var="stompClientJs" />
	<spring:url value="/resources/core/js/stomp.js"
	var="stompJs" />
	<spring:url value="/resources/core/js/sockjs-0.3.4.js"
	var="sockJs" />
<spring:url value="/resources/core/js/flipclock.min.js"
	var="flipClockJs" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${flipClockCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${draftSelectionJs}"></script>
<script src="${stompClientJs}"></script>
<script src="${stompJs}"></script>
<script src="${sockJs}"></script>
<script src="${flipClockJs}"></script>

<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.js"></script>

<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
$(document).ready(function(){
	var temp = "${pageContext.request.userPrincipal.name}";
	//StompClient.initStompClient();
	socket = new SockJS('/fpl_draftPick/messenger');
			stompClient = Stomp.over(socket);
			console.log("Init stomp client");
			console.log(socket);
			console.log(stompClient);
			stompClient.connect({}, function(frame) {
				setConnected(true);
				console.log('Connected: ' + frame);
				stompClient.subscribe('/topic/greetings', function(greeting) {
					showGreeting(JSON.parse(greeting.body).content);
				});
			});
	
	DraftSelection.initDraftSelection(temp);
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
					<li class="active" id="draftSelection"><a
						href="draftSelection">Draft Selection</a></li>
					<li><a href="admin">Draft Admin</a></li>

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


	<div id="draftPlayerIdentifierHolder"
		class="container-fluid text-center">

		<div class="container row content">
			<div class="col-sm-3">
				<h1 id="usernameSelection"></h1>
			</div>
			<div class="col-sm-3">
				<div id="currentUserSelection"></div>
			</div>
			<div class="col-sm-3">

				<div class="flipClock"></div>
			</div>
			<div class="col-sm-3">

				<button id="startDraftPickBtn" type="button" class="btn btn-success">Start
					Draft Round: #1</button>
			</div>
		</div>
		<div class="container row content"></div>




	</div>

	<div id="draftPlayerTableHolder" class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-8 text-left">
				<div id="playerTable-holder">
					<table id="playerDatatable" class="stripe row-border hover compact"></table>
				</div>
			</div>
			<div class="col-sm-4 sidenav">
				<div class="well">
					<p>Players Messenger</p>

					<div id="conversationDiv">
						<label>Message:</label><input type="text" id="name" />
						<button id="sendName" onclick="StompClient.sendName();">Send</button>
						<p id="response"></p>
					</div>
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