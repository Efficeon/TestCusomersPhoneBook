<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>itNavigator</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        function tableToJSON(){
            var container = new Object();
            container.list = [];
            var list;
            console.log(document.getElementById("list0.name").value);
            for(i = 0; i <3; i++) {
                var client = {"id": document.getElementById("list"+i+".id").value,
                    "phoneNumber": {"id": document.getElementById("list"+i+".phoneNumber.id").value
                        , "number": document.getElementById("list"+i+".phoneNumber.number").value
                        , "type": document.getElementById("list"+i+".phoneNumber.type").value
                        , "description": document.getElementById("list"+i+".phoneNumber.description").value
                    }, "name": document.getElementById("list"+i+".name").value
                };

                container.list.push(client);

            }
            console.log(JSON.stringify(container));
            return JSON.stringify(container);
        };


        function searchAjax() {
            // Convert the table into a javascript object
            console.log(table);
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/",
                data : tableToJSON(),
                //dataType : 'json',
                timeout : 100000,
                success : function(data) {
                    console.log("SUCCESS: ", data);

                },
                error : function(e) {
                    console.log("ERROR: ", e);

                },
                done : function(e) {

                }
            });
        }
    </script>
</head>
<body>
<table id="table">
    <thead>
    <form:form method="POST" commandName="container" action="update"  onsubmit="return false">
    <tr>
        <th>FIO</th>
        <th>Number</th>
        <th>Type</th>
        <th>Comment</th>
        <th style="display:none;">TelefoneID</th>
        <th style="display:none;">ClientID</th>
    </tr>
    </thead>

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
            <td><form:input style="display:none;"
                            path="list[${status.index}].id"
                            value="${container.id}" class="form-control"/>
            </td>
            <td><form:input style="display:none;"
                            path="list[${status.index}].phoneNumber.id"
                            value="${container.phoneNumber.id}" class="form-control"/></td>
        </tr>
    </c:forEach>
</table>
<input type="submit" value="Update" class="btn btn-lg btn-success" onclick="searchAjax()">
</form:form>
</body>
</html>