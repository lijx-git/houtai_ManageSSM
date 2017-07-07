<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/default.css" />
<style type="text/css">
    * {
        background: none repeat scroll 0 0 transparent;
        border: 0 none;
        margin: 0;
        padding: 0;
        vertical-align: baseline;
        font-family:微软雅黑;
        overflow:hidden;
    }
    #navi{
        width:100%;
        position:relative;
        word-wrap:break-word;
        border-bottom:1px solid #065FB9;
        margin:0;
        padding:0;
        height:40px;
        line-height:40px;
        vertical-align:middle;
        background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1,
        #BFBFBF));
    }
    #naviDiv{
        font-size:14px;
        color:#333;
        padding-left:10px;
    }
    #tips{
        margin-top:10px;
        width:100%;
        height:40px;
    }
    #buttonGroup{
        padding-left:10px;
        float:left;
        height:35px;
    }
    .button{
        float:left;
        margin-right:10px;
        padding-left:10px;
        padding-right:10px;
        font-size:14px;
        width:70px;
        height:30px;
        line-height:30px;
        vertical-align:middle;
        text-align:center;
        cursor:pointer;
        border-color: #77D1F6;
        border-width: 1px;
        border-style: solid;
        border-radius: 6px 6px;
        -moz-box-shadow: 2px 2px 4px #282828;
        -webkit-box-shadow: 2px 2px 4px #282828;
        background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
    }
    #mainContainer{
        padding-left:10px;
        padding-right:10px;
        text-align:center;
        width:98%;
        font-size:12px;
    }
</style>
<body>
<div id="navi">
    <div id='naviDiv'>
        <span><img src="${pageContext.request.contextPath }/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;教师管理<span/>&nbsp;
        <span><img src="${pageContext.request.contextPath }/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="${pageContext.request.contextPath }/teachers/query">教师列表</a><span/>&nbsp;
    </div>
</div>
<div id="tips">
    <div id="buttonGroup">
        <div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
            <a href="${pageContext.request.contextPath }/teachers/toAdd">添加教师</a>
        </div>
        <div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
            <a href="${pageContext.request.contextPath }/teachers/toFind">查找教师</a>
        </div>
    </div>
</div>
<div id="mainContainer">
    <!-- 从session中获取学生集合 -->
    <c:if test="${!empty teachersList }">
        <table class="default" width="100%">
            <col width="10%">
            <col width="10%">
            <col width="10%">
            <col width="22%">
            <col width="18%">
            <col width="15%">
            <col width="10%">
            <tr class="title">
                <td>工号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>出生日期</td>
                <td>身份证号</td>
                <td>地址</td>
                <td>操作</td>
            </tr>

            <!-- 遍历开始 -->
            <c:forEach items="${teachersList }" var="stu">
                <tr class="list">
                    <td>${stu.tid }</td>
                    <td><a href="${pageContext.request.contextPath }/teachers/toModify?tid=${stu.tid }" >${stu.tname }</a></td>
                    <td>${stu.gender }</td>
                    <td><input type="text" value="${stu.birthday }" pattern="yyyy-MM-dd HH:mm:ss" />
                    </td>
                    <td style="width: 20px;"><input type="text" value="${stu.IDNumber}" ></td>
                    <td>${stu.address}</td>
                    <td><a href="${pageContext.request.contextPath }/teachers/delete?tid=${stu.tid }" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
                </tr>
            </c:forEach>
            <!-- 遍历结束 -->
        </table>
    </c:if>
</div>
</body>
</html>