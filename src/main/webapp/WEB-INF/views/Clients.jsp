<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Clients</title>
</head>
<body>
<h1>Clients</h1>

<a href="clients/new">Add new client</a>

<table border="1" cellpadding="5">
<thead>
<tr>
    <td>
        ID
    </td>
    <td>
        Name
    </td>
    <td>
        Identification Number
    </td>
</tr>
</thead>

<c:forEach items="${clients}" var="client">
    <tr>
        <td>
                ${client.id}
        </td>
        <td>
                ${client.lastName} ${client.firstName} ${client.middleName}
        </td>
        <td>
                ${client.identNumber}
        </td>
        <td>
            <a href="/clients/${client.id}">Edit</a>
            <a href="/clients/${client.id}?action=delete">Delete</a>
        </td>
    </tr>
</c:forEach>

</table>
</body>
</html>
