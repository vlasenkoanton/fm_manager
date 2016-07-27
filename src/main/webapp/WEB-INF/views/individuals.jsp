<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Individuals</title>
</head>
<body>
<h1>Individuals</h1>

<a href="individuals?action=create">Add new client</a>

<table border="1" cellpadding="5">
<thead>
<tr>
    <th>
        ID
    </th>
    <th>
        Type
    </th>
    <th>
        Name
    </th>
    <th>
        Identification Number
    </th>
</tr>
</thead>

<c:forEach items="${individuals}" var="individual">
    <tr>
        <td>
                ${individual.id}
        </td>
        <td>
            <c:out value="${individual.client eq true ? 'client' : 'related person'}"/>
        </td>
        <td>
                ${individual.lastName} ${individual.firstName} ${individual.middleName}
        </td>
        <td>
                ${individual.identNumber}
        </td>
        <td>
            <a href="individuals/${individual.id}">Edit</a>
            <a href="individuals/${individual.id}?action=delete">Delete</a>
        </td>
    </tr>
</c:forEach>

</table>
</body>
</html>
