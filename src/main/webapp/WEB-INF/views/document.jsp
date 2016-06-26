<%--
  User: A. Vlasenko 19.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Document</title>
</head>
<body>
<form:form method="POST" modelAttribute="document">
    <dl>
        <form:hidden path="id"/>
        <dt>Type</dt>
        <dd><form:input path="type"/></dd>
        <dt>Name</dt>
        <dd><form:input path="name"/></dd>
        <dt>Series</dt>
        <dd><form:input path="series"/></dd>
        <dt>Number</dt>
        <dd><form:input path="number"/></dd>
        <dt>Authority</dt>
        <dd><form:input path="authority"/></dd>
        <dt>Issue date</dt>
        <dd><form:input path="dateIssue" type="date"/></dd>
        <dt>Expiration date</dt>
        <dd><form:input path="dateExpire" type="date"/></dd>

        <dt>Main/Additional</dt>
        <dd>
            Main<form:radiobutton path="main" value="true"/>
            Additional<form:radiobutton path="main" value="false"/>
        </dd>
    </dl>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
