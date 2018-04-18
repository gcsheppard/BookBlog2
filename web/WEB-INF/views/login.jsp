<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/BookBlog/styles/styles.css">
    </head>
    <body>
        <h1><c:out value = "${flash}"/></h1>
        <h2>Login:</h2>
        <form action="login" method="post">
            <div class="b">Username: <input type="text" name="username"}></div><br>
            <div class="b">Password: <input type="password" name="password"></div><br>
            <div class="c"><input type="submit" value="Submit" /><br>
        </form>  
    </body>
</html>
