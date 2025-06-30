-- Exercício 2

-- a)
CREATE TABLE padeiros(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    departamento VARCHAR(45),
    data_admissao DATE
);

CREATE TABLE auxiliares(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    departamento VARCHAR(45),
    data_admissao DATE
);

INSERT INTO padeiros(nome, departamento, data_admissao) VALUES
('Roberto Luna', 'Padeiro', '2015-01-01'),
('José Santiago', 'Padeiro', '2017-02-25');

INSERT INTO auxiliares(nome, departamento, data_admissao) VALUES
('Joaquim Borges', 'Auxiliar', '2019-01-01'),
('Antonio França', 'Auxiliar', '2018-03-25'),
('Emanuel Costa', 'Auxiliar', '2022-01-01');

-- b)
SELECT * FROM padeiros;
SELECT * FROM auxiliares;
-- Crie uma consulta que promova a
-- Padeiro todos os auxiliares que se
-- encontram na empresa antes de
-- 2020 adicionando os auxiliares
-- promovidos na tabela padeiro.
INSERT INTO padeiros (nome, departamento, data_admissao) 
(SELECT nome, departamento, data_admissao FROM auxiliares WHERE data_admissao < '2020-01-01');

-- UPDATE padeiros SET departamento = 'Padeiro'
-- WHERE departamento != 'Padeiro';