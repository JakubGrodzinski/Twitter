<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 8/29/18
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${tweet.user.email} <br/>
    ${tweet.created} <br/>
    ${tweet.text}<br/>

    <%--@elvariable id="comment" type="pl.coderslab.model.Comment"--%>
    <form:form modelAttribute="comment" method="post" action="/tweet/${tweet.id}">
        <form:textarea path="text"/>
        <input type="submit" value="Share your thoughts"/>
    </form:form>

    <c:forEach items="${comments}" var="commenty">
        ${commenty.user.email} <br/>
        ${commenty.created}<br/>
        ${commenty.text} <br/>
    </c:forEach>


</body>
</html>
