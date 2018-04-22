<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/BookBlog2/styles/styles.css">
    </head>
    <body>
        <h1><div class ="f">Review of: <c:out value = "${book.title}"/></h1>
        
        <ul>
                <li>
                    <div class ="f">Title: <c:out value = "${book.title}"/><br>
                    Author: <c:out value = "${book.author}"/><br>
                    Genre: <c:out value = "${book.genre}"/><br>
                    ISBN: <c:out value = "${book.isbn}"/><br><br>
                    Rating: <c:forEach begin="1" end="${book.rating}">
                        <img src ="/BookBlog2/images/bluestar.jpg" width = "15">
                          </c:forEach><br>
                    Review by: <c:out value = "${book.reviewer}"/><br>
                    Review: </div>
                    <div class="g"><c:out value = "${book.review}"/></div>
                    </div>
                </li>
        </ul>
                    <br><div class="d"><a href="/BookBlog2/home">Back to list</a></div><br>
    </body>
</html>
