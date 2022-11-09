<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 25px">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h3>Create New User</h3>
                </div>
                <div class="card-text">
                    <form action="users" method="POST">
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label" for="name">Name</label>
                            <div class="col-sm-7">
                                <input class="col-form-label form-control" id="name" name="name" placeholder="Name">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label" for="password">Password</label>
                            <div class="col-sm-7">
                                <input class="col-form-label form-control" type="password"
                                       id="password" name="password"
                                       placeholder="Role">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label" for="role">Role</label>
                            <div class="col-sm-7">
                                <input class="col-form-label form-control"
                                       id="role" name="role"
                                       placeholder="Password">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 25px">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h3>Users</h3>
                </div>
                <div class="card-text">
                    <table class="table">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Role</th>
                            <th>Password</th>
                            <th>Created At</th>
                        </tr>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>
                                    <span class="text-primary"><c:out value="${user.id}" /></span>
                                </td>
                                <td>
                                    <c:out value="${user.name}" />
                                </td>
                                <td>
                                    <c:out value="${user.role}" />
                                </td>
                                <td>
                                    <c:out value="${user.password}" />
                                </td>
                                <td>
                                    <f:formatDate value="${user.createdAt}" pattern="YYYY-MM-dd HH:mm:ss" />
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${param.error != null }">
        <div class="row" style="margin-top: 25px">
            <div class="alert alert-danger" role="alert">
                    ${param.error}
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
