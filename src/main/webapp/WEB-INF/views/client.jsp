<%--
  User: A. Vlasenko 16.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <dd><form:input path="firstName"/> <form:errors path="firstName" cssClass="error"/></dd>
        <dt>Last name</dt>
        <dd><form:input path="lastName"/> <form:errors path="lastName" cssClass="error"/></dd>
        <dt>Middle name</dt>
        <dd><form:input path="middleName"/> <form:errors path="middleName" cssClass="error"/></dd>
        <dt>Identification code</dt>
        <dd><form:input path="identNumber"/> <form:errors path="identNumber" cssClass="error"/></dd>
        <dt>Date of Birth</dt>
        <dd><form:input path="dateBirth" type="date"/> <form:errors path="dateBirth" cssClass="error"/></dd>
        <dt>Place of birth</dt>
        <dd><form:input path="placeBirth"/> <form:errors path="placeBirth" cssClass="error"/></dd>
        <dt>Resident status</dt>
        <dd>
            Resident<form:radiobutton path="resident" value="true"/>
            Non-resident<form:radiobutton path="resident" value="false"/>
        </dd>
        <dt>Citizenship</dt>
        <dd><form:input path="citizenship"/> <form:errors path="citizenship" cssClass="error"/></dd>
        <dt>Political exposed person</dt>
        <dd>
            Yes<form:radiobutton path="pep" value="true"/>
            No<form:radiobutton path="pep" value="false"/>
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
        <dt>Workplace</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.work == null}">
                    <a href="${individual.id}/work">Add workplace</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>
                                Company name
                            </th>
                            <th>
                                Identification code
                            </th>
                            <th>
                                Position
                            </th>
                        </tr>
                        <tr>
                            <td>
                                    ${individual.work.name}
                            </td>
                            <td>
                                    ${individual.work.identCode}
                            </td>
                            <td>
                                    ${individual.work.position}
                            </td>
                        </tr>
                    </table>
                    <a href="${individual.id}/work">Edit workplace</a>
                    <a href="${individual.id}/work?action=delete">Delete workplace</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Contact</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.contact == null}">
                    <a href="${individual.id}/contact">Add contact</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>
                                Home tel. number
                            </th>
                            <th>
                                Work tel. number
                            </th>
                            <th>
                                Mobile tel. number
                            </th>
                            <th>
                                Fax
                            </th>
                            <th>
                                E-mail
                            </th>
                        </tr>
                        <tr>
                            <td>
                                    ${individual.contact.homeTel}
                            </td>
                            <td>
                                    ${individual.contact.workTel}
                            </td>
                            <td>
                                    ${individual.contact.mobileTel}
                            </td>
                            <td>
                                    ${individual.contact.fax}
                            </td>
                            <td>
                                    ${individual.contact.email}
                            </td>
                        </tr>
                    </table>
                    <a href="${individual.id}/contact">Edit contact</a>
                    <a href="${individual.id}/contact?action=delete">Delete contact</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Entrepreneur activity</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.entrepreneurInfo == null}">
                    <a href="${individual.id}/entrepreneur">Add entrepreneur info</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>
                                Registration Number
                            </th>
                            <th>
                                Authority
                            </th>
                            <th>
                                Registration Date
                            </th>
                            <th>
                                Type of activity
                            </th>
                        </tr>
                        <tr>
                            <td>${individual.entrepreneurInfo.regNumber}</td>
                            <td>${individual.entrepreneurInfo.authority}</td>
                            <td>${individual.entrepreneurInfo.regDate}</td>
                            <td>${individual.entrepreneurInfo.activity}</td>
                        </tr>
                    </table>
                    <a href="${individual.id}/entrepreneur">Edit entrepreneur info</a>
                    <a href="${individual.id}/entrepreneur?action=delete">Delete entrepreneur info</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Financial monitoring info</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.fmInfo == null}">
                    <a href="${individual.id}/fmInfo">Add FM Info</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>Service history</th>
                            <th>Income sources and size</th>
                        </tr>
                        <tr>
                            <td>${individual.fmInfo.serviceHistory}</td>
                            <td>
                        <tr>
                            <th>Total month income</th>
                            <td>${individual.fmInfo.incomeSources.monthIncome}</td>
                        </tr>
                        <tr>
                            <th>Financial help</th>
                            <td>${individual.fmInfo.incomeSources.financialHelp}</td>
                        </tr>
                        <tr>
                            <th>Securities</th>
                            <td>${individual.fmInfo.incomeSources.securities}</td>
                        </tr>
                        <tr>
                            <th>Assignment</th>
                            <td>${individual.fmInfo.incomeSources.assignment}</td>
                        </tr>
                        <tr>
                            <th>Loan</th>
                            <td>${individual.fmInfo.incomeSources.loans}</td>
                        </tr>
                        <tr>
                            <th>Term contracts</th>
                            <td>${individual.fmInfo.incomeSources.termContracts}</td>
                        </tr>
                        </td>
                        </tr>
                    </table>
                    <a href="${individual.id}/fmInfo">Edit FM Info</a>
                    <a href="${individual.id}/fmInfo?action=delete">Delete FM Info</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Account opener</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.accOpener == null}">
                    <a href="${individual.id}/proxies/accOpener">Add account opener</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>Full Name</th>
                            <th>Identification number</th>
                        </tr>
                        <tr>
                            <td>${individual.accOpener.id}</td>
                            <td>${individual.accOpener.lastName} ${individual.accOpener.firstName} ${individual.accOpener.middleName}</td>
                            <td>${individual.accOpener.identNumber}</td>
                        </tr>
                    </table>
                    <a href="${individual.accOpener.id}">Edit account opener</a>
                    <a href="${individual.accOpener.id}?action=delete">Delete account opener</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Representative</dt>
        <dd>
            <c:choose>
                <c:when test="${individual.representative == null}">
                    <a href="${individual.id}/proxies/representative">Add representative</a>
                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>ID</th>
                            <th>Full Name</th>
                            <th>Identification number</th>
                        </tr>
                        <tr>
                            <td>${individual.representative.id}</td>
                            <td>${individual.representative.lastName} ${individual.representative.firstName} ${individual.representative.middleName}</td>
                            <td>${individual.representative.identNumber}</td>
                        </tr>
                    </table>
                    <a href="${individual.representative.id}">Edit representative</a>
                    <a href="${individual.representative.id}?action=delete">Delete representative</a>
                </c:otherwise>
            </c:choose>
        </dd>
        <dt>Account list</dt>
        <dd>
            <c:if test="${individual.accounts != null && not empty individual.accounts}">
                <table border="1">
                    <tr>
                        <th>Account number</th>
                        <th>Date opened</th>
                        <th>Date opened</th>
                    </tr>
                    <c:forEach items="${individual.accounts}" var="account">
                        <tr>
                            <td>${account.number}</td>
                            <td>${account.opened}</td>
                            <td>${account.closed}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </dd>
    </dl>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
