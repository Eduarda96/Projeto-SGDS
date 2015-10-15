<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrs.restinga.sgds.modelo.Setor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Setor</title>
</head>
<body>
	<div>
		<form name="formcadrhsetor" action="TestaCadastroSetor">

			<p class="nome">
				<label for="nome">Nome:</label> <input type="texto" id="nome"
					required="required" name="nome">
			</p>

			<p class="nomeResponsavel">
				<label for="nome">Nome do Responsável:</label> <input type="texto"
					id="nomeResponsavel" required="required" name="nomeResponsavel">
			</p>



			<p class="email">
				<label for="nome">E-mail:</label> <input type="email" id="email"
					name="email">
			</p>

			<p>
				<label for="setores">Setores:</label>
				<select name="setores">
					<%
						List<Setor> ativos = new ArrayList<Setor>();
						ativos = (List)request.getAttribute("ativos");
						for(Setor setor : ativos) {
							%><option value="<%= setor.getCodSetor()%>"><%= setor.getNome()%></option><%
						}
					%>
					<!-- aqui irão os setores cadastrados -->
				</select>
			</p>

			<p class="descricao">
				<label for="nome">Descrição:</label></br>
				<textarea maxlength="300" id="descricao" name="descricao">
			</textarea>
			</p>

			<p class="submit">
				<input type="submit" onclick="enviar(); " value="Enviar">
			</p>

		</form>
	</div>
</body>
</html>