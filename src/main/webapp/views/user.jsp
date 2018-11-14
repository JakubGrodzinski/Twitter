<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 8/29/18
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:forEach items="${tweetsByUser}" var="tweet">
        ${tweet.created} <br/>
        ${tweet.text} <br/> <br/>
    </c:forEach>

</body>
</html>
