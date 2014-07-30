<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrimeIT LIST OF Meetings</title>
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
   <h1>List of Meetings</h1>  
	<p>Here you can see the list of the meetings, edit them, remove or update.</p> 

	<c:if test="${not empty message}">
		<div class="msg">${message}</div>
	</c:if>
	
	<div id="my_meeting_list">
	<table width="90%" align="left" cellpadding="0" cellspacing="0" border="1px">
		<thead>
	        <input class="search" placeholder="Search" />
	    </thead>
	    	<tr align="center">  
				<th>Manager Name</th><td class="sort" data-sort="manager_name"></td>
				<th>Company Name</th><td class="sort" data-sort="company_name"></td>
				<th>Client Name</th><td class="sort" data-sort="client_name"></td>
				<th>Meeting Date</th><td class="sort" data-sort="meeting_date"></td>
				<th>Actions</th>
			</tr> 
		<tbody class="list" >
	        <c:forEach var="m" items="${meetings}">
		        <tr>
		            <td colspan="2" class="manager_name"> ${m.manager_name}</td> 
		            <td colspan="2" class="company_name"> ${m.company_name}</td>
		            <td colspan="2" class="client_name"> ${m.client_name}</td>
		            <td colspan="2" class="meeting_date"> ${m.meeting_date}</td>
		            <td> <a href="${pageContext.request.contextPath}/primeit/meeting/edit/${m.meeting_id}">Edit</a><br>
		    		<a href="${pageContext.request.contextPath}/primeit/meeting/delete/${m.meeting_id}">Delete</a> &nbsp;&nbsp; </td>
		    	</tr>
	        </c:forEach>
	       	<ul class="pagination"></ul>
        </tbody>
    </table>
	</div>
    <script type="text/javascript">
	 var options = {
	     valueNames: ['manager_name', 'company_name', 'client_name', 'meeting_date' ],
	     page: 8,
	     plugins: [ ListPagination({})]
	 };
	 var contactList = new List('my_meeting_list', options);
	</script>
	
   </div>
   <div id="footer">
   		<jsp:include page="../common/footer.jsp"/>
   </div>
</div>


</body>
</html>