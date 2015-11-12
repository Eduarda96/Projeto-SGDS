<%@include file="cabecalho.jsp" %>
<div id="main">
	<div id="divForm">
		<form name="formcadrhsetor" id="formCadastroSetor" action="ControleSetor" method="post"> 
			<input type="hidden" id="acao" name="acao" <% if (request.getAttribute("acao") == "visualizar") {%> value="listar" <% } else { %>value="cadastrar" <% } %>>
			<p>
				<label for="nome" class="labelFormularioSetor">Nome:</label>
				<input type="text" id="nome" class="inputFormularioSetor" required="required" name="nome" <% if (request.getAttribute("nome") != null) { %> value="<%= request.getAttribute("nome") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> disabled="disabled" <% } %>>
			 </p>
			 
			<p>
				<label for="nome" class="labelFormularioSetor">Responsável:</label>
				<input type="text" id="nomeResponsavel" class="inputFormularioSetor" required="required" name="nomeResponsavel" <% if (request.getAttribute("nomeResponsavel") != null) { %> value="<%= request.getAttribute("nomeResponsavel") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> disabled="disabled" <% } %>>
			 </p> 
			 
			 <p>
				<label for="nome" class="labelFormularioSetor">E-mail:</label>
				<input type="email" id="email" class="inputFormularioSetor" name="email" <% if (request.getAttribute("email") != null) { %> value="<%= request.getAttribute("email") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> disabled="disabled" <% } %>>
			 </p>
			 		 
			 <p>		 
			 	<label for= "setores" class="labelFormularioSetor">Setores:</label>
			 	<select name="setores" class="inputFormularioSetor" <% if (request.getAttribute("acao") == "visualizar") {%> disabled="disabled" <% } %>>
				 	<%= request.getAttribute("ativos") %>
			 	</select>
			 </p>
			
			 <p>
				<label for="decricao" class="labelFormularioSetor" id="labelDescricao" >Descrição:</label>
				<textarea rows="12" class="inputFormularioSetor" name="descricao" <% if (request.getAttribute("acao") == "visualizar") {%> disabled="disabled" <% } %>> <% if (request.getAttribute("descricao") != null) { out.print(request.getAttribute("descricao")); } %></textarea>
			 </p>
			 
			 <p class="submit">
			 	<label for="decricao" class="labelFormularioSetor" id="labelDescricao" ></label>
			 	<input type="submit" onclick="enviar(); " <% if (request.getAttribute("acao") == "visualizar") {%> value="Voltar" <% } else { %>value="Enviar" <% } %>>
			 	<% if (request.getAttribute("acao") == "selecao") {%>
			 		<label for="decricao" class="labelFormularioSetor" id="labelDescricao" ></label>
			 		<input type="reset" value="Limpar">
			 	<% } %>
			 </p>
	
		</form>
	</div>
</div>
<%@include file="rodape.jsp" %>