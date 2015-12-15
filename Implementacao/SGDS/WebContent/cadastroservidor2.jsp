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
				<label for="nome" class="labelFormularioServidor">Nome da Mãe:</label>
				<input type="text" id="nomeDaMae" class="inputFormularioServidor" name="nomeDaMae" <% if (request.getAttribute("nomeDaMae") != null) { %> value="<%= request.getAttribute("nomeDaMae") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p> 
			 
			 <p>
				<label for="nome" class="labelFormularioServidor">Nome do Pai:</label>
				<input type="text" id="nomeDoPai" class="inputFormularioServidor" name="nomeDoPai" <% if (request.getAttribute("nomeDoPai") != null) { %> value="<%= request.getAttribute("nomeDoPai") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>
		
			 
			 <p>
				<label for="nome" class="labelFormularioServidor">Sexo:</label>
				<input type="radio" id="sexo" class="radioButton" name="sexo" value="masculino"> Masculino <% if (request.getAttribute("sexo") != null) { %> value="<%= request.getAttribute("sexo") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
				<input type="radio" id="sexo" class="radioButton" name="sexo" value="feminino"> Feminino  <% if (request.getAttribute("sexo") != null) { %> value="<%= request.getAttribute("sexo") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
				<input type="radio" id="sexo" class="radioButton" name="sexo" value="outros"> Outros  <% if (request.getAttribute("sexo") != null) { %> value="<%= request.getAttribute("sexo") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
			 </p>
			 
			  <p>
				<label for="nome" class="labelFormularioServidor">Data de Nascimento:</label>
				<input type="nome" id="dataDeNascimento" class="inputFormularioServidor" name="dataDeNascimento" <% if (request.getAttribute("dataDeNascimento") != null) { %> value="<%= request.getAttribute("dataDeNascimento") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p>
			 
			 <p>
				<label for="nome" class="labelFormularioServidor">Estado Civil:</label>
				<form>
				<select name ="estadocivil"> <option value="solteiro">Solteiro(a)<% if (request.getAttribute("estadoCivil") != null) { %> value="<%= request.getAttribute("estadoCivil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
				<option value="casado">Casado(a) <% if (request.getAttribute("estadoCivil") != null) { %> value="<%= request.getAttribute("estadoCivil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
				<option value="viuvo">Viúvo(a) <% if (request.getAttribute("estadoCivil") != null) { %> value="<%= request.getAttribute("estadoCivil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
			 	<option value="separado">Separado(a)<% if (request.getAttribute("estadoCivil") != null) { %> value="<%= request.getAttribute("estadoCivil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
			 	<option value="divorciado">Divorciado(a)<% if (request.getAttribute("estadoCivil") != null) { %> value="<%= request.getAttribute("estadoCivil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
				<option value="uniaoEstavel">União Estável<% if (request.getAttribute("estadoCivil") != null) { %> value="<%= request.getAttribute("estadoCivil") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>
			 	</select>
			 	</form>
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