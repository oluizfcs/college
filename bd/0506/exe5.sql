CREATE TABLE usuario(
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(45) NULL
);

CREATE TABLE grupo(
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    regras TEXT NULL,
    descricao TEXT NULL,
    data_criacao DATE DEFAULT now()
);

CREATE TABLE grupo_usuario(
    codigo_grupo INTEGER NOT NULL,
    codigo_usuario INTEGER NOT NULL,
    data_entrada TIMESTAMP DEFAULT now(),
    data_saida TIMESTAMP DEFAULT now(),
    FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo),
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);

CREATE TABLE mensagem(
    codigo SERIAL PRIMARY KEY,
    texto TEXT NOT NULL,
    data_envio TIMESTAMP DEFAULT now()
);

CREATE TABLE grupo_mensagem_usuario(
    codigo_grupo INTEGER NOT NULL,
    codigo_mensagem INTEGER NOT NULL,
    codigo_usuario INTEGER NOT NULL,
    FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo),
    FOREIGN KEY (codigo_mensagem) REFERENCES mensagem(codigo),
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);
