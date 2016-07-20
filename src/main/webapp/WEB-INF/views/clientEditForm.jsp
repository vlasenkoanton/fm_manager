<%--
  User: A. Vlasenko 16.06.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
    <form:form method="POST" modelAttribute="client">
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
                    <c:when test="${client.address == null}">
                        <a href="${client.id}/address/new">Add address</a>
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
                                    ${client.address.postCode}
                                </td>
                                <td>
                                    ${client.address.country}
                                </td>
                                <td>
                                    ${client.address.region}
                                </td>
                                <td>
                                    ${client.address.district}
                                </td>
                                <td>
                                    ${client.address.city}
                                </td>
                                <td>
                                    ${client.address.house}
                                </td>
                                <td>
                                    ${client.address.apartment}
                                </td>
                            </tr>
                        </table>
                        <a href="${client.id}/address/${client.address.id}">Edit address</a>
                        <a href="${client.id}/address/${client.address.id}?action=delete">Delete address</a>
                    </c:otherwise>
                </c:choose>
            </dd>
            <dt>Documents</dt>
            <dd>
                <c:choose>
                    <c:when test="${client.documents == null || empty client.documents}">
                        <a href="${client.id}/document/new">Add document</a>
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
                            <c:forEach items="${client.documents}" var="document">
                                <tr>
                                    <td>${document.type}</td>
                                    <td>${document.name}</td>
                                    <td>${document.series}</td>
                                    <td>${document.number}</td>
                                    <td>${document.authority}</td>
                                    <td>${document.dateIssue}</td>
                                    <td>${document.dateExpire}</td>
                                    <td>${document.main}</td>
                                    <td><a href="${client.id}/document/${document.id}">Edit</a></td>
                                    <td><a href="${client.id}/document/${document.id}?action=delete">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a href="${client.id}/document/new">Add document</a>
                    </c:otherwise>
                </c:choose>
            </dd>
            <dt>Workplace</dt>
            <dd>
                <c:choose>
                    <c:when test="${client.work == null}">
                        <a href="${client.id}/work/new">Add workplace</a>
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
                                    ${client.work.name}
                                </td>
                                <td>
                                    ${client.work.identCode}
                                </td>
                                <td>
                                    ${client.work.position}
                                </td>
                            </tr>
                        </table>
                        <a href="${client.id}/work/${client.work.id}">Edit workplace</a>
                        <a href="${client.id}/work/${client.work.id}?action=delete">Delete workplace</a>
                    </c:otherwise>
                </c:choose>
            </dd>
            <dt>Contact</dt>
            <dd>
                <c:choose>
                    <c:when test="${client.contact == null}">
                        <a href="${client.id}/contact/new">Add contact</a>
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
                                        ${client.contact.homeTel}
                                </td>
                                <td>
                                        ${client.contact.workTel}
                                </td>
                                <td>
                                        ${client.contact.mobileTel}
                                </td>
                                <td>
                                        ${client.contact.fax}
                                </td>
                                <td>
                                        ${client.contact.email}
                                </td>
                            </tr>
                        </table>
                        <a href="${client.id}/contact/${client.contact.id}">Edit contact</a>
                        <a href="${client.id}/contact/${client.contact.id}?action=delete">Delete contact</a>
                    </c:otherwise>
                </c:choose>
            </dd>
            <dt>Entrepreneur activity</dt>
            <dd>
                <c:choose>
                    <c:when test="${client.entrepreneurInfo == null}">
                        <a href="${client.id}/entrepreneur/new">Add entrepreneur info</a>
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
                                <td>${client.entrepreneurInfo.regNumber}</td>
                                <td>${client.entrepreneurInfo.authority}</td>
                                <td>${client.entrepreneurInfo.regDate}</td>
                                <td>${client.entrepreneurInfo.activity}</td>
                            </tr>
                        </table>
                        <a href="${client.id}/entrepreneur/${client.entrepreneurInfo.id}">Edit entrepreneur info</a>
                        <a href="${client.id}/entrepreneur/${client.entrepreneurInfo.id}?action=delete">Delete entrepreneur info</a>
                    </c:otherwise>
                </c:choose>
            </dd>
            <dt>Financial monitoring info</dt>
            <dd>
                <c:choose>
                    <c:when test="${client.fmInfo == null}">
                        <a href="${client.id}/fmInfo/new">Add FM Info</a>
                    </c:when>
                    <c:otherwise>
                        <table border="1">
                            <tr>
                                <th>Service history</th>
                                <th>Income sources and size</th>
                            </tr>
                            <tr>
                                <td>${client.fmInfo.serviceHistory}</td>
                                <td>
                                    <tr><th>Total month income</th><td>${client.fmInfo.incomeSources.monthIncome}</td></tr>
                                    <tr><th>Financial help</th><td>${client.fmInfo.incomeSources.financialHelp}</td></tr>
                                    <tr><th>Securities</th><td>${client.fmInfo.incomeSources.securities}</td></tr>
                                    <tr><th>Assignment</th><td>${client.fmInfo.incomeSources.assignment}</td></tr>
                                    <tr><th>Loan</th><td>${client.fmInfo.incomeSources.loans}</td></tr>
                                    <tr><th>Term contracts</th><td>${client.fmInfo.incomeSources.termContracts}</td></tr>
                                </td>
                            </tr>
                        </table>
                        <a href="${client.id}/fmInfo/${client.fmInfo.id}">Edit FM Info</a>
                        <a href="${client.id}/fmInfo/${client.fmInfo.id}?action=delete">Delete FM Info</a>
                    </c:otherwise>
                </c:choose>
            </dd>
        </dl>
        <button type="submit">Save</button>
    </form:form>
</body>
</html>
