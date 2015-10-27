<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp" %>
<div id="tabela">
<table border ="1">
<tr>
	<th> Nome do Setor </th>
	<th> Nome do Responsável </th>
	<th> E-mail </th>
	<th> Editar </th>
	</th>
</tr>
<%= request.getAttribute("lista") %>
</div>
<%@include file="rodape.jsp" %>