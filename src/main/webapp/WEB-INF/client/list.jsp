<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrimeIT Clients LIST OF CLIENTS</title>
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
   <h1>List of clients</h1>  
<p>Here you can see the list of the clients, edit them, remove or update.</p>  
	
	<c:if test="${not empty message}">
		<div class="msg">${message}</div>
	</c:if>

<div id="my_client_list">
	<table width="90%" align="left" cellpadding="0" cellspacing="0" border="1px">
		<thead>
	        <input class="search" placeholder="Search" />
	    </thead>
    	<tr>  
			<th width="8%">Client Code</th><td class="sort" data-sort="client_code"></td>
			<th width="15%">Company Name</th><td class="sort" data-sort="client_company_name"></td>
			<th width="10%">Client Name</th><td class="sort" data-sort="client_name"></td>
			<th width="12%">Contacts</th><td class="sort" data-sort="email"></td>
			<th width="40%">Comments</th><td class="sort" data-sort="client_comment"></td>
			<th width="5%">Last Contact</th><td class="sort" data-sort="last_date"></td>
			<th width="5%">Actions</th>  
		</tr> 
		<tbody class="list" >
	        <c:forEach var="c" items="${clients}">
		        <tr>
		            <td colspan="2" class="client_code"> ${c.client_code}</td> 
		            <td colspan="2" class="client_company_name"> ${c.client_company_name}</td>
		            <td colspan="2" class="client_name"> ${c.client_name}</td>
		            <td colspan="2" class="email"> ${c.phone} <br> ${c.email}</td>
		            <td colspan="2" class="client_comment"> ${c.client_comment}</td>
		            <td colspan="2" class="last_date"> ${c.last_date}</td>
		            <td> <a href="${pageContext.request.contextPath}/primeit/client/edit/${c.client_id}">Edit</a><br>
		    		<a href="${pageContext.request.contextPath}/primeit/client/delete/${c.client_id}">Delete</a> &nbsp;&nbsp; </td>
		    	</tr>
	        </c:forEach>
	        <ul class="pagination"></ul>
        </tbody>
    </table>
    </div>
    
    <script type="text/javascript">
	 var options = {
	     valueNames: [ 'client_code','client_company_name', 'client_name', 'email', 'client_comment', 'last_date' ],
	     page: 10,
	     plugins: [ ListPagination({})]
	 };
	 var clientList = new List('my_client_list', options);
	</script>
   </div>
   <div id="footer">
   		<jsp:include page="../common/footer.jsp"/>
   </div>
</div>
</body>
</html>