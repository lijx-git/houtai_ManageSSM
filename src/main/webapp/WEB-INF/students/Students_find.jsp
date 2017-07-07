<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/6
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!-- 加载jstl的c标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css" href="../css/default.css" />
 <%--   <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"/>
 <script>
        $(function(){
            //为搜索表单绑定事件
           // alert("key++val,");
            $("#searchArticleForm").off();
            $("#searchArticleForm").on("submit",function(){
                var key=$(this).find("select[name=key]").val();
                var val=$(this).find("input[name=val]").val();
                //alert(key+","+val);

                $(".container").load("${pageContext.request.contextPath }/user/searchStaff",{
                    key:key,
                    val:val
                });
                //阻止表单默认行为 （提交）
                return false;
            });

        });
    </script>--%>

</head>
<style type="text/css">
    * {
        background: none repeat scroll 0 0 transparent;
        border: 1 none;
        margin: 0;
        padding: 0;
        vertical-align: baseline;
        font-family:微软雅黑;
        overflow:hidden;
    }
</style>
<body>
<div class="container">

    <div class="row">

        <form class="navbar-form navbar-left" role="search" id="searchArticleForm" action="${pageContext.request.contextPath }/students/find" method="post">
            <div class="form-group">
                <select name="key" style="height: 34px;">
                    <option value="sid">学号</option>
                    <option value="sname">姓名</option>
                    <option value="address">地址</option>
                </select>
                <input type="text" class="form-control" placeholder="Search" name="val"
                       value="请输入工号/姓名/地址查询">
            </div>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </form>
        <table class="table table-striped">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>地址</th>
                <c:forEach items="${students }" var="s">
            <tr>
                <td>${s.sid }</td>
                <td>${s.sname }</td>
                <td>${s.gender}</td>
                <td style="size: 20px;">${s.birthday}</td>
                <td>${s.address}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
