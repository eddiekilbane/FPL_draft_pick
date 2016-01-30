<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<html>
<head>
<title>FPL - Login Page</title>
<!-- <style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style> -->

<link href="/resources/core/css/hello.css" rel="stylesheet">
<link href="/resources/core/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/core/js/jquery.1.10.2.min.js"></script>

<spring:url value="/resources/core/css/hello.css" var="mainCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
</head>
<body onload='document.loginForm.username.focus();'>

	<h1>FPL Draft Pick - Logon</h1>
	
	
	<div class="row">

  <div class="col-sm-4">General Information</div>
  <div class="col-sm-4">
  <div id="login-box">

		<h3>Login with Username and Password</h3>

		<c:if test="${not empty error}">
			<div class=".text-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class=".text-warning">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' class="form-control"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' class="form-control"/></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
  
  </div>
</div>

	

</body>
</html>