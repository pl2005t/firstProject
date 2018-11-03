<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改信息</title>
<link
	href="${pageContext.request.contextPath}/resource/style/amazeui.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resource/style/highcharts.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resource/style/style.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resource/style/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/highcharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/amazeui.min.js"></script>
</head>
<body>
<!-- 显示错误信息 -->
<c:if test="${allErrors!=null }">
<c:forEach items="${ allErrors}" var="error">
${error.defaultMessage}<br/>
</c:forEach>
</c:if>
<form action="${pageContext.request.contextPath}/items/editItemsSubmit.action" id="itemForm" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${itemsCustom.id}"/>
修改商品信息
<table width="100%" border="1">
<tr>
<td>商品名称</td>
<td><input type="text" name="name" value="${itemsCustom.name}"/></td>
</tr>
<tr>
<td>商品价格</td>
<td><input type="text" name="price" value="${itemsCustom.price}"/></td>
</tr>
<tr>
<td>商品说明</td>
<td><textarea rows="3" cols="30" name="detail">${itemsCustom.detail}</textarea></td>
</tr>
<tr>
<td>生产日期</td>
<td> 
 <input type="text" name="createtime"  value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/> 
</td>
</tr>
<tr>
<td>商品图片</td>
<td>
<c:if test="${itemsCustom.pic!=null}">
<img src="/pic/${itemsCustom.pic}" width=100 height=100>
<br/>
</c:if>
<input type="file" name="items_pic"/>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"></td>
</tr>
</table>
</form>
</body>
</html>