<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Miejsca</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Dodaj miejsce
</h1>

<c:url var="addAction" value="/places/add" ></c:url>

<form:form action="${addAction}" commandName="place">
<table>
	<c:if test="${!empty place.name}">
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
		<td colspan="2">
			<c:if test="${!empty place.name}">
				<input type="submit"
					value="<spring:message text="Edit place"/>" />
			</c:if>
			<c:if test="${empty place.name}">
				<input type="submit"
					value="<spring:message text="Add place"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Place List</h3>
<c:if test="${!empty listPlaces}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPlaces}" var="place">
		<tr>
			<td>${place.id}</td>
			<td>${place.name}</td>
			<td><a href="<c:url value='places/edit/${place.id}' />" >Edit</a></td>
			<td><a href="<c:url value='places/remove/${place.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
