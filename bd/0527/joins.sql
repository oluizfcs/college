-- a)
CREATE TABLE clientes(
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    cidade VARCHAR(45)
);

CREATE TABLE pedidos(
    id_pedido INT UNIQUE NOT NULL,
    id_cliente INT,
    produto VARCHAR(45),
    quantidade INT,
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente)
);

INSERT INTO clientes(nome, cidade) VALUES
('João Silva', 'São Paulo'),
('Maria Souza', 'Rio de Janeiro'),
('Carlos Lima', 'Belo Horizonte');

INSERT INTO pedidos(id_pedido, id_cliente, produto, quantidade)
VALUES
(101, 1, 'Notebook', 1),
(102, 2, 'Smartphone', 2),
(103, 1, 'Monitor', 1),
(104, 3, 'Tablet', 1);

-- b)
SELECT * FROM clientes
INNER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

-- cliente sem pedido só pra testar
INSERT INTO clientes(nome, cidade) VALUES ('luiz', 'formosa');

-- c)
SELECT * FROM clientes
LEFT OUTER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

-- pedido sem cliente só para testar
INSERT INTO pedidos(id_pedido, produto, quantidade) VALUES (105, 'iPhone', 0);
-- d)
SELECT * FROM pedidos
LEFT OUTER JOIN clientes
ON pedidos.id_cliente = clientes.id_cliente;

-- e)
SELECT * FROM clientes
FULL OUTER JOIN pedidos
ON clientes.id_cliente = pedidos.id_cliente;

-- f)
SELECT * FROM pedidos
INNER JOIN clientes
ON pedidos.id_cliente = clientes.id_cliente
WHERE clientes.cidade = 'São Paulo';

-- f) alternativa
SELECT * FROM pedidos, clientes
WHERE pedidos.id_cliente = clientes.id_cliente
AND clientes.cidade = 'São Paulo';
