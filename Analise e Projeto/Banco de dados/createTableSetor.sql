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