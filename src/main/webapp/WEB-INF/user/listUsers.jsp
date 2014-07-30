<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrimeIT LIST OF USERS</title>
	<!-- Menu and style -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/menuStyle.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/tableStyle.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/list.css'/>" />
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>  
	<script src="http://listjs.com/no-cdn/list.js"></script>
	<script src="http://listjs.com/no-cdn/list.pagination.js"></script>
	
</head>
<body>
<div id="container">
   <div id="header">
   	<jsp:include page="../common/menu.jsp"/>
   </div>
   <div id="body">
   	<h1>List of users</h1>  
<p>Here you can see the list of the users, edit them, remove or update.</p>  

	<c:if test="${not empty message}">
		<div class="msg">${message}</div>
	</c:if>

<div id="my_user_list">
	<table width="90%" align="left" cellpadding="0" cellspacing="0" border="1px">
		<thead>
	        <input class="search" placeholder="Search" />
	    </thead>
    	<tr>  
			<th width="15%">Username</th><td class="sort" data-sort="loginname"></td>
			<th width="20%">Manager Name</th><td class="sort" data-sort="manager_name"></td>
			<th width="15%">Authority</th><td class="sort" data-sort="authority"></td>
			<th width="30%">Contacts</th><td class="sort" data-sort="email"></td>
			<th width="5%">Actions</th>  
		</tr>
		<tbody class="list"> 
	        <c:forEach var="u" items="${users}">
		        <tr>
		            <td colspan="2" class="loginname"> ${u.loginname}</td> 
		            <td colspan="2" class="manager_name"> ${u.manager_name}</td> 
		            <td colspan="2" class="authority"> ${u.authority}</td>
		            <td colspan="2" class="email"> ${u.phone} <br> ${u.email}</td>
		            <td> <a href="${pageContext.request.contextPath}/primeit/user/edit/${u.userid}">Edit</a><br>
		    		<a href="${pageContext.request.contextPath}/primeit/user/delete/${u.userid}">Delete</a> &nbsp;&nbsp; </td>
		    	</tr>
	        </c:forEach>
	        <ul class="pagination"></ul>
	    </tbody>
    </table>
  </div>
   <script type="text/javascript">
	 var options = {
	     valueNames: ['loginname', 'manager_name', 'authority', 'email' ],
	     page: 10,
	     plugins: [ ListPagination({})]
	 };
	 var userList = new List('my_user_list', options);
	</script>
   </div>
   <div id="footer">
   		<jsp:include page="../common/footer.jsp"/>
   </div>
</div>
</body>
</html>