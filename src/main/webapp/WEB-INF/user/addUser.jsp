<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrimeIT ADD USERS</title>
	<!-- Menu and style -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/menuStyle.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/tableStyle.css'/>" />
	
</head>
<body>
<div id="container">
   <div id="header">
   	<jsp:include page="../common/menu.jsp"/>
   </div>
   <div id="body">
   <h1>Add user page</h1>  
<p>Here you can add a new users to the system.</p>  
<h1>User Registration</h1>
<form method="POST" action="${pageContext.request.contextPath}/primeit/user/add/process" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<table>  
<tbody>  
	 <tr>
		<th>Login:</th>
		<td><input type='text' name='loginname'></td>
	</tr>
	<tr>
		<th>Password:</th>
		<td><input type='password' name='password' /></td>
	</tr>
	<tr>
		<th>Confirm Password:</th>
		<td><input type='password' name='password2' /></td>
	</tr>
	<tr>
		<th>Manager Name:</th>
		<td><input type='text' name='manager_name'></td>
	</tr>
	<tr>
		<th>Email:</th>
		<td><input type='text' name='email'></td>
	</tr>
	<tr>
		<th>Phone:</th>
		<td><input type='text' name='phone'></td>
	</tr>
	</tbody>
	</table>
			<input type="submit" class="button" value="Add">
	</form>
   </div>
   <div id="footer">
   		<jsp:include page="../common/footer.jsp"/>
   </div>
</div>
</body>
</html>