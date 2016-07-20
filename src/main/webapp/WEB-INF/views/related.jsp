<%--
  User: A. Vlasenko 19.07.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Related</title>
</head>
<body>
<form:form method="POST" commandName="related">
    <dl>
        <form:hidden path="id"/>
        <dt>First name</dt>
        <dd><form:input path="firstName" /></dd>
        <dt>Last name</dt>
        <dd><form:input path="lastName" /></dd>
        <dt>Middle name</dt>
        <dd><form:input path="middleName" /></dd>
        <dt>Identification code</dt>
        <dd><form:input path="identNumber" /></dd>
        <dt>Date of Birth</dt>
        <dd><form:input path="dateBirth" type="date"/></dd>
        <dt>Place of birth</dt>
        <dd><form:input path="placeBirth" /></dd>
        <dt>Resident status</dt>
        <dd>
            Resident<form:radiobutton path="resident" value="true" />
            Non-resident<form:radiobutton path="resident" value="false" />
        </dd>
        <dt>Citizenship</dt>
        <dd><form:input path="citizenship" /></dd>
        <dt>Political exposed person</dt>
        <dd>
            Yes<form:radiobutton path="pep" value="true" />
            No<form:radiobutton path="pep" value="false" />
        </dd>
    </dl>
    <button type="submit">Create new related</button>
</form:form>
</body>
</html>
