<%-- 
    Document   : welcome
    Created on : 2016-03-05, 16:32:13
    Author     : SKM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
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
    <center>Welcome ${loggedInUser}</center>
</body>
</html>