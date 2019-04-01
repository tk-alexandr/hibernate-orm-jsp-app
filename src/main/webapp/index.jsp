<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="en">
<head>
	<title>Item list</title>
</head>
<body>
	<jsp:useBean id="itemBean" class="com.alex.board.entity.Item"></jsp:useBean>
	<c:set var="items" value="${itemBean.getItems()}"></c:set>
	<c:if test="${items.size() == '0' }"><p style="color: red;">Пока что не добавленно ниодного товара!</p></c:if>
	<style>
		td, th{
			border: 1px solid #000000;
			padding: 5px 10px;
		}
	</style>
	<h1>Товары</h1>
	<table>
		<tr>
			<th>№</th>
			<th>Название</th>
			<th>Цена (р.)</th>
			<th>Продавец</th>
			<th>Категории</th>
			<th>Удалить</th>
		</tr>
		<script type="text/javascript"> var rowNum = 0;</script>
		<c:forEach items="${items }" var="item">
		<tr>
			<td><script>document.write(++rowNum);</script></td>
			<td>${item.name }</td>
			<td>${item.price }</td>
			<td>${item.seller.name.substring(0, 1).toUpperCase() }. ${item.seller.surname }</td>
			<td>
			<ul>
				<c:forEach items="${item.categories }" var="category">
				<li>${category.name }</li>
				</c:forEach>
			</ul>
			</td>
			<td><a href="Control?doRequest=removeItemId&id=${item.id}">Удалить</a></td>
		</tr>
		</c:forEach>
	</table>
		<p>
			<a href="addItem.jsp">Добавить Товар</a>
		</p>
	<script src="action/script.js"></script>
</body>
</html>