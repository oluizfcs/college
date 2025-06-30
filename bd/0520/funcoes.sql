CREATE TABLE clientes(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(45),
	email VARCHAR(45) UNIQUE,
	idade SMALLINT CHECK(idade > 0),
	cidade VARCHAR(45)
);

SELECT * FROM clientes;

INSERT INTO clientes(nome, email, idade, cidade) VALUES
('Ana Silva', 'ana.silva@gmail.com', 22, 'São Paulo'),
('Bruno Souza', 'bruno_souza@hotmail.com', 34, 'Rio de Janeiro'),
('Carla Mendes', 'carlam@gmail.com', 28, 'Belo Horizonte'),
('Daniel Rocha', 'daniel.rocha@yahoo.com', 45, 'São Paulo'),
('Erica Lima', 'erica.lima@gmail.com', 31, 'Curitiba');

-- 1. Selecione os nomes e os e-mails de todos os clientes cadastrados.
SELECT nome, email FROM clientes;

-- 2. Liste todos os clientes que possuem idade entre 25 e 35 anos.
SELECT * FROM clientes WHERE idade BETWEEN 25 AND 35;

-- 3. Encontre os clientes cujo e-mail termina com ".com".
SELECT * FROM clientes WHERE email LIKE '%.com';
SELECT * FROM clientes WHERE email NOT LIKE '%gmail%';

-- 4. Liste os clientes cujo nome começa com a letra "A".
SELECT * FROM clientes WHERE nome LIKE 'A%';

-- 5. Encontre os clientes cuja cidade começa com "são”.
SELECT * FROM clientes WHERE cidade ILIKE 'são%';

-- 6. Mostre todos os clientes com idade maior que 30 anos.
SELECT * FROM clientes WHERE idade > 30;

-- 7. Liste os clientes que não moram em Curitiba.
SELECT * FROM clientes WHERE cidade NOT LIKE 'Curitiba';

-- 8. Liste os clientes com idade entre 25 e 40 anos e cujo nome termina com a letra "a".
SELECT * FROM clientes WHERE idade BETWEEN 25 AND 40 AND nome LIKE '%a';

/* 9. Encontre os clientes cuja cidade termina com "paulo" (sem diferenciar 
   maiúsculas e minúsculas) e que não tenham 22 anos de idade. */
SELECT * FROM clientes WHERE cidade ILIKE '%paulo' AND NOT idade = 22;
   
-- 10. Quantos clientes estão cadastrados na tabela?
SELECT COUNT(*) AS total_clientes_cadastrados FROM clientes;

-- 11. Qual é a idade média dos clientes?
SELECT ROUND(AVG(idade)) AS "Média de idade dos clientes" FROM clientes;

-- 12. Qual é a maior idade entre os clientes?
SELECT MAX(idade) AS "Idade do cliente mais velho" FROM clientes;
SELECT MIN(idade) AS "Idade do cliente mais novo" FROM clientes;

-- 13. Qual é a soma total das idades de todos os clientes?
SELECT SUM(idade) AS "Soma das idades dos clientes" FROM clientes;
