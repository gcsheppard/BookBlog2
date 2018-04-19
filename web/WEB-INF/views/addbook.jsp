<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/BookBlog/styles/styles.css">
    </head>
    <body>
        <h2>Enter your review:</h2>
        <form action="addbook" method="post">
            <div class="b"><input type="text" name="title" value="${book.title}" placeholder="Book Title"}></div><br>
            <div class="b"><input type="text" name="author" value="${book.author}" placeholder="Book Author"></div><br>
            <div class="b"><input type="text" name="isbn" value="${book.ISBN}" placeholder="Book ISBN Number"></div><br>
            <div <div class="f"><textarea name="review" rows="4" cols="50" placeholder="Your Review">${book.review}</textarea></div><br>
            <div class="c"><input type="submit" value="Submit" /><br>
        </form>  
            <br><div class="e">${errors}</div>
    </body>
</html>