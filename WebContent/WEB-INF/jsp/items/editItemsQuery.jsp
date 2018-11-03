<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询商品列表</title>
<script type="text/javascript">
function editItemsAllSubmit() {
	document.itemsForm.action="${pageContext.request.contextPath}/items/editItemsAllSubmit.action";
	document.itemsForm.submit;
}
function queryItems() {
	document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
	document.itemsForm.submit;
}
</script>
</head>
<body>
<form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
<%-- <form action="${pageContext.request.contextPath}/skin.action" method="post"> --%>
商品列表
<table width="100%" border="1">
<tr>

<td>商品名称</td>
<td>商品价格</td>
<td>生产日期</td>
<td>商品描述</td>
<td>操作</td>
</tr>
<c:forEach items="${items}" var="item" varStatus="status">
<tr>

<td><input name="itemsList[${status.index}].name" value="${item.name}"></td>
<td><input name="itemsList[${status.index}].price" value="${item.price}"></td>
<td><input name="itemsList[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td> 
<%-- <td>${item.createtime}</td> --%>
<td><input name="itemsList[${status.index}].detail" value="${item.detail}"></td>

</tr>
</c:forEach>
<tr>
<td>商品名称：<input name="itemsCustom.name"/></td>
<td><input type="submit" value="查询" onclick="queryItems()"/>
<input type="submit" value="批量修改提交" onclick="editItemsAllSubmit()"/>
</td>
</tr>
</table>
</form>




</body>
</html>