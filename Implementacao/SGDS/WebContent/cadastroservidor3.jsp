<%@include file="cabecalho.jsp" %>
<%
	int cod = 0;	
	String acao = (String) request.getAttribute("acao");
	if (request.getAttribute("codigo") != null)
		cod = Integer.parseInt(""+request.getAttribute("codigo"));
%>
<div id="main">
	<div id="divForm">
		<form name="formcadrhservidor" id="formCadastroServidor" action="ControleServidor" method="post"> 
			<input type="hidden" id="acao" name="acao" value="<%= acao %>">
			<input type="hidden" id="codigo" name="codigo" value="<%= cod %>"> 
			<script>alert(<%= request.getAttribute("acao")%>);</script>
			<p>
				<label for="nome" class="labelFormularioServidor">Endereço:</label>
				<input type="nome" id="endereco" class="inputFormularioServidor" name="endereco" <% if (request.getAttribute("endereco") != null) { %> value="<%= request.getAttribute("endereco") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			</p>
			 
			<p>
				<label for="nome" class="labelFormularioServidor">Numero/Complemento:</label>
				<input type="nome" id="numeroComplemento" class="inputFormularioServidor" name="numeroComplemento" <% if (request.getAttribute("numeroComplemento") != null) { %> value="<%= request.getAttribute("numeroComplemento") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			</p>
			 
			<p>
				<label for="nome" class="labelFormularioServidor">Bairro:</label>
				<input type="nome" id="bairro" class="inputFormularioServidor" name="bairro" <% if (request.getAttribute("bairro") != null) { %> value="<%= request.getAttribute("bairro") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			</p>
			 
			<p>
				<label for="nome" class="labelFormularioServidor">CEP:</label>
				<input type="nome" id="cep" class="inputFormularioServidor" name="cep" <% if (request.getAttribute("cep") != null) { %> value="<%= request.getAttribute("cep") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			</p>
			 
			<p>
				<label for="nome" class="labelFormularioServidor">Cidade:</label>
				<input type="nome" id="cidade" class="inputFormularioServidor" name="cidade" <% if (request.getAttribute("cidade") != null) { %> value="<%= request.getAttribute("cidade") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			</p>
			 
			<p>
				<label for="nome" class="labelFormularioServidor">Estado:</label>
				<input type="nome" id="estado" class="inputFormularioServidor" name="estado" <% if (request.getAttribute("estado") != null) { %> value="<%= request.getAttribute("estado") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			</p>
			 
			 <p>
				<label for="nome" class="labelFormularioServidor">Telefone Residencial:</label>
				<input type="nome" id="telefoneResidencial" class="inputFormularioServidor" name="telefoneResidencial" <% if (request.getAttribute("telefoneResidencial") != null) { %> value="<%= request.getAttribute("telefoneResidencial") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>
			 
			 <p>
				<label for="nome" class="labelFormularioServidor">Telefone Celular:</label>
				<input type="nome" id="telefoneCelular" class="inputFormularioServidor" name="telefoneCelular" <% if (request.getAttribute("telefoneCelular") != null) { %> value="<%= request.getAttribute("telefoneCelular") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>	 
			 
			 <p class="submit">
			 	<input type="button" class="tresbotoes" onclick="visuvoltar(); " value="Voltar"> 
			 	<% if (acao == "visualizar") { %> 
			 		<input type="button" class="tresbotoes" onclick="visualterar(<%= cod %>); " value="Alterar">
			 		<input type="button" class="tresbotoes" onclick="visudeletar(<%= cod %>);" value="Excluir">
			 	<% } else { %>
			 		<input type="submit" class="tresbotoes" onclick="return valid('formcadrhsetor'); " value="Concluir">
			 	<% } %>
			  	<% if (acao == "selecao") {%>
			 		<input type="reset" class="tresbotoes" value="Limpar">
			 	<% } %>
			 </p>
		</form>
	</div>
</div>
<%@include file="rodape.jsp" %>