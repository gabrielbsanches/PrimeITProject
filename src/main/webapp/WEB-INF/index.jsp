<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/menuStyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/tableStyle.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/list.css'/>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
td{
vertical-align:top;
}
</style>
<title>PrimeIT Clients</title>
 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>  
	<script src="http://listjs.com/no-cdn/list.js"></script>
	<script src="http://listjs.com/no-cdn/list.pagination.js"></script>
	
</head>
<body>
<div id="container">
	<div id="header">
		<jsp:include page="common/menu.jsp"/>
	</div>
   
   <div id="body">
   <caption><h1>List of All Meetings</h1><caption> 
    <h3>${WelcomeMessage}</h3>	
	<h3>Username : ${username}</h3>	
	
	<c:if test="${not empty userSuccessMessage}">
			<div class="successblock">
				User was added succesfully!
			</div>
		</c:if>
	<div class="successblock">
    	<p>${message}<br></p>
    </div>
	    <!-- LAST WEEK TABLE -->
		    <div id="last_week_meeting">
			    <table cellpadding="0" cellspacing="0">
			   	<thead><h3 align="left">Last Week:</h3></thead>
				    <tr>
				    	<input class="search" placeholder="Search" />
				    </tr>
			    	<tr>  
						<th width="10%">Manager Name</th>
						<th width="20%">Company Name</th>
						<th width="15%">Client Name</th>
						<th width="15%">Meeting Date</th>
					</tr> 
					<c:choose>
					<c:when test="${not empty lastWeekMeetings}">
					<tbody class="list" >
			        <c:forEach var="m" items="${lastWeekMeetings}">
				        <tr>
				           	<td class="manager_name"> ${m.manager_name}</td> 
				            <td class="company_name"> ${m.company_name}</td>
				            <td class="client_name"> ${m.client_name}</td>
				            <td class="meeting_date"> ${m.meeting_date}</td>
				    	</tr>
			        </c:forEach>
			        </tbody>
			        </c:when>
				    <c:otherwise>
				    <tr>
				    	<td colspan="4">
					     There is no meeting this week
					    </td>
				     </tr>
				    </c:otherwise>
				   </c:choose>
			    </table>
			   </div>
			   <script type="text/javascript">
				 var options = {
				     valueNames: ['manager_name', 'company_name', 'client_name', 'meeting_date' ],
				 };
				 var lastMeetingList = new List('last_week_meeting', options);
				</script>
		    
		    <!-- CURRENT WEEK TABLE -->
		    <div id="current_week_meeting">
			     <table cellpadding="0" cellspacing="0">
			     <thead><h3 align="left">Current Week:</h3></thead>
			    	 <tr>
				    	<input class="search" placeholder="Search" />
				    </tr>
			    	<tr>  
						<th width="10%">Manager Name</th>
						<th width="20%">Company Name</th>
						<th width="15%">Client Name</th>
						<th width="15%">Meeting Date</th>
					</tr> 
					<c:choose>
					<c:when test="${not empty currentWeekMeetings}">
					<tbody class="list" >
				        <c:forEach var="m" items="${currentWeekMeetings}">
					         <tr>
					           	<td class="manager_name"> ${m.manager_name}</td> 
					            <td class="company_name"> ${m.company_name}</td>
					            <td class="client_name"> ${m.client_name}</td>
					            <td class="meeting_date"> ${m.meeting_date}</td>
					    	</tr>
				        </c:forEach>
			        </tbody>
			        </c:when>
				    <c:otherwise>
				    <tr>
				    	<td colspan="4">
					     There is no meeting this week
					    </td>
				     </tr>
				    </c:otherwise>
				   </c:choose>
			    </table>
		    </div>
		     <script type="text/javascript">
				 var options = {
				     valueNames: ['manager_name', 'company_name', 'client_name', 'meeting_date' ],
				 };
				 var currentMeetingList = new List('current_week_meeting', options);
				</script>
		    
		    <!-- NEXT WEEK TABLE -->
		     <div id="next_week_meeting">
			     <table id="mytable" cellpadding="0" cellspacing="0">
				     <thead><h3 align="left">Next Week:</h3></thead>
				    	 <tr>
					    	<input class="search" placeholder="Search" />
					    </tr>
				    	<tr>  
							<th width="10%">Manager Name</th>
							<th width="20%">Company Name</th>
							<th width="15%">Client Name</th>
							<th width="15%">Meeting Date</th>
						</tr> 
						<c:choose>
						<c:when test="${not empty nextWeekMeetings}">
						<tbody class="list" >
					        <c:forEach var="m" items="${nextWeekMeetings}">
						        <tr>
						           <td class="manager_name"> ${m.manager_name}</td> 
						            <td class="company_name"> ${m.company_name}</td>
						            <td class="client_name"> ${m.client_name}</td>
						            <td class="meeting_date"> ${m.meeting_date}</td>
						    	</tr>
					        </c:forEach>
					    </tbody>
				     </c:when>
				    <c:otherwise>
				    <tr>
				    	<td colspan="4">
					     There is no meeting this week
					    </td>
				     </tr>
				    </c:otherwise>
				   </c:choose>
			    </table>
		    </div>
		    	<script type="text/javascript">
					 var options = {
					     valueNames: ['manager_name', 'company_name', 'client_name', 'meeting_date' ],
					 };
					 var nextMeetingList = new List('next_week_meeting', options);
				</script>
   </div>
   <div id="footer">
  	 <jsp:include page="common/footer.jsp"/>
   </div>
</div>
				
</body>
</html>