<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livraria Petreca</title>
</head>
<body>

	<h1>Lista de Livros</h1>

<div>${sucesso }</div>
	<table>
	
		<tr>
			<td>Título</td>
			<td>Descricao</td>
			<td>Paginas</td>
		</tr>
		
		<c:forEach items="${produtos}" var="produto">
		
			<tr>
				<td>${produto.titulo }</td>
				<td>${produto.descricao }</td>
				<td>${produto.paginas }</td>
			</tr>
			
		</c:forEach>
		
		
		
	</table>


</body>
</html>