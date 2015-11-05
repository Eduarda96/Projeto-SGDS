<%@include file="cabecalho.jsp" %>
<div id="main">
	<div id="divForm">
		<form name="formcadrhsetor" id="formCadastroSetor" action="ControleSetor" method="post"> 
			<input type="hidden" id="acao" name="acao" value="cadastrar">
			<p>
				<label for="nome" class="labelFormularioSetor">Nome:</label>
				<input type="text" id="nome" class="inputFormularioSetor" required="required" name="nome">
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
				<textarea rows="12" class="inputFormularioSetor" name="descricao">
				</textarea>
			 </p>
			 
			 <p class="submit">
			 	<label for="decricao" class="labelFormularioSetor" id="labelDescricao" ></label>
			 	<input type="submit" onclick="enviar(); "value="Enviar">
			 </p>
	
		</form>
	</div>
</div>
<%@include file="rodape.jsp" %>