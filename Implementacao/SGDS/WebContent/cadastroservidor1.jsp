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
				<label for="nome" class="labelFormularioServidor">Nome:</label>
				<input type="text" id="nome" class="inputFormularioServidor" required="required" name="nome" <% if (request.getAttribute("nome") != null) { %> value="<%= request.getAttribute("nome") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>		 
			 		 
			 <p>
				<label for="nome" class="labelFormularioServidor">Matrícula SIAPE:</label>
				<input type="text" id="matriculaSIAPE" class="inputFormularioServidor" required="required" name="matriculaSIAPE" <% if (request.getAttribute("matriculaSIAPE") != null) { %> value="<%= request.getAttribute("matriculaSIAPE") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>
			
			<p>
				<label for="nome" class="labelFormularioServidor">Senha:</label>
				<input type="text" id="senha" class="inputFormularioServidor" required="required" name="senha" <% if (request.getAttribute("senha") != null) { %> value="<%= request.getAttribute("senha") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>
			 
			 <p>
				<label for="email" class="labelFormularioServidor">E-mail:</label>
				<input type="email" id="email" class="inputFormularioServidor" required="required" name="email" <% if (request.getAttribute("email") != null) { %> value="<%= request.getAttribute("email") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>
			 
			  <p>
				<label for="nome" class="labelFormularioServidor">Perfil:</label>
				<input type="nome" id="perfil" class="inputFormularioServidor" required="required" name="perfil" <% if (request.getAttribute("perfil") != null) { %> value="<%= request.getAttribute("perfil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>			 		 
						 
			 <p class="submit">
			 	<input type="button" onclick="visuvoltar(); " value="Voltar"> 
			 	<label for="alterar" class="labelFormularioServidor" id="labelDescricao" ></label>
			 	<% if (acao == "visualizar") { %> 
			 		<label for="submit" class="labelFormularioServidor" id="labelDescricao" ></label>
			 		<input type="button" onclick="visualterar(<%= cod %>); " value="Alterar">
			 		<label for="excluir" class="labelFormularioServidor" id="labelDescricao" ></label>
			 		<input type="button" onclick="visudeletar(<%= cod %>);" value="Excluir">
			 	<% } else { %>
			 		<label for="submit" class="labelFormularioServidor" id="labelDescricao" ></label>
			 		<input type="submit" onclick="return valid('formcadrhsetor'); " value="Enviar">
			 	<% } %>
			  	<% if (acao == "selecao") {%>
			 		<label for="decricao" class="labelFormularioServidor" id="labelDescricao" ></label>
			 		<input type="reset" value="Limpar">
			 	<% } %>
			 </p>
		</form>
	</div>
</div>
<%@include file="rodape.jsp" %>