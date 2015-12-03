function mostrar(mensagem) {
	alert(mensagem);
}

function visuvoltar() {
	location.href = 'ControleSetor?acao=listar';
}

function visualterar(codigo) {
	location.href = 'ControleSetor?acao=consultarAlteracao&codigo=' + codigo;
}

function visudeletar(codigo) {
	location.href = 'ControleSetor?acao=deletar&codigo=' + codigo;
}

function valid(formulario) {
	var retorno = true;
	// \w casa letras, digitos e _
	for (i = 0; i < formulario.length; i++) {
		formulario[i].className = "";
		switch (formulario[i].name) {
		case 'email':
			var regexEmail = /^\w+([-\.]\w+)*@\w+([-.]\w+)+$/;
			if (!formulario[i].value.match(regexEmail)) {
				formulario[i].className = "campoErro";
				retorno = false;
			}
			break;
		}
		return retorno;
	}
}