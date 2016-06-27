<%--
  User: A. Vlasenko 18.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Address</title>
</head>
<body>
    <form:form action="address" method="post" modelAttribute="address">
        <dl>
            <dt>Postal code</dt>
            <dd><form:input path="postCode"/></dd>
            <dt>Country</dt>
            <dd><form:input path="country"/></dd>
            <dt>Region</dt>
            <dd><form:input path="region"/></dd>
            <dt>District</dt>
            <dd><form:input path="district"/></dd>
            <dt>City/Town/Village</dt>
            <dd><form:input path="city"/></dd>
            <dt>Street</dt>
            <dd><form:input path="street"/></dd>
            <dt>House #</dt>
            <dd><form:input path="house"/></dd>
            <dt>Apartment/Room #</dt>
            <dd><form:input path="apartment"/></dd>
            </dl>
            <button type="submit">Save</button>
    </form:form>
</body>
</html>
