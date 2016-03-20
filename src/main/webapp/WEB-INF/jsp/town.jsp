<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Miasta</title>
        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
            .tg .tg-4eph{background-color:#f9f9f9}
        </style>
    </head>
    <body>
        <div id="menu">
            <a href="events.html"> Wydarzenia </a>
            <a href="towns.html"> Miasta </a>
            <a href="places.html"> Miejsca </a>
            <a href="tickets.html"> Bilety </a>
            <a href="clients.html"> Klienci </a>
            <div align="right"> <a href="login.html"> Login </a> </div>
            <div align="right"> <a href="clients.html"> Register </a> </div>
        </div>
        <h1>
            Dodaj miasto
        </h1>

        <c:url var="addAction" value="/towns/add" ></c:url>

        <form:form action="${addAction}" commandName="town">
            <table>
                <c:if test="${!empty town.name}">
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
                        <c:if test="${!empty town.name}">
                            <input type="submit"
                                   value="<spring:message text="Edit town"/>" />
                        </c:if>
                        <c:if test="${empty town.name}">
                            <input type="submit"
                                   value="<spring:message text="Add town"/>" />
                        </c:if>
                    </td>
                </tr>
            </table>	
        </form:form>
        <br>
        <h3>Town List</h3>
        <c:if test="${!empty listTowns}">
            <table class="tg">
                <tr>
                    <th width="80">ID</th>
                    <th width="120">Name</th>
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listTowns}" var="town">
                    <tr>
                        <td>${town.id}</td>
                        <td>${town.name}</td>
                        <td><a href="<c:url value='towns/edit/${town.id}' />" >Edit</a></td>
                        <td><a href="<c:url value='towns/remove/${town.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
