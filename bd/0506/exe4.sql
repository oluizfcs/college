CREATE TABLE fabricante(
    codigo SERIAL PRIMARY KEY,
    cnpj VARCHAR(25),
    nome VARCHAR(45),
    cidade VARCHAR(45)
);

CREATE TABLE vinho(
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    tipo VARCHAR(30),
    data_producao DATE,
    codigo_fabricante INTEGER NOT NULL,
    FOREIGN KEY (codigo_fabricante) REFERENCES fabricante(codigo)
);

CREATE TABLE cliente(
    codigo SERIAL PRIMARY KEY,
    telefone VARCHAR(45),
    nome VARCHAR(45),
    cpf VARCHAR(11)
);

CREATE TABLE cliente_vinho(
    codigo_cliente INTEGER NOT NULL,
    codigo_vinho INTEGER NOT NULL,
    qtd_venda SMALLINT NOT NULL,
    data_venda DATE DEFAULT now(),
    valor_venda DECIMAL(10,2),
    FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo),
    FOREIGN KEY (codigo_Vinho) REFERENCES vinho
);
