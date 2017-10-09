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
    <%--<link rel="stylesheet" href="/css/test.css"/>--%>
    <%--<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>--%>
    <link rel="stylesheet" href="/js/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/ztree/jquery.ztree.all-3.5.js"></script>

    <style type="text/css">
        * {
            border: 1px solid aquamarine;
        }
    </style>
</head>
<body>
<script>

    $(document).ready(function () {
        $("#submit").click(function () {
            var name = $("input[name='name']").val();
            var parentId = $("input[name='pId']").val();
            //  alert(name);

            $.post("/category/add", {"name": name, "pId": parentId}, function (data) {
                //alert(data);
                window.location.reload();
            })
        });

        $("#clear").click(function () {

            $("input[name='showPname']").val("").attr('placeholder', '无 (点击树选择)');
            $("input[name='pId']").val("");
        });


        $("#deleteButton").click(function () {
            var id = $("input[name='deleteId']").val();
            var showPname = $("input[name='showPname']").val();
            var isDelete = confirm("删除【" + showPname + "】分类以及它下属分类?");
            if (isDelete) {

                //  alert(id);
                $.post("/category/delete", {"deleteId": id}, function (data) {
                    // alert(data);
                    window.location.reload();
                })
            }

        });

    });

    function showContent(obj) {
        $("#mainContent").children().hide();
        $(obj).show();
    }

</script>
<div id="menu" style="float: left">
    <h1>文章后台管理页面2</h1>
    <ul id="menuList">
        <li><a href="javascript:void(0);" onclick="showContent('#category')">文章类别</a></li>
        <li><a href="javascript:void(0);" onclick="showContent('#content')">文章内容</a></li>
    </ul>
</div>
<%--menu div end--%>
<div id="mainContent">

    <div id="category" style="float: left">
        <h3>分类添加</h3>

        <label>
            分类名称:
            <input name="name"/>
        </label>
        父名称: <input name="showPname" readonly="readonly" placeholder="无 (点击树选择)"/> <input name="pId" hidden="hidden"/>

        <input id="submit" type="button" value="添加"/>
        <input id="clear" type="button" value="重置"/>


        <h3>分类预览</h3>
        <span id="toast"></span>
        <input id="deleteButton" type="button" value="删除所选"/>
        <input name="deleteId" hidden="hidden">


        <div>
            <!-- 使用简单json构造ztree -->
            <ul id="ztree3" class="ztree"></ul>
            <script type="text/javascript">
                $(function () {
                    //页面加载完成后
                    var setting3 = {
                        data: {
                            simpleData: {
                                enable: true//使用简单json

                            }
                        },
                        //click !
                        callback: {
                            onClick: function (event, treeId, treeNode) {
                                //  alert(treeNode.page);
                                $("input[name='showPname']").val(treeNode.name);
                                $("input[name='pId']").val(treeNode.id);
                                $("input[name='deleteId']").val(treeNode.id);
                                $("#toast").text("所选：" + treeNode.name);


                            }
                        }
                    };

                    //发送Ajax请求获取Json数据
                    var url = "/category/list";
                    $.get(url, {}, function (data) {
                        //alert(data.id);
                        $.fn.zTree.init($("#ztree3"), setting3, data);
                        // $.fn.zTree.expandAll(true);
                    }, "json");
                });
            </script>
        </div>

    </div>
    <div id="content" style="float: left;display: none">
        <div id="article_table" style="float: left">
            <h3>筛选文章:</h3>
            <table id="content_table">
                <tr>
                    <th>序号</th>
                    <th>分类</th>
                    <th>标题</th>
                    <th>正文</th>
                    <th>创建人</th>
                    <th>创建时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <script>
                    function  initiTableData(url) {
                        $.post(url, function (data) {
                            $.each(data, function (index, item) {
                                $("#content_table").append("<tr id='app_data'>\n" +
                                    "<th>" + (index + 1) + "</th>" +
                                    "<th>" + this.categoryName + "</th>" +
                                    "<th>" + this.blogTitle + "</th>" +
                                    "<th>" + this.blogContent + "</th>" +
                                    "<th>" + this.createBy + "</th>" +
                                    "<th>" + this.createTime + "</th>" +
                                    "<th>" + this.status + "</th>" +
                                    "<th><a href='javascript:void(0);' onclick=deleteOption('/article/delete?id=" + this.blogId + "','" + this.blogTitle + "')>删除</a><a href='/article/edit?id=" + this.blogId + "'>修改</a><th>" +
                                    "</tr>")
                            });
                        }, "json");
                    };

                    initiTableData("/article/ajaxList");


                    function deleteOption(url, name) {
                        var isDelete = confirm("删除文章【" + name + "】吗?");
                        if (isDelete) {
                            $.post(url, function (data) {
                                // alert(data);
                                window.location.reload();
                            })
                        }
                    }
                </script>
            </table>
        </div>
        <%--div table-aritcle end--%>

        <div id="article_tree" style="float: left">
            <!-- 使用简单json构造ztree -->
            <ul id="ztree4" class="ztree"></ul>
            <script type="text/javascript">
                $(function () {
                    //页面加载完成后
                    var setting4 = {
                        data: {
                            simpleData: {
                                enable: true//使用简单json

                            }
                        },
                        //click !
                        callback: {
                            onClick: function (event, treeId, treeNode) {
                                $("tr#app_data").remove();
                                initiTableData("/article/ajaxList/?id="+treeNode.id);
                            }
                        }
                    };

                    //发送Ajax请求获取Json数据
                    var url = "/category/list";
                    $.get(url, {}, function (data) {
                        //alert(data.id);
                        $.fn.zTree.init($("#ztree4"), setting4, data);
                        // $.fn.zTree.expandAll(true);
                    }, "json");
                });
            </script>
        </div>
        <%--article tree div end--%>
    </div>
    <%--caontent div end--%>
</div>
<%--main div end--%>
</body>
</html>
