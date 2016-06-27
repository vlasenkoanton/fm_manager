<%--
  User: A. Vlasenko 27.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Work</title>
</head>
<body>
<form:form action="work" method="post" modelAttribute="work">
    <dl>
        <dt>Company name</dt>
        <dd><form:input path="name"/></dd>
        <dt>Identification code</dt>
        <dd><form:input path="identCode"/></dd>
        <dt>Position</dt>
        <dd><form:input path="position"/></dd>
    </dl>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
