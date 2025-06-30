CREATE TABLE usuario(
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    genero CHAR(1),
    username VARCHAR(45) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE postagem(
    codigo SERIAL PRIMARY KEY,
    conteudo TEXT,
    curtidas INTEGER DEFAULT 0,
    descurtidas INTEGER DEFAULT 0,
    qtd_comentarios INTEGER,
    data_postagem DATE DEFAULT now(),
    codigo_usuario INTEGER NOT NULL,
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);

CREATE TABLE comentario(
    codigo SERIAL PRIMARY KEY,
    conteudo TEXT,
    qtd_respostas INTEGER,
    data_comentario DATE DEFAULT now(),
    curtidas INTEGER DEFAULT 0,
    descurtidas INTEGER DEFAULT 0,
    codigo_usuario INT NOT NULL,
    codigo_postagem INT NOT NULL,
    codigo_comentario_resposta INT NOT NULL,
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
    FOREIGN KEY (codigo_postagem) REFERENCES postagem(codigo),
    FOREIGN KEY (codigo_comentario_resposta) REFERENCES comentario(codigo)
);
