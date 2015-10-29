<%@include file="cabecalho.jsp" %>

<div>
	</div><h1>Um erro aconteceu.</h1>
	<hr>
	<h2>Erro: <%= request.getAttribute("erro")%></h2>
</div>

<%@include file="rodape.jsp" %>