<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<html>
    <head>
        <title>Klienci</title>
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
            Rejestracja
        </h1>

        <c:url var="addAction" value="/clients/add" ></c:url>

        <form:form action="${addAction}" commandName="client">
            <table>
                <c:if test="${!empty client.email}">
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
                        <form:label path="firstName">
                            <spring:message text="FirstName"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="firstName" />
                    </td> 
                </tr>
                <tr>
                    <td>
                        <form:label path="lastName">
                            <spring:message text="LastName"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="lastName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="email">
                            <spring:message text="Email"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="email" />
                    </td>
                </tr>
            </tr>
            <tr>
                <td>
                    <form:label path="password">
                        <spring:message text="Password"/>
                    </form:label>
                </td>
                <td>
                    <form:password path="password" />
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty client.email}">
                        <input type="submit"
                               value="<spring:message text="Edit client"/>" />
                    </c:if>
                    <c:if test="${empty client.email}">
                        <input type="submit"
                               value="<spring:message text="Zarejestruj"/>" />
                    </c:if>
                </td>
            </tr>
        </table>	
    </form:form>
    <br>
    <h3>Lista zarejestrowanych u?ytkowników</h3>
    <c:if test="${!empty listClients}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">First Name</th>
                <th width="120">Last Name</th>
                <th width="120">Email</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listClients}" var="client">
                <tr>
                    <td>${client.id}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.email}</td>
                    <td><a href="<c:url value='clients/edit/${client.id}' />" >Edit</a></td>
                    <td><a href="<c:url value='clients/remove/${client.id}' />" >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
