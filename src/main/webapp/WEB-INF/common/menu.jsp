<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/menuStyle.css'/>" />
</head>
<body>
	<ul id="menu">
	    <li><a href="${pageContext.request.contextPath}/welcome">Home</a></li>
	    <li>
	        <a href="#">Clients</a>
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/primeit/client/add">Add Client</a></li>
	            <li><a href="${pageContext.request.contextPath}/primeit/client/list">List of Clients</a></li>
	        </ul>
	    </li>
	    <li><a href="#">User</a>
	    	<ul>
	            <li><a href="${pageContext.request.contextPath}/primeit/user/add">Add User</a></li>
	            <li><a href="${pageContext.request.contextPath}/primeit/user/list">List of Users</a></li>
	        </ul>
	    </li>
	    <li><a href="#">Meeting</a>
	    	<ul>
	            <li><a href="${pageContext.request.contextPath}/primeit/meeting/add">Add Meeting</a></li>
	            <li><a href="${pageContext.request.contextPath}/primeit/meeting/list">List of Meetings</a></li>
	        </ul>
	    </li>
	    <li><a href="${pageContext.request.contextPath}/primeit/extjs/indexExtJS">ExtJS Page</a></li>
	    <li><a href="#">Contact</a></li>
	    <li><a href="javascript:formSubmit()"> Logout</a>
		    <c:url value="/j_spring_security_logout" var="logoutUrl" />
		    
		    <!-- csrt for log out-->
			<form action="${logoutUrl}" method="post" id="logoutForm">
			  <input type="hidden" 
				name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form>
			<script type="text/javascript">
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
			</script>
		</li>
		
		<li style="background-image:url(${pageContext.request.contextPath}/img/logo_pt.png);"><div ></div></li>
	</ul>
</body>
</html>