<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Adiciona Contato</title>
</head>

<body>
<c:import url="cabecalho.jsp" />
<h3>Adiciona Contato</h3>
<form action="adicionaContato" method="post">
	Nome:<input type="text" name="nome" /><br/>
	Email:<input type="text" name="email" /><br/>
	Endereço:<input type="text" name="endereco" /><br/>
	Data inclusão:<input type="text" name="dataNascimento" /><br/>
	<input type="submit" value="Adicionar"> 
</form>
<c:import url="rodape.jsp" />
</body>
</html>