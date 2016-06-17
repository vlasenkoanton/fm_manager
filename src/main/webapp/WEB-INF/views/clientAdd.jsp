<%--
  User: A. Vlasenko 16.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title></title>
</head>
<body>
    <form:form action="clients/new" method="POST" commandName="client">
        <dl>
            <form:hidden path="id"/>
            <dt>Identification code</dt>
            <dd><form:input path="identNumber" /></dd>
            <dt>First name</dt>
            <dd><form:input path="firstName" /></dd>
            <dt>Last name</dt>
            <dd><form:input path="lastName" /></dd>
            <dt>Middle name</dt>
            <dd><form:input path="middleName" /></dd>
        </dl>
        <button type="submit">Add</button>
    </form:form>
</body>
</html>
