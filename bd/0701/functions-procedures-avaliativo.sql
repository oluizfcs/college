-- Luiz Felipe de Castro Santana

-- 1. Cálculo de Desconto em Compras
CREATE TABLE compras(
    id SERIAL PRIMARY KEY,
    produto_id INT,
    quantidade INT,
    preco DECIMAL(12,2)
);

CREATE OR REPLACE FUNCTION calcular_preco_com_desconto(compra_id INT, percentual_desconto REAL)
RETURNS DECIMAL(12,2) AS $$
DECLARE
	preco_original DECIMAL(12,2);
	qtd INT;
	preco_final DECIMAL(12,2);
BEGIN
    SELECT preco INTO preco_original FROM compras WHERE id = compra_id; 
	SELECT quantidade INTO qtd FROM compras WHERE id = compra_id;

	preco_final := preco_original * qtd; 
	
    RETURN preco_final * ((100 - percentual_desconto) / 100);
END;
$$ LANGUAGE plpgsql;

-- Testando
INSERT INTO compras(produto_id, quantidade, preco) VALUES
(1, 1, 1000),
(2, 5, 2);

SELECT calcular_preco_com_desconto(1, 25);
SELECT calcular_preco_com_desconto(2, 10);

-- 2. Atualização de Salário
CREATE TABLE funcionarios(
	id INT PRIMARY KEY,
	nome VARCHAR(45),
	salario DECIMAL(12,2)
);

CREATE OR REPLACE PROCEDURE atualizar_salario(
	funcionario_id INT,
	percentual_aumento INT
)
LANGUAGE SQL
AS $$
	UPDATE funcionarios
	SET salario = (salario * (1 + (percentual_aumento/100.0)))
	WHERE id = funcionario_id;
$$

-- Testando
INSERT INTO funcionarios(id, nome, salario) VALUES
(1, 'luiz', 500),
(2, 'felipe', 1500);

CALL atualizar_salario(1, 10);
SELECT * FROM funcionarios;

-- 3. Verificação de Estoque
CREATE TABLE estoque(
	produto_id INT PRIMARY KEY,
	nome_produto VARCHAR(45),
	quantidade INT
);

CREATE OR REPLACE FUNCTION produto_em_estoque(id INT)
RETURNS BOOLEAN AS $$
DECLARE
	qtd INT;
BEGIN
	SELECT quantidade INTO qtd FROM estoque WHERE produto_id = id;
	IF qtd > 0 THEN
		RETURN true;
	ELSE
		RETURN false;
	END IF;
END
$$ LANGUAGE plpgsql;

-- Testando
INSERT INTO estoque(produto_id, nome_produto, quantidade) VALUES
(1, 'água', 2),
(2, 'pão', 0);

SELECT * FROM estoque;

SELECT produto_em_estoque(2);

-- 4. Cálculo de Média de Notas
CREATE TABLE notas(
	aluno_id INT,
	disciplina VARCHAR(45),
	nota DECIMAL(4,2)
);

CREATE OR REPLACE FUNCTION calcular_media_notas(id INT)
RETURNS DECIMAL(4,2) AS $$
DECLARE
	n INT;
	soma DECIMAL(4,2);
BEGIN
	SELECT COUNT(*) INTO n FROM notas WHERE aluno_id = id;
	SELECT SUM(nota) INTO soma FROM notas WHERE aluno_id = id;

	RETURN ROUND(soma / n, 2);
END
$$ LANGUAGE plpgsql;

-- Testando
INSERT INTO notas(aluno_id, disciplina, nota) VALUES
(1, 'banco de dados I', 7.24),
(1, 'banco de dados II', 9.9),
(2, 'banco de dados I', 8.1);

SELECT * FROM notas;
SELECT calcular_media_notas(1);

-- 5. Registro de Log de Atividade
CREATE TABLE log_atividades(
	usuario_id INT,
	atividade VARCHAR(45),
	timestamp TIMESTAMP
);

CREATE OR REPLACE PROCEDURE registrar_atividade_usuario(
	id INT,
	ativ VARCHAR(45)
) 
LANGUAGE SQL
AS $$
	INSERT INTO log_atividades(usuario_id, atividade, timestamp)
	VALUES (id, ativ, NOW());
$$

-- Testando
CALL registrar_atividade_usuario(1, 'teste');
SELECT * FROM log_atividades;

