<%@include file="cabecalho.jsp" %>
<div id="main">
	<div id="tabela">
		<table border ="1">
			<tr>
				<th> Nome do Setor </th>
				<th> Nome do Responsável </th>
				<th> E-mail </th>
				<th> Editar </th>
			</tr>
			<%= request.getAttribute("lista") %>
		</table>
	</div>
</div>

<%@include file="rodape.jsp" %>