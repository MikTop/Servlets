<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <ul>
        <c:forEach var="user" items="${requestScope.users}">
            <li>
                <p>
                    <span>Id:${user.id} First Name:${user.firstName} Last Name:${user.lastName}  Age:${user.age}</span><br>

                </p>
            </li>
        </c:forEach>
    </ul>


</body>
</html>