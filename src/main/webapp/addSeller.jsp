<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<meta charset="UTF-8">
<title>Add Seller</title>
</head>
<body>
	<form action="Control" method="POST">
		<table>
			<tr>
				<th>Имя</th>
				<th>Фамилия</th>
				<th></th>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="surname"></td>
				<td><button type="submit" name="doRequest" value="newSeller">Добавить</button></td>
			</tr>
		</table>
	</form>
</body>
</html>