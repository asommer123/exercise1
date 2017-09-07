<%@include file="head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>

<%--[done] TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>

    <style>
        table, th, td {
            border: 3px solid #696969;
            border-collapse: collapse;
        }
        th {
            color: #0000FF;
        }
        th, td {
            padding: 6px;
            text-align: left;
        }
        tr:hover {background-color:#FFEFD5}
    </style>

    <table style=""width:100%">
    <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date Of Birth</th>
        <th>Age</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userid}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.calculateAge()}</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>
