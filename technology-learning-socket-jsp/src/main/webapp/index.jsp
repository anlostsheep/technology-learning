<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>用户信息</h1>
<table>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>电话号码</th>
        <th>邮箱</th>
        <th>地址</th>
    </tr>
    <c:forEach items="${data}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>
                <a href="/app/${user.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
