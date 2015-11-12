<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/estilo.css">
<script type="text/javascript" src="js/config.js"></script>
<title>Main</title>
</head>
<body>
	<%
	String mensagem = (String) request.getAttribute("msg");
	if (mensagem != null) {
		%><script type="text/javascript">mostrar('<%= mensagem %>')</script><%
	}
	%>
	<div id="cabecalho">
		<header>
			<div id="header"></div>
			<nav>
				<ul class="menu">
					<li><a href="#">Servidor</a>
						<ul>
							<li><a href="#">Cadastrar</a></li>
						</ul></li>
					<li><a href="ControleSetor?acao=listar">Setor</a>
						<ul>
							<li><a href="ControleSetor?acao=selecao">Incluir</a></li>
							<li><a href="ControleSetor?acao=listar">Listar</a></li>
						</ul></li>
					<li><a href="#">Lista</a>
						<ul>
							<li><a href="#">Opção 1</a></li>
							<li><a href="#">Opção 2</a></li>
						</ul></li>
				</ul>
			</nav>
		</header>
	</div>