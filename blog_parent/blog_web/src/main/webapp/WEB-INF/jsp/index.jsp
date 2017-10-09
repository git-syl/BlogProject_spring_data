<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ainsc
  Date: 2017/9/16
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello
<c:forEach items="${result}" var="list">
    ${list.id}--${list.name}<<br>/>
</c:forEach>
</body>
</html>
