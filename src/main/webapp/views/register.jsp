<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 8/23/18
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Registration page</h2>
    <%--@elvariable id="user" type="pl.coderslab.model.User"--%>
    <form:form modelAttribute="user" method="post" action="/registration">
        Email<br/>
        <form:input path="email"/><br/>
        <form:errors path="email"/><br/>
        Password<br/>
        <form:password path="password"/><br/>
        <form:errors path="password"/><br/>
        <input type="submit" value="Sign up"/>
    </form:form>

</body>
</html>
