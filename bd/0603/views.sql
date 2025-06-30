CREATE TABLE categoria(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE produto(
    id SERIAL PRIMARY KEY,
    categoria_id INT REFERENCES categoria(id),
    descricao VARCHAR(45) NOT NULL,
    preco NUMERIC
);

CREATE TABLE cliente(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    endereco VARCHAR(50),
    telefone VARCHAR(20),
    status VARCHAR(10),
    limite_credito NUMERIC,
    tipo_pessoa CHAR(1)
);

CREATE TABLE pedido(
    id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES cliente(id),
    data TIMESTAMP WITHOUT TIME ZONE,
    situacao VARCHAR(20)
);
 
CREATE TABLE item_pedido(
    id SERIAL PRIMARY KEY,
    produto_id INT REFERENCES produto(id),
    pedido_id INT REFERENCES pedido(id),
    quantidade INT, 
    valor_unitario NUMERIC 
);

-- Crie INSERTS para popular estas tabelas acima, deixe propositalmente alguns clientes sem adquirir nenhum produto e alguns produtos que não foram adquiridos por ninguém. Lembre-se de utilizar aspas simples pois estou utilizando PostgreSQL

INSERT INTO categoria (nome) VALUES 
('Eletrônicos'),
('Roupas'),
('Alimentos');

INSERT INTO produto (categoria_id, descricao, preco) VALUES 
(1, 'Smartphone', 1500.00),
(1, 'Notebook', 3500.00),
(2, 'Camiseta', 50.00),
(2, 'Calça Jeans', 120.00),
(3, 'Arroz 5kg', 20.00),
(3, 'Feijão 1kg', 8.00), -- Produto que não será comprado
(1, 'Fone de Ouvido', 80.00); -- Produto que não será comprado

INSERT INTO cliente (nome, endereco, telefone, status, limite_credito, tipo_pessoa) VALUES 
('João Silva', 'Rua A, 123', '99999-0001', 'ativo', 1000.00, 'F'),
('Maria Oliveira', 'Rua B, 456', '99999-0002', 'ativo', 1500.00, 'F'),
('Empresa XYZ', 'Av. Central, 789', '99999-0003', 'ativo', 5000.00, 'J'),
('Carlos Souza', 'Rua D, 101', '99999-0004', 'inativo', 700.00, 'F'), -- Sem pedidos
('Ana Martins', 'Rua E, 202', '99999-0005', 'ativo', 300.00, 'F');    -- Sem pedidos

INSERT INTO pedido (cliente_id, data, situacao) VALUES 
(1, '2025-06-01 10:00:00', 'finalizado'),
(2, '2025-06-02 14:30:00', 'pendente'),
(3, '2025-04-03 09:00:00', 'finalizado');

INSERT INTO item_pedido (produto_id, pedido_id, quantidade, valor_unitario) VALUES 
(1, 1, 1, 1500.00),     -- Smartphone
(3, 1, 2, 50.00),       -- Camiseta
(4, 2, 1, 120.00),      -- Calça Jeans
(2, 3, 1, 3500.00),     -- Notebook
(5, 3, 3, 20.00);       -- Arroz 5kg

/* 1. Crie uma VIEW que liste os nomes
de clientes que já adquiriram produtos
e o nome dos produtos que ele já
adquiriu. Classifique por nome do
cliente e nome do produto. */
CREATE VIEW cliente_produto as SELECT cliente.nome cliente, produto.descricao produto
FROM cliente, produto, (SELECT cliente_id, produto_id 
						FROM pedido, item_pedido
						WHERE pedido.id = item_pedido.pedido_id) as cliente_produto
WHERE cliente_produto.cliente_id = cliente.id AND cliente_produto.produto_id = produto.id
ORDER BY cliente, produto;

SELECT * FROM cliente_produto;

/* 2. Crie uma VIEW que liste os
produtos que não foram adquiridos
por nenhum cliente. */
CREATE VIEW produtos_nao_adquiridos as
SELECT produto.id, categoria_id, descricao, preco FROM produto
LEFT OUTER JOIN item_pedido
ON produto.id = item_pedido.produto_id
WHERE pedido_id IS NULL;

SELECT * FROM produtos_nao_adquiridos;

/* 3. Crie uma VIEW que liste todos
os pedidos dos últimos 30 dias
(número, situação e data do
pedido e, também, código, nome
e quantidade adquirida dos
produtos), não importando a
data em que a consulta seja
feita. */
SELECT pedido.id, situacao, data, pedido_id codigo, produto.descricao nome, quantidade FROM pedido
INNER JOIN item_pedido
ON pedido.id = item_pedido.pedido_id
INNER JOIN produto
ON produto_id = produto.id
WHERE DATA > NOW() - interval '30 days';