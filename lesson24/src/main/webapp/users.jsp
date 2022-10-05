<%@ page import="com.teachmeskills.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Users</h1>
<table>
    <tr>
        <th>Name</th>
    </tr>
    <% for (User user : (List<User>) request.getAttribute("users")) {%>
    <tr>
        <td>
            <%=user.getName()%>
        </td>
    </tr>
    <%} %>
</table>
</body>
</html>
