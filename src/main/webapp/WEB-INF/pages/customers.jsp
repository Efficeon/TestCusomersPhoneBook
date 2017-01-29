<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/page.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.mask.min.js"/>"></script>
</head>

<body>
<form:form id="customerUpdate" method="POST" modelAttribute="phoneNumber" action="/customers/">
<div>
    <table>
        <tr>
            <th>Customer Name</th>
            <th>Phone</th>
            <th>Type</th>
            <th>Comments</th>
        </tr>
        <c:forEach items="${listCustomers}" var="customer" >
            <tr>
                <td>${customer.name}</td>
                <td><span id="${customer.id}" name="number" onclick="change(this.id, this.attributes['name'].value)">${customer.phoneNumber.number}</span>
                    <input class="numberInput" id="number${customer.id}" type="text">
                </td>
                <td><span id="${customer.id}" name="type" onclick="change(this.id, this.attributes['name'].value)">${customer.phoneNumber.type}</span>
                    <select class="typeList" id="type${customer.id}">
                        <option>Home</option>
                        <option>Mobile</option>
                        <option>None</option>
                    </select>
                </td>
                <td><span id="${customer.id}" name="comment" onclick="change(this.id, this.attributes['name'].value)">${customer.phoneNumber.description}</span>
                    <input class="commentInput" id="comment${customer.id}" type="text">
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit" id="customerUpdate">
        <spring:message text="Add"/>
    </button>
</div>
</form:form>
</body>
</html>
