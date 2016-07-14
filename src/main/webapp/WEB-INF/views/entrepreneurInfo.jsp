<%--
  User: A. Vlasenko 28.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Entrepreneur Info</title>
</head>
<body>
    <form:form method="POST" modelAttribute="entrepreneurInfo">
        <dl>
            <form:hidden path="id"/>
            <dt>Registration Number</dt>
            <dd><form:input path="regNumber"/></dd>
            <dt>Authority</dt>
            <dd><form:input path="authority"/></dd>
            <dt>Registration Date</dt>
            <dd><form:input path="regDate" type="date"/></dd>
            <dt>Type of activity</dt>
            <dd><form:input path="activity"/></dd>
        </dl>
        <button type="submit">Save</button>
    </form:form>
</body>
</html>
