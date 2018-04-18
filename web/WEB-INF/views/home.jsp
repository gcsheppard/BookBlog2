<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/BookBlog/styles/styles.css">
    </head>
    <body>
        <p>Books:</p>
        <ul>
            <c:forEach var="book" items="${books}">
                <li>
                    
                    <div class ="f">Title: <c:out value = "${book.title}"/></div>
                    <div class ="f">Author: <c:out value = "${book.author}"/></div>
                    <div class ="f">ISBN: <c:out value = "${book.ISBN}"/></div>
                    <div class="a">Review: <c:out value = "${book.review}"/></div>
                    <br>
                </li>
            </c:forEach>
        </ul>
            <br>
        <c:choose>
            <c:when test = "${user == null}">
                <br><div class="d"><a href="/BookBlog/login">Login</a></div><br>
            </c:when>
            <c:otherwise>
                <br><div class="d"><a href="/BookBlog/logout">Logout</a></div><br>
                <br><div class="d"><a href="/BookBlog/login">Add Book</a></div><br>
            </c:otherwise>
        </c:choose>
    </body>
</html>
