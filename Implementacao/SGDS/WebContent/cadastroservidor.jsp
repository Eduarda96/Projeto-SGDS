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
				<label for="nome" class="labelFormularioServidor">Nome da Mãe:</label>
				<input type="text" id="nomeDaMae" class="inputFormularioServidor" name="nomeDaMae" <% if (request.getAttribute("nomeDaMae") != null) { %> value="<%= request.getAttribute("nomeDaMae") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
			 </p> 
			 
			 <p>
				<label for="nome" class="labelFormularioServidor">Nome do Pai:</label>
				<input type="text" id="nomeDoPai" class="inputFormularioServidor" name="nomeDoPai" <% if (request.getAttribute("nomeDoPai") != null) { %> value="<%= request.getAttribute("nomeDoPai") %>" <% } if (request.getAttribute("acao") == "visualizar") {%> readonly="true" <% } %>>
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