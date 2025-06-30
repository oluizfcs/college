CREATE TABLE autor(
	codigo SERIAL PRIMARY KEY,
	nome VARCHAR(45)
);

CREATE TABLE livro(
	codigo SERIAL PRIMARY KEY,
	titulo VARCHAR(45),
	ano_lancamento SMALLINT,
	edicao INTEGER,
	descricao TEXT,
	codigo_autor INTEGER,
	FOREIGN KEY (codigo_autor) REFERENCES autor(codigo)
);

CREATE TABLE cliente(
	codigo SERIAL PRIMARY KEY,
	nome VARCHAR(45),
	identidade VARCHAR(25),
	telefone VARCHAR(45)
);

CREATE TABLE cliente_livro(
	codigo_cliente INTEGER,
	codigo_livro INTEGER,
	data_compra DATE,
	valor_compra DECIMAL(12,2),
	PRIMARY KEY (codigo_cliente, codigo_livro),
	FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo),
	FOREIGN KEY (codigo_livro) REFERENCES livro(codigo)
);