-- 6. Transferência de Fundos entre Contas
CREATE TABLE contas(
	id INT PRIMARY KEY,
	numero_conta INT,
	saldo DECIMAL(12,2) CHECK (saldo >= 0)
);

CREATE OR REPLACE PROCEDURE transferir_fundos(
	conta_origem INT,
	conta_destino INT,
	valor DECIMAL(12,2)
)
LANGUAGE SQL
AS $$
	UPDATE contas SET saldo = (saldo - valor) WHERE id = conta_origem;
	UPDATE contas SET saldo = (saldo + valor) WHERE id = conta_destino;
$$;

-- Testando
INSERT INTO contas(id, numero_conta, saldo) VALUES
(1, 1010, 2.50),
(2, 2020, 75);

CALL transferir_fundos(1, 2, 0.5);

SELECT * FROM contas;

-- 7. Calculadora de Juros Compostos
CREATE OR REPLACE FUNCTION calcular_juros_compostos(
	principal DECIMAL(12,2),
	taxa INT,
	periodos INT
) RETURNS DECIMAL(12,2) AS $$
DECLARE
	taxa_decimal DECIMAL(5,2) = taxa / 100.0;
BEGIN
	RETURN principal * POWER(1 + taxa_decimal, periodos);
END
$$ LANGUAGE plpgsql;

-- Testando
SELECT calcular_juros_compostos(10000, 10, 3);

-- 8. Arquivamento de Dados Antigos
CREATE TABLE tabela_principal(
	id INT PRIMARY KEY,
	dados VARCHAR(45),
	data_registro DATE
);

CREATE TABLE tabela_historico(
	id INT PRIMARY KEY,
	dados VARCHAR(45),
	data_registro DATE
);

CREATE OR REPLACE PROCEDURE arquivar_dados_antigos(data_limite DATE)
LANGUAGE SQL
AS $$
	INSERT INTO tabela_historico(id, dados, data_registro)
	(
		SELECT * FROM tabela_principal p
		WHERE p.data_registro <= p.data_registro
		AND p.id NOT IN (SELECT id FROM tabela_historico h WHERE h.id = p.id)
	);
$$;

-- Testando
INSERT INTO tabela_principal(id, dados, data_registro) VALUES
(1, 'bla', '2021-01-01'),
(2, 'blabla', '2022-02-02'),
(3, 'blablabla', '2023-03-03');

SELECT * FROM tabela_principal;
SELECT * FROM tabela_historico;

CALL arquivar_dados_antigos('2025-09-02');

-- 9. Relatório de Vendas
CREATE TABLE vendas(
	venda_id INT PRIMARY KEY,
	produto_id INT,
	valor DECIMAL(12,2),
	quantidade INT,
	data_venda DATE
);

CREATE OR REPLACE FUNCTION gerar_relatorio_vendas(data_inicio DATE, data_fim DATE)
RETURNS DECIMAL(12,2) AS $$
BEGIN
	RETURN (
		SELECT SUM(valor * quantidade)
		FROM vendas
		WHERE data_venda >= data_inicio
		AND data_venda <= data_fim
	);
END
$$ LANGUAGE plpgsql

-- Testando
INSERT INTO vendas(venda_id, produto_id, valor, quantidade, data_venda)
VALUES
	(3, 3, 5, 1, '2024-01-01'),
	(1, 1, 10, 2, NOW()),
	(2, 5, 5, 3, NOW());
SELECT * FROM vendas;
SELECT gerar_relatorio_vendas('2023-01-01', '2025-01-01');
SELECT gerar_relatorio_vendas('2025-01-01', '2025-12-01');
SELECT gerar_relatorio_vendas('2023-01-01', '2025-12-01');

-- 10. Envio de Notificações
CREATE TABLE notificacoes(
	notificacao_id SERIAL PRIMARY KEY,
	usuario_id INT,
	mensagem TEXT,
	enviado_em timestamp
);

CREATE OR REPLACE PROCEDURE enviar_notificacao(id INT, msg TEXT)
LANGUAGE SQL
AS $$
	INSERT INTO notificacoes(usuario_id, mensagem, enviado_em)
	VALUES (id, msg, NOW());
$$

-- Testando
CALL enviar_notificacao(1, 'opa, bão?');
SELECT * FROM notificacoes;