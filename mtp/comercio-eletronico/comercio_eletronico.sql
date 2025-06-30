CREATE TABLE usuario (
	id serial UNIQUE NOT NULL PRIMARY KEY,
	nome varchar(45) NOT NULL,
	email varchar(50) UNIQUE NOT NULL,
	senha varchar(255) NOT NULL,
	admin boolean NOT NULL DEFAULT False
);

CREATE TABLE produto (
	id serial UNIQUE NOT NULL PRIMARY KEY,
	nome varchar(45) NOT NULL,
	descricao TEXT NOT NULL,
	preco numeric(10,2) NOT NULL,
	foto varchar(255)
);

CREATE TABLE endereco (
	id serial UNIQUE NOT NULL PRIMARY KEY,
	idUsuario integer NOT NULL,
        identificador varchar(20) NOT NULL,
	estado varchar(2) NOT NULL,
	cidade varchar(45) NOT NULL,
	bairro varchar(45) NOT NULL,
	rua varchar(45) NOT NULL,
	numero varchar(10) NOT NULL,
	complemento varchar(45),
	FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);

CREATE TABLE pedido (
	id serial UNIQUE NOT NULL PRIMARY KEY,
	idUsuario integer NOT NULL,
	idEndereco integer,
	valorTotal numeric(15,2) NOT NULL DEFAULT 0,
	idStatus integer NOT NULL,
	FOREIGN KEY (idUsuario) REFERENCES usuario(id),
	FOREIGN KEY (idEndereco) REFERENCES endereco(id)
);

CREATE TABLE pedido_produto (
	idPedido integer NOT NULL,
	idProduto integer NOT NULL,
	quantidade integer NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES pedido(id),
	FOREIGN KEY (idProduto) REFERENCES produto(id)
);