<%@include file="cabecalho.jsp" %>
<div id="main">
		<form id="formListaSetor" action="ControleSetor?acao=filtrar" method="post">
			<textfield>		
				<p>
				Pesquisa: 
				<input id="filtroSetor" class="text" name="filtroSetor">			
				<input type="radio" class="radioButton" name="selecao" value="nome" checked="checked"/>
				Setor
	            <input type="radio" class="radioButton" name="selecao" value="nomeResponsavel" />
	            Responsavel
	            <input id="botaoListaSetor" type="submit" value="Filtrar" />
	            </p>
			</textfield>		 
		</form>

	<div id="tabela">
		<table border ="1">
			<tr>
				<th> Nome do Setor </th>
				<th> Setor Responsavel </th>
				<th> Nome do Respons�vel </th>
				<th> E-mail </th>
				<th id="editar"> Editar </th>
			</tr>
			<%= request.getAttribute("lista") %>
		</table>
	</div>
</div>

<%@include file="rodape.jsp" %>