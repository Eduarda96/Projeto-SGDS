<%@include file="cabecalho.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="divForm">
	<form name="formcadrhsetor" id="formCadastroSetor" action="cadastrarSetor"> 
	
		<p>
			<label for="nome" class="labelFormularioSetor">Nome:</label>
			<input type="texto" id="nome" class="inputFormularioSetor" required="required" name="nome">
		 </p>
		 
		<p>
			<label for="nome" class="labelFormularioSetor">Responsável:</label>
			<input type="text" id="nomeResponsavel" class="inputFormularioSetor" required="required" name="nomeResponsavel">
		 </p> 
		 
		 <p>
			<label for="nome" class="labelFormularioSetor">E-mail:</label>
			<input type="email" id="email" class="inputFormularioSetor" name="email">
		 </p>
		 		 
		 <p>		 
		 	<label for= "setores" class="labelFormularioSetor">Setores:</label>
		 	<select name="setores" class="inputFormularioSetor">
			 	<%= request.getAttribute("ativos") %>
		 	</select>
		 </p>
		
		 <p>
			<label for="decricao" class="labelFormularioSetor" id="labelDescricao" >Descrição:</label>
			<textarea rows="12" class="inputFormularioSetor">
			</textarea>
		 </p>
		 
		 <p class="submit">
		 	<label for="decricao" class="labelFormularioSetor" id="labelDescricao" ></label>
		 	<input type="submit" onclick="enviar(); "value="Enviar">
		 </p>

	</form>
</div>
<%@include file="rodape.jsp" %>