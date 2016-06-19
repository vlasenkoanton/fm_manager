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
    <form:form method="POST" commandName="client">
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
            <dt>Place of birth</dt>
            <dd><form:input path="placeBirth" /></dd>
            <dt>Resident status</dt>
            <dd>
                Resident<form:radiobutton path="resident" value="true" />
                Non-resident<form:radiobutton path="resident" value="false" />
            </dd>
            <dt>Citizenship</dt>
            <dd><form:input path="citizenship" /></dd>
            <dt>Address</dt>
            <dd>
                <p>${client.address.country}, ${client.address.city}, ${client.address.street}, house #${client.address.house}, aprt.${client.address.apartment}</p>
                <a href="${client.id}/address">Add address</a>
            </dd>
        </dl>
        <button type="submit">Save</button>
    </form:form>
</body>
</html>
