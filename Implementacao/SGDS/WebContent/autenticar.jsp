<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/estilo.css">
<script type="text/javascript" src="./js/config.js"></script>
<title>Login</title>
</head>
<body>
	<% String mensagem = (String) request.getAttribute("msg");
	 	if (mensagem	!= null) { %>
			<script type="text/javascript">mostrar('<%=mensagem%>')</script>
		<% }
	%>
	<div id="formLogin">
		<div id="loginBanner"></div>
		<form id="formularioLogin" name="form_login"
			action="AutenticarUsuario" method="post">
			<fieldset id="campoLogin">
				<p class="usuario">
					<label for="usuario" class="labelLogin">Usuário:</label> <input
						type="text" id="usuario" class="formularioLogin"
						required="required" name="usuario">
				</p>
				<p class="senha">
					<label for="senha" class="labelLogin">Senha:</label> <input
						type="password" id="senha" class="formularioLogin"
						required="required" name="senha">
				</p>
				<p class="submit">
					<a href="#">Esqueci minha senha</a> <input type="submit"
						id="botaoLogar" class="formularioLogin" onclick="enviar();"
						value="Entrar">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>