-- Exercício 1 --

-- a) base de dados criada pela interface gráfica: Databases > Create > Database...

-- b)
CREATE TABLE pessoa(
	codigo_pessoa SERIAL PRIMARY KEY,
	nome VARCHAR(50)
);

-- c)
CREATE TABLE postagem(
	codigo_postagem SERIAL PRIMARY KEY,
	conteudo TEXT,
	codigo_pessoa INT NOT NULL,
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo_pessoa)
);

-- d)
CREATE TABLE comentario(
	codigo_comentario SERIAL PRIMARY KEY,
	conteudo TEXT,
	codigo_pessoa INT NOT NULL,
	postagem_comentada INT,
	comentario_respondido INT,
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo_pessoa),
	FOREIGN KEY (postagem_comentada) REFERENCES postagem(codigo_postagem),
	FOREIGN KEY (comentario_respondido) REFERENCES comentario(codigo_comentario)
);

-- e)
INSERT INTO pessoa(nome) VALUES
('Pedro'),
('Ana'),
('Gabriel');

-- f)
SELECT * FROM pessoa;

-- g)
INSERT INTO postagem(conteudo, codigo_pessoa)
VALUES ('Hoje eu acordei feliz =)', (SELECT codigo_pessoa FROM pessoa WHERE nome = 'Pedro'));

-- h)
SELECT * FROM postagem;

-- i)
SELECT pessoa.nome, postagem.conteudo
FROM pessoa, postagem
WHERE pessoa.codigo_pessoa = postagem.codigo_pessoa
AND pessoa.nome = 'Pedro'; -- retirar AND para mostrar mais de uma pessoa

-- j) decidi colocar os códigos diretamente só para não prolongar muito (como fiz na g))
INSERT INTO comentario(conteudo, codigo_pessoa, postagem_comentada)
VALUES ('O que houve para tanta felicidade?', 2, 1);

-- k)
SELECT * FROM postagem
WHERE codigo_postagem = 1;

SELECT * FROM comentario
WHERE codigo_comentario = 1;

-- l)
INSERT INTO comentario(conteudo, codigo_pessoa, postagem_comentada, comentario_respondido)
VALUES ('Hoje é aula de BD!', 1, 1, 1);

-- Exercício 2
