<%@include file="cabecalho.html" %>

<div id="tabela">
<table border ="1">
<tr>
<th> C�digo do Setor </th>
<th> Nome do Setor </th>
<th> Nome do Respons�vel </th>
<th> E-mail </th>
<th> Setor Respons�vel </th>
<th> Descri��o </th>
<th> Editar </th>
</tr>

<%= request.getAttribute("lista") %>

</div>


<%@include file="rodape.html" %>