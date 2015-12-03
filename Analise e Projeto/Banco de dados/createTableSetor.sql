CREATE database sgds_banco;

USE sgds_banco;

CREATE USER 'usersgds'@'localhost' IDENTIFIED BY 'bundamole';

GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE, SHOW VIEW ON sgds_banco.* TO 'usersgds'@'localhost';

CREATE table SETOR(
	codSetor int unsigned NOT NULL auto_increment,
	nome varchar (50) NOT NULL,
	nomeResponsavel varchar (100) NOT NULL,
	setorResponsavel int unsigned,
	descricao text NOT NULL,
	email varchar (50) NOT NULL,
	ativo boolean,
	primary key(codSetor)
);

CREATE table SERVIDOR(
	codServidor int unsigned NOT NULL auto_increment,
	nome varchar (100) NOT NULL,
	nomeMae varchar (100),
	nomePai varchar (100),
	matriculaSiape int (7) NOT NULL,
    senha varchar (256) NOT NULL,
    perfil text NOT NULL,
    sexo varchar (9),
    dataNascimento date,
	emailInstitucional varchar (50),
    estadoCivil varchar (15),
    endereco varchar (100),
    numeroComplemento varchar (50),
    bairro varchar (50),
    cep varchar (9),
    cidade varchar (25),
    estado varchar (25),
    telefoneResidencial varchar (14),
	telefoneCelular varchar (14),
    naturalidade varchar (25),
    uf varchar (2),
    nacionalidade varchar (25),
    escolaridade varchar (25),
    tipoSanguineoFatorRh varchar (3),
    cpf varchar (14),
    rg varchar (15),
    orgaoExpeditor varchar (10),
    ufRg varchar (2),
    dataExpedicao date,
    tituloEleitor varchar (15),
    ufTitulo varchar (2),
    zona varchar (3),
    sessao varchar (4),
    dataEmissaoTitulo date,
    documentoMilitar varchar (25),
    serie varchar (1),
    orgaoExpeditorMilitar varchar (10),
	carteiraTrabalho varchar(50),
    serieCarteira varchar (25),
    UFCarteira varchar (2),
    pisPasep varchar (11),
    dataPrimeiroEmprego date,
    bancoContaBancaria varchar (50),
    agencia varchar (15),
    numero varchar (15),
    motorista tinyint,
    cnh varchar (11) ,
    status tinyint ,
    formacaoExedente varchar (25) ,
    formacaoExedente2 varchar (25),
    informacoesComplementares text,
	primary key(codServidor)
);