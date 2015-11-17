/**
 * 
 */

function mostrar(mensagem) {
	alert(mensagem);
}

function visuvoltar() {
	location.href = 'ControleSetor?acao=listar';
}

function visualterar(codigo) {
	//location.href = 'ControleSetor?acao=alterar&codigo='+codigo;
	var formulario = document.getElementById(codigo);
	var page = "cadastrosetor.jsp?acao=alterar";
	//document.getElementById("acao").value = "alterar";
	for (i = 1; i<formulario.length; i++) {
		page = page + "&" + formulario[i].name + "=" + formulario[i].value;
		//formulario[i].disabled= false;
	}
	location.href = page;
	//return true;
}

function visudeletar(codigo) {
	location.href = 'ControleSetor?acao=deletar&codigo='+codigo;
}