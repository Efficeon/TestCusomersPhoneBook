<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Customers Catalog</title>
    <link href="${contextPath}/resources/css/page.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<table id="table">
    <form:form method="POST" commandName="container" action="update"  onsubmit="return false">
    <tr>
        <th>Full name</th>
        <th>Phone Number</th>
        <th>Type</th>
        <th>Description</th>
    </tr>
    <c:forEach var="container" items="${container.list}"
               varStatus="status">
        <tr>
            <td><form:input readonly="true"
                            path="list[${status.index}].name"
                            value="${container.name}" class="form-control" /></td>
            <td><form:input
                    path="list[${status.index}].phoneNumber.number"
                    value="${container.phoneNumber.number}" class="form-control"/></td>
            <td><form:select
                    path="list[${status.index}].phoneNumber.type">
                <form:option value="mob">mob</form:option>
                <form:option value="home">home</form:option>
                <form:option value="no info">no info</form:option>
            </form:select>
            </td>
            <td><form:input
                    path="list[${status.index}].phoneNumber.description"
                    value="${container.phoneNumber.description}" class="form-control"/></td>

            <form:input style="display:none;"
                     path="list[${status.index}].id"
                     value="${container.id}" class="form-control"/>

            <form:input style="display:none;"
                     path="list[${status.index}].phoneNumber.id"
                     value="${container.phoneNumber.id}" class="form-control"/></td>

    </c:forEach>
</table>
<input type="submit" value="Update" class="btn btn-lg btn-success" onclick="searchAjax()">
</form:form>
</body>
</html>