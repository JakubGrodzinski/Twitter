<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 8/23/18
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--@elvariable id="tweet" type="pl.coderslab.model.Tweet"--%>
    <form:form modelAttribute="tweet" action="/main" method="post">
        <form:textarea path="text"/><br/>
        <form:errors path="text"/><br/>
        <input type="submit" value="Post"/>
    </form:form>

    <c:forEach items="${allTweets}" var="tweetshow">
        ${tweetshow.user.email} <br/>
        ${tweetshow.created} <br/>
        ${tweetshow.text}<br/>
    </c:forEach>

</body>
</html>
