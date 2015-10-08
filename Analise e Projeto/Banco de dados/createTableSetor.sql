CREATE table SETOR(
	id int unsigned NOT NULL auto_increment,
	nome varchar (50) NOT NULL,
	nomeResponsavel varchar (100) NOT NULL,
	setorResponsavel varchar (100) NOT NULL,
	descricao text NOT NULL,
	email varchar (50) NOT NULL,
	primary key(ID)
);