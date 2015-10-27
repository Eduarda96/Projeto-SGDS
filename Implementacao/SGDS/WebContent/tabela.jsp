<%@include file="cabecalho.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="tabela">
<table border ="1">
<tr>
<th> Código do Setor </th>
<th> Nome do Setor </th>
<th> Nome do Responsável </th>
<th> E-mail </th>
<th> Setor Responsável </th>
<th> Descrição </th>
<th> Editar </th>
</tr>
<%= request.getAttribute("lista") %>
</div>
<%@include file="rodape.jsp" %>