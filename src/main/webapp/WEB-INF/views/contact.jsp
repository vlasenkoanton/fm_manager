<%--
  User: A. Vlasenko 27.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Contact</title>
</head>
<body>
    <form:form method="POST" modelAttribute="contact">
        <dl>
            <form:hidden path="id"/>
            <dt>Home tel. number</dt>
            <dd><form:input path="homeTel"/></dd>
            <dt>Work tel. number</dt>
            <dd><form:input path="workTel"/></dd>
            <dt>Mobile tel. number</dt>
            <dd><form:input path="mobileTel"/></dd>
            <dt>Fax</dt>
            <dd><form:input path="fax"/></dd>
            <dt>E-mail</dt>
            <dd><form:input path="email"/></dd>
        </dl>
        <button type="submit">Save</button>
    </form:form>
</body>
</html>
