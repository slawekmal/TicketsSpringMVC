<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Wydarzenia</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Dodaj wydarzenie
</h1>

<c:url var="addAction" value="/event/add" ></c:url>

<form:form action="${addAction}" commandName="event">
<table>
	<c:if test="${!empty event.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="place">
				<spring:message text="Place"/>
			</form:label>
		</td>
		<td>
			<form:input path="place" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty event.name}">
				<input type="submit"
					value="<spring:message text="Edit event"/>" />
			</c:if>
			<c:if test="${empty event.name}">
				<input type="submit"
					value="<spring:message text="Add event"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Events List</h3>
<c:if test="${!empty listEvents}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Name</th>
		<th width="120">Place</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEvents}" var="event">
		<tr>
			<td>${event.id}</td>
			<td>${event.name}</td>
			<td>${event.place}</td>
			<td><a href="<c:url value='/edit/${event.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${event.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
