<%--
  User: A. Vlasenko 19.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quick Form</title>
</head>
<body>
<form:form method="POST" commandName="individual">
    <dl>
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
        <dt>Resident status</dt>
        <dd>
            Resident<form:radiobutton path="resident" value="true" />
            Non-resident<form:radiobutton path="resident" value="false" />
        </dd>
        <dt>Address</dt>
        <dd>
            <dl>
                <dt>Postal code</dt>
                <dd><form:input path="address.postCode"/></dd>
                <dt>Country</dt>
                <dd><form:input path="address.country"/></dd>
                <dt>Region</dt>
                <dd><form:input path="address.region"/></dd>
                <dt>District</dt>
                <dd><form:input path="address.district"/></dd>
                <dt>City/Town/Village</dt>
                <dd><form:input path="address.city"/></dd>
                <dt>Street</dt>
                <dd><form:input path="address.street"/></dd>
                <dt>House #</dt>
                <dd><form:input path="address.house"/></dd>
                <dt>Apartment/Room #</dt>
                <dd><form:input path="address.apartment"/></dd>
            </dl>
        </dd>


        <dt>Document</dt>
        <dd>
            <dl>
                <dt>Type</dt>
                <dd><form:input path="document.type"/></dd>
                <dt>Name</dt>
                <dd><form:input path="document.name"/></dd>
                <dt>Series</dt>
                <dd><form:input path="document.series"/></dd>
                <dt>Number</dt>
                <dd><form:input path="document.number"/></dd>
                <dt>Authority</dt>
                <dd><form:input path="document.authority"/></dd>
                <dt>Issue date</dt>
                <dd><form:input path="document.dateIssue" type="date"/></dd>
                <dt>Expiration date</dt>
                <dd><form:input path="document.dateExpire" type="date"/></dd>
                <dt>Main/Additional</dt>
                <dd>
                    Main<form:radiobutton path="document.main" value="true"/>
                    Additional<form:radiobutton path="document.main" value="false"/>
                </dd>
            </dl>
        </dd>
    </dl>
    <button type="submit">Create new client</button>
</form:form>
</body>
</html>
