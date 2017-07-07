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
    <script></script>
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border:1;
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
	margin-top:20px;
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
	text-align:left;
	width:98%;
	font-size:16px;
}
</style>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/laydate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>


<div id="navi">
	<div id='naviDiv'>
      <span><img src="${pageContext.request.contextPath }/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生管理<span>&nbsp;</span>
      <span><img src="${pageContext.request.contextPath }/images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="${pageContext.request.contextPath }/students/query">学生列表</a><span>&nbsp;</span>
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>修改学生资料</strong>
<br>
<br>

<form name="modifyForm" action="${pageContext.request.contextPath }/students/update" method="post">
<table width="400" >
  <tr>
    <td width="30%">学号：</td>
    <td><input type="text" name="sid" value="${student.sid }"  readonly="readonly"/></td>
  </tr>
  <tr>
    <td width="30%">姓名：</td>
    <td><input type="text" name="sname" value="${student.sname }"/> </td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>
      <c:if test="${student.gender=='男' }">
         <input type="radio" name="gender" value="男" checked="checked"/> 男
         <input type="radio" name="gender" value="女"/>女
      </c:if>
      <c:if test="${student.gender=='女' }">
         <input type="radio" name="gender" value="男" />男
         <input type="radio" name="gender" value="女" checked="checked"/>女
      </c:if>
      </td>
  </tr>
  <tr>
    <td>出生日期：</td>
    <td><input name="birthday" type="text" id="control_date" size="25"
      maxlength="10"  readonly="readonly"   value="${student.birthday}"
               class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"/>
   <%--   <input name="birthday" type="datetime" id="control_date" size="25"
             maxlength="10"   value="${student.birthday}"
            />--%>


     
    </td>
  </tr>
  <tr>
    <td>地址：</td>
    <td><input type="text" name="address" value="${student.address }"/> </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
  </tr>
</table>
</form>
</div>
</body>
</html>