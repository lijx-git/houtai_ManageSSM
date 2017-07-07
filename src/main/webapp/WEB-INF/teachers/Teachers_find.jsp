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

  <%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"/>--%>
      <%--<script>
       $(function(){
            //为搜索表单绑定事件
            // alert("key++val,");
            $("#searchArticleForm").off();
            $("#searchArticleForm").on("submit",function(){
                var key=$(this).find("select[name=key]").val();
                var val=$(this).find("input[name=val]").val();
                //alert(key+","+val);

                $(".container").load("${pageContext.request.contextPath }/teachers/find",{
                    key:key,
                    val:val
                });
                //阻止表单默认行为 （提交）
                return false;
            });

        });
    </script>&ndash;%&gt;--%>

</head>

<body>
<div class="container">

    <div class="row">

        <form class="navbar-form navbar-left" role="search" id="searchArticleForm" action="${pageContext.request.contextPath }/teachers/find" method="post">
            <div class="form-group">
                <select name="key" style="height: 34px;">
                    <option value="tid">工号</option>
                    <option value="tname">姓名</option>
                    <option value="IDNumber">身份证号</option>
                </select>
                <input type="text" class="form-control" placeholder="Search" name="val"
                       value="请输入工号/姓名/身份证号查询">
            </div>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </form>
        <table class="table table-striped">
            <tr>
                <th>工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <td>身份证号</td>
                <th>地址</th>
                <c:forEach items="${teachers }" var="s">
            <tr>
                <td>${s.tid }</td>
                <td>${s.tname }</td>
                <td>${s.gender}</td>
                <td style="size: 20px;">${s.birthday}</td>
            <td>${s.IDNumber}</td>
                <td>${s.address}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
