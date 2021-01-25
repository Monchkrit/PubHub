<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Tag Entry page</title>

</head>
<body>

<!-- 	Just some stuff you need -->
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>PUBHUB <small>Book Details - ${book.isbn13 }</small></h1>
		<ul>
			Tags here
				<c:forEach var="tag" items="${tags }">
					<li>
					Tag Here
						"${tag.tag_name }"
					</li>
				</c:forEach>
			</ul>
</body>
</html>