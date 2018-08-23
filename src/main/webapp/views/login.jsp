<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 8/23/18
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="user" type="pl.coderslab.model.User"--%>
<form:form modelAttribute="user" method="post" action="registration">
    <form:input path="email"/><br/>
    <form:errors path="email"/><br/>
    <form:password path="password"/><br/>
    <form:errors path="password"/><br/>
    <input type="submit" value="Log in"/>
</form:form>

</body>
</html>
