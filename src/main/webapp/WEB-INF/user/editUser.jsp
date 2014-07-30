<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><title>PrimeIT Users EDIT</title></title>
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
   <h1>Edit user page</h1>  
<p>Here you can edit the existing user.</p>  
<p>${message}</p>  
<form method="POST" commandname="user" action="${pageContext.request.contextPath}/primeit/user/edit/${user.userid}.html">  
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
<table>  
<tbody>  
	 <tr>  
        <th>Username/Login Name:</th>  
        <td><input type="text" name="loginname" value="${user.loginname}"></></td>  
    </tr>
     <tr>  
        <th>Manager Name:</th>  
        <td><input type="text" name="manager_name" value="${user.manager_name}"></></td>  
    </tr> 
    <tr>  
        <th>Password:</th>  
        <td><input type="password" name="password" value="${user.password}"></></td>  
    </tr>  
     <tr>  
        <th>Confirm Password:</th>  
        <td><input type="password" name="password2" value="${user.password}"></></td>  
    </tr>
   <tr>
        <th>User email:</th>  
        <td><input type="text" name="email" value="${user.email}"></></td> 
    </tr><tr>
        <th>User phone:</th>  
        <td><input type="text" name="phone" value="${user.phone}"></></td> 
   </tr>
</tbody>  
</table>
	<div>
		<input type="submit" value="Save"> 
	</div> 
</form>  
 <br>
   </div>
   <div id="footer">
   		<jsp:include page="../common/footer.jsp"/>
   </div>
</div>


</body>
</html>