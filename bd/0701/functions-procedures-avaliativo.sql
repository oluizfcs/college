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
BEGIN
    SELECT preco INTO preco_original FROM compras WHERE id = compra_id; 
    
    RETURN preco_original * ((100 - percentual_desconto) / 100);
END;
$$ LANGUAGE plpgsql;

-- Testando
INSERT INTO compras(produto_id, quantidade, preco) VALUES (1, 1, 1000);
SELECT calcular_preco_com_desconto(1, 25);