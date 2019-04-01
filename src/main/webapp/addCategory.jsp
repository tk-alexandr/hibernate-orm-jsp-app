<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<title>add category</title>
</head>
<body>
	<p>
		<form action="Control" method="POST">
			<table>
				<tr>
					<td>Название категории</td>
					<td><input type="text" name="name"></td>
					<td><button type="submit" name="doRequest" value="newCategory">Добавить</button> </td>
				</tr>
			</table>
		</form>
	</p>
</body>
</html>