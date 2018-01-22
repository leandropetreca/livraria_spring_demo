<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livraria Petreca</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>


 <form action="/livraria_spring_demo/produtos" method="POST">

	<div>
		<label>Titulo</label>
		
		<input type="text" name="titulo"></input>
		<form:errors path="produto.titulo" cssClass="error" />
		
	</div>
		
	<div>
		<label>Descricao</label>
		
		<textarea rows="10" cols="20" name="descricao"></textarea>
		<form:errors path="produto.descricao" cssClass="error" />
	</div>
		
	<div>
		<label>Páginas</label>
		
		<input type="text" name="paginas"></input>
		<form:errors path="produto.paginas" cssClass="error" />
	</div>
	
	
	<div>
		<label>Data Lançamento</label>
		
		<input type="text" name="dataLancamento"></input>
		<form:errors path="produto.dataLancamento" cssClass="error" />
	</div>
	
	<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">	
		<div>
			<label>${tipoPreco}</label>
			<input type="text" name="precos[${status.index}].valor"></input>
			<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}"></input>
		</div>	
	</c:forEach> 


		
	<button type="submit">Cadastrar</button>
		
		
	
</form>
</body>
</html>