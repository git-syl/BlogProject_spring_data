<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ainsc
  Date: 2017/9/21
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
</head>
<body>
<script>
</script>
<form action="/background/update.html" method="post">
    <input name="categoryId" value="${categoryVo.category_id}" hidden="hidden">
    分类名称:
    <input name="name" value="${categoryVo.name}" />
    父名称:
    <select name="parentId">
        <option value="0">无</option>
        <c:forEach items="${parentList}" var="n">
            <c:if test="${n.categoryId!=categoryVo.category_id}">

                <option value="${n.categoryId}" <c:if test="${n.categoryId==categoryVo.parent_id}">selected</c:if> >${n.name}</option>
            </c:if>
        </c:forEach>
    </select>
    <input type="submit"/>
</form>

</body>
</html>
