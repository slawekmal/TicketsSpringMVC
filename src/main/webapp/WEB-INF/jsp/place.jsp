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
            <td>
                <label>
                    <spring:message text="Town"/>
                </label>
            </td>
            <td>
                <select name="townId">
                    <c:forEach items="${listTowns}" var="town">
                        <option value="${town.id}">${town.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
		<td>
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="address" />
		</td> 
	</tr>
        <tr>
		<td>
			<form:label path="capacity">
				<spring:message text="Capacity"/>
			</form:label>
		</td>
		<td>
			<form:input path="capacity" />
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
                <th width="120">Town</th>
                <th width="120">Address</th>
                <th width="120">Capacity</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPlaces}" var="place">
		<tr>
			<td>${place.id}</td>
			<td>${place.name}</td>
                        <td>${place.town.name}</td>
                        <td>${place.address}</td>
                        <td>${place.capacity}</td>
			<td><a href="<c:url value='places/edit/${place.id}' />" >Edit</a></td>
			<td><a href="<c:url value='places/remove/${place.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
