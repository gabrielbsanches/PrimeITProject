<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><title>PrimeIT Clients EDIT</title></title>
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
   <h1>Edit client page</h1>  
<p>Here you can edit the existing client.</p>  
<form method="POST" commandname="client" action="${pageContext.request.contextPath}/primeit/client/edit/${client.client_id}.html">  
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
<table>  
<tbody>  
	 <tr>  
        <th>Client Code:</th>  
        <td><input type="text" name="client_code" value="${client.client_code}"></></td>  
    </tr>
     <tr>  
        <th>Company Name:</th>  
        <td><input type="text" name="client_company_name" value="${client.client_company_name}"></></td>  
    </tr> 
    <tr>  
        <th>Client Name:</th>  
        <td><input type="text" name="client_name" value="${client.client_name}"></></td>  
    </tr>  
    <tr>  
         <th style="vertical-align:top">Client Comment:</th>  
        <td><textarea align="left" name="client_comment" id="client_comment" rows="10" cols="70" wrap="physical">${currentTime} - ${username}:

-----
${client.client_comment}
        </textarea></></td> 
   </tr>
   <tr>
        <th>Client email:</th>  
        <td><input type="text" name="email" value="${client.email}"></></td> 
   </tr>
   <tr>
        <th>Client phone:</th>  
        <td><input type="text" name="phone" value="${client.phone}"></></td> 
   </tr>
   <tr>
       <th>Contact Date:</th>  
        <td><input type="date" name="last_date" value="${client.last_date}"></></td> 
   </tr>
</tbody>  
</table> 
	<div>
		<input type="submit" value="Save">
 	</div>
</form>  
 <br><br>
<p><a href="${pageContext.request.contextPath}/welcome">Home page</a></p>
   </div>
   <div id="footer">
   	<jsp:include page="../common/footer.jsp"/>
   </div>
</div>
</body>
</html>