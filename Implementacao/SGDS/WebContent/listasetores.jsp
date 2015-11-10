<%@include file="cabecalho.jsp" %>
<div id="main">
		<form id="formListaSetor" action="">
			<textfield>		
				<p>
				Pesquisa: 
				<input id="filtroSetor" class="" name="filtroSetor">			
				<input type="radio" class="radioButton" name="filtro" value="setor" />
				Setor
	            <input type="radio" class="radioButton" name="filtro" value="responsavel" />
	            Responsavel
	            <input id="botaoListaSetor" type="submit" value="Listar" />
	            </p>
			</textfield>
		 
		</form>

	<div id="tabela">
		<table border ="1">
			<tr>
				<th> Nome do Setor </th>
				<th> Setor Responsavel </th>
				<th> Nome do Responsável </th>
				<th> E-mail </th>
				<th> Editar </th>
			</tr>
			<%= request.getAttribute("lista") %>
		</table>
	</div>
</div>

<%@include file="rodape.jsp" %>