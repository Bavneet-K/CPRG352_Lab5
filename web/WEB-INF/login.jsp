<%-- 
    Document   : login
    Created on : 10 Apr, 2022, 5:35:16 PM
    Author     : Bavneet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="get">
            Username: <input type="text" name="username" value="">
            Password: <input type="password" name="password" value="">
            <input type="submit" value="Log in" name="operation">
        </form>
    </body>
</html>
