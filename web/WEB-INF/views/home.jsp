<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/BookBlog2/styles/styles.css">
    </head>
    <body>
        <p>Book Reviews:</p>
        <ul>
            <c:forEach var="book" items="${books}">
                <li>
                    <div class ="f">Title: <c:out value = "${book.title}"/><br>
                    Genre: <c:out value = "${book.genre}"/><br>
                    Rating: <c:forEach begin="1" end="${book.rating}">
                        <img src ="/BookBlog2/images/bluestar.jpg" width = "15">
                          </c:forEach><br>
                    <a href="details?id=${book.id}">Details</a></div>
                </li>
                <hr>
            </c:forEach>
        </ul>
            <br>
        <c:choose>
            <c:when test = "${user == null}">
                <br><div class="d"><a href="/BookBlog2/login">Login</a></div><br>
            </c:when>
            <c:otherwise>
                <br><div class="d"><a href="/BookBlog2/logout">Logout</a></div><br>
                <br><div class="d"><a href="/BookBlog2/addbook">Add Book</a></div><br>
                <br><div class="d"><a href="/BookBlog2/show?show=mine">Show my reviews only</a></div><br>
            </c:otherwise>
        </c:choose>
    </body>
</html>