<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="en">
<head>
	<title>add Item</title>
</head>
<body>
		<jsp:useBean id="sellerBean" class="com.alex.board.entity.Seller"></jsp:useBean>
		<jsp:useBean id="categoryBean" class="com.alex.board.entity.Category"></jsp:useBean>
		<c:set var="sellers" value="${sellerBean.getSellers() }"></c:set>
		<c:set var="categories" value="${categoryBean.getCategories() }"></c:set>

	<form method="POST" action="Control">
		<h3>Название товара</h3>
		<p><input type="text" name="name"></p>

		<h3>Цена</h3>
		<p><input type="number" min="1" max="1000000000" name="price"></p>

		<h3>Продавец <span><a href="addSeller.jsp">+</a></span></h3>
		<p>
			<select name="seller" >
				<c:forEach items="${sellers }" var="seller">
					<option value="${seller.id }">${seller.name } ${seller.surname }</option>
				</c:forEach>
			</select>
		</p>
		<h3>Категории<span><a href="addCategory.jsp">+</a></span></h3>
		<p>
			<select name="categories" multiple>
				<c:forEach items="${categories }" var="category">
					<option value="${category.id }">${category.name }</option>
				</c:forEach>
			</select>
		</p>
		<button type="submit" name="doRequest" value="newItem">Добавить</button> 
	</form>
</body>
</html>