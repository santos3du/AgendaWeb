<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<!--Pulling Awesome Font -->
<!--  Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<c:import url="cabecalho.jsp" />
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>Bem Vindo</h4>
            <form id="formLogin" name="formLogin" action="/login" method="post">
            <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="usuario" name="usuario"/>
            <br/>
            <input type="password" name="senha" id="userPassword" class="form-control input-sm chat-input" placeholder="senha" />
            <br/>
            <div class="wrapper">
            <span class="group-btn">     
                <a href="#" class="btn btn-primary btn-md">Logar<i class="fa fa-sign-in"></i></a>
            </span>
            </div>
            </form>
            </div>
        
        </div>
    </div>
</div>


<c:import url="rodape.jsp" />
</body>
</html>