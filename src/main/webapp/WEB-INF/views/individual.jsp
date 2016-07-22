<%--
  User: A. Vlasenko 19.07.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form:form method="POST" modelAttribute="individual">
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
        <dt>Responsible employee</dt>
        <dd><form:input path="responsible" /></dd>
        <dt>Political exposed person</dt>
        <dd>
            Yes<form:radiobutton path="pep" value="true" />
            No<form:radiobutton path="pep" value="false" />
        </dd>
        <dt>Address</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.address == null}">
                    <a href="${individual.id}/address">New Address</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>
                                Postal code
                            </th>
                            <th>
                                Country
                            </th>
                            <th>
                                Region
                            </th>
                            <th>
                                District
                            </th>
                            <th>
                                City/Town/Village
                            </th>
                            <th>
                                House #
                            </th>
                            <th>
                                Apartment/Room #
                            </th>
                        </tr>
                        <tr>
                            <td>
                                    ${individual.address.postCode}
                            </td>
                            <td>
                                    ${individual.address.country}
                            </td>
                            <td>
                                    ${individual.address.region}
                            </td>
                            <td>
                                    ${individual.address.district}
                            </td>
                            <td>
                                    ${individual.address.city}
                            </td>
                            <td>
                                    ${individual.address.house}
                            </td>
                            <td>
                                    ${individual.address.apartment}
                            </td>
                        </tr>
                    </table>
                    <a href="${individual.id}/address">Edit Address</a>
                    <a href="${individual.id}/address?action=delete">Delete address</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Documents</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.documents == null || empty individual.documents}">
                    <a href="${individual.id}/documents?action=create">Add document</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>
                                Type
                            </th>
                            <th>
                                Name
                            </th>
                            <th>
                                Series
                            </th>
                            <th>
                                Number
                            </th>
                            <th>
                                Authority
                            </th>
                            <th>
                                Issue date
                            </th>
                            <th>
                                Expiration date
                            </th>
                            <th>
                                Main/Additional
                            </th>
                        </tr>
                        <c:forEach items="${individual.documents}" var="document">
                            <tr>
                                <td>${document.type}</td>
                                <td>${document.name}</td>
                                <td>${document.series}</td>
                                <td>${document.number}</td>
                                <td>${document.authority}</td>
                                <td>${document.dateIssue}</td>
                                <td>${document.dateExpire}</td>
                                <td>${document.main}</td>
                                <td><a href="${individual.id}/documents/${document.id}">Edit</a></td>
                                <td><a href="${individual.id}/documents/${document.id}?action=delete">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="${individual.id}/documents?action=create">Add document</a>
                </c:otherwise>
            </c:choose>
        </dd>
    </dl>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
