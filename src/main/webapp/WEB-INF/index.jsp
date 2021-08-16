<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>

<body>

<form action="${pageContext.request.contextPath}/" method="post">

    <label>First Name:
        <input name="firstName" type="text"  required>
    </label><br>

    <label>Last Name:
        <input name="lastName" type="text"  required>
    </label><br>

    <label>Age:
        <input name="age" type="text"  required>
    </label><br>
    <button name="save" type="submit">Save</button>
</form>

    <table border="1">
        <caption>Список юзеров</caption>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Change user</th>
            <th>Delete user</th>
        </tr>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <form action="${pageContext.request.contextPath}/change" method="post">
                    <td><input type="hidden" name="id" value="${user.id}" >${user.id}</td>
                    <td><input type="text" name="firstName" value="${user.firstName}" ></td>
                    <td><input type="text" name="lastName" value="${user.lastName}" ></td>
                    <td><input type="text" name="age" value="${user.age}" ></td>
                    <td><button type="submit">Change User</button></td>

                </form>
                <td><form action="${pageContext.request.contextPath}/delete" method="post">
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit">Delete user</button>
                </form></td>

            </tr>
        </c:forEach>


    </table>




</body>
</html>