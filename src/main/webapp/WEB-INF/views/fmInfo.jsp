<%--
  User: A. Vlasenko 19.07.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Fm Info</title>
</head>
<body>
<form:form method="post" modelAttribute="fmInfo">
    <dl>
        <form:hidden path="id"/>
        <dt>Service history</dt>
        <dd><form:input path="serviceHistory"/></dd>
        <dt>Income sources and size</dt>
        <dd>
            <dl>
                <dt>Total month income</dt>
                <dd><form:input path="incomeSources.monthIncome"/></dd>
                <dt>Financial help</dt>
                <dd><form:input path="incomeSources.financialHelp"/></dd>
                <dt>Securities</dt>
                <dd><form:input path="incomeSources.securities"/></dd>
                <dt>Assignment</dt>
                <dd><form:input path="incomeSources.assignment"/></dd>
                <dt>Loan</dt>
                <dd><form:input path="incomeSources.loans"/></dd>
                <dt>Term contracts</dt>
                <dd><form:input path="incomeSources.termContracts"/></dd>
            </dl>
        </dd>
    </dl>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
