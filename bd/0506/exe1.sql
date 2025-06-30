CREATE TABLE departamento(
	codigo SERIAL PRIMARY KEY,
	nome VARCHAR(45),
	telefone VARCHAR(45),
	descricao TEXT
);

CREATE TABLE funcionario (
	codigo SERIAL PRIMARY KEY,
	cpf VARCHAR(11),
	cnpj VARCHAR(30),
	cargaHoraria INTEGER,
	nome VARCHAR(45),
	dataIngresso DATE,
	cidade VARCHAR(45),
	bairro VARCHAR(60),
	rua VARCHAR(45),
	numero VARCHAR(15),
	codigoDepartamento INTEGER,
	FOREIGN KEY (codigoDepartamento) REFERENCES departamento(codigo)
);

CREATE TABLE telefone(
	codigo SERIAL PRIMARY KEY,
	numero VARCHAR(45),
	codigoFuncionario INTEGER,
	FOREIGN KEY (codigoFuncionario) REFERENCES funcionario(codigo)
);
