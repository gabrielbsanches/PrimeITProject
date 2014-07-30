<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrimeIT Clients ADD or UPDATE</title>
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
	   <h1>Add client page</h1>  
		<p>Here you can add a new client.</p>  
		<form method="POST" action="${pageContext.request.contextPath}/primeit/client/add/process" > 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		<table>  
		<tbody>  
		 	<tr>  
		        <th>Client Code:</th>  
		        <td><input align="left" type="text" name="client_code">  
		    </tr> 
		    <tr>  
		        <th>Company Name:</th>  
		        <td><input type="text" name="client_company_name"></></td>  
		    </tr>
		    <tr>  
		        <th>Client Name:</th>  
		        <td><input type="text" name="client_name"></td>  
		    </tr>  
		    <tr>  
		        <th style="vertical-align:top">Client Comment:</th>  
		        <td><textarea name="client_comment" id="client_comment" rows="10" cols="70"></textarea></></td>  
		    </tr>
		    <tr>
		        <th>Client email:</th>  
		        <td><input type="text" name="email"></></td> 
		  	</tr>
		   	<tr>
		        <th>Client phone:</th>  
		        <td><input type="text" name="phone"></></td>
		    </tr> 
		</tbody>  
		</table> 
		<input type="submit" value="Add"></td> 
		</form>  
		<br><br> 
		<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p> 
	</div>
   <div id="footer">
   	<jsp:include page="../common/footer.jsp"/>
   </div>
</div>


</body>
</html>