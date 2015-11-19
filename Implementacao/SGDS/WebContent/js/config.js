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
	location.href = 'ControleSetor?acao=consultarAlteracao&codigo='+codigo;
}

function visudeletar(codigo) {
	location.href = 'ControleSetor?acao=deletar&codigo='+codigo;
}