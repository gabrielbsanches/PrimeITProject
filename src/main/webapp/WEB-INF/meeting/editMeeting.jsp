<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><title>PrimeIT Meetings EDIT</title></title>
	<!-- Menu and style -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/menuStyle.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/tableStyle.css'/>" />
</head>

<body>

<div id="container">
   <div id="header">
   		<jsp:include page="../common/menu.jsp"/>
   </div>
   <div id="body">
   <h1>Edit meeting page</h1>  
<p>Here you can edit the existing meeting.</p>  
<p>${meetingMessage}</p>  
<form method="POST" commandname="meeting" action="${pageContext.request.contextPath}/primeit/meeting/edit/${meeting.meeting_id}.html">  
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
<table>  
<tbody>  
	 <tr>  
        <th>Manager Name:</th>  
        <td align="left">
       		<form:select path="meeting.manager_name">
	       		<form:option value="${meeting.manager_name}"/>
  				<form:options items="${managerNames}" />
	       	</form:select>
        </td>  
    </tr>
     <tr>  
        <th>Company Name:</th>  
        <td align="left">
        	<form:select path="meeting.company_name">
	       		<form:option value="${meeting.company_name}"/>
  				<form:options items="${clientCompanyNames}" />
	       	</form:select>
        </></td>  
    </tr> 
    <tr>  
        <th>Client Name:</th>  
        <td align="left">
        	<form:select path="meeting.client_name">
	       		<form:option value="${meeting.client_name}"/>
  				<form:options items="${clientNames}" />
	       	</form:select>
        </td>  
    </tr>  
     <tr>  
        <th>Meeting Date:</th>  
        <td align="left"><input type="date" name="meeting_date" value="${meeting.meeting_date}"></></td>  
    </tr>
</tbody>  
</table>  
<input type="submit" value="Save">
</form>  
   </div>
   <div id="footer">
   	<jsp:include page="../common/footer.jsp"/>
   </div>
</div>


</body>
</html>