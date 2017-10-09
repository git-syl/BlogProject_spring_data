<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ainsc
  Date: 2017/9/21
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>background-index</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <style type="text/css">
        * {
            border: 1px solid aquamarine;
        }
    </style>
</head>
<body>
<script>
    $(function () {


    });

    function showContent(obj) {
        $("#mainContent").children().hide();
        $(obj).show();
    }
</script>
<div id="menu" style="float: left">
    <h1>文章后台管理页面1</h1>
    <ul id="menuList">
        <li><a href="#" onclick="showContent('#category')">文章类别</a></li>
        <li><a href="#" onclick="showContent('#content')">文章内容</a></li>
    </ul>
</div>
<div id="mainContent">

    <div id="category" style="float: left">
        <%--<form action="/background/add.html" method="post">--%>
            <form action="/background/add.html" method="post">
                分类名称:
                <input name="name"  />
                父名称:
                <select name="parentId">
                    <option value="0">--请选择--</option>
                    <option value="0">无</option>
                    <c:forEach items="${parentList}" var="n">
                            <option value="${n.categoryId}">${n.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="添加"/>
            </form>
        <table>
            <tr>
                <th>序号</th>
                <th>ID</th>
                <th>父名称</th>
                <th>分类名称</th>
                <th>创建人</th>
                <th>创建时间</th>
                <th>更新人</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${categoryList}" var="n" varStatus="c">
                <tr>
                    <td>${c.count}</td>
                    <td>${n.category_id}</td>
                    <td>${n.parent_name}</td>
                    <td>${n.name}</td>

                    <td>${n.create_by}</td>
                    <td><fmt:formatDate value="${n.create_time}" pattern="yyyy-MM-dd"/></td>
                    <td>${n.update_by}</td>
                    <td><fmt:formatDate value="${n.update_time}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <a href="/background/edit.html?id=${n.category_id}">修改</a>
                        <a>删除</a>
                    </td>
                </tr>
            </c:forEach>


        </table>
    </div>
    <div id="content" style="float: left;display: none">
        筛选:
    </div>
</div>
</body>
</html>
