CREATE TABLE cliente(
	codigo SERIAL PRIMARY KEY,
	telefone VARCHAR(30),
	nome VARCHAR(45) NOT NULL,
	endereco VARCHAR(255),
	cpf VARCHAR(11) UNIQUE NOT NULL
);

CREATE TABLE vendedor(
    codigo SERIAL PRIMARY KEY,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE veiculo(
    codigo SERIAL PRIMARY KEY,
    fabricante VARCHAR(45) NOT NULL,
    ano SMALLINT NOT NULL,
    modelo SMALLINT NOT NULL
);

CREATE TABLE cliente_veiculo_vendedor(
    codigo_cliente INTEGER NOT NULL,
    codigo_veiculo INTEGER NOT NULL,
    codigo_vendedor INTEGER NOT NULL,
    valor_venda DECIMAL(12,2) NOT NULL,
    data_venda DATE DEFAULT now(),
    FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo),
    FOREIGN KEY (codigo_veiculo) REFERENCES veiculo(codigo),
    FOREIGN KEY (codigo_vendedor) REFERENCES vendedor(codigo)
);
