CREATE OR REPLACE FUNCTION voltar_ao_peso_ideal(peso NUMERIC(5,2), altura NUMERIC(3,2))
RETURNS NUMERIC AS $$
DECLARE
	imc NUMERIC(5,2) := peso / (altura*altura);
	peso_ideal_maximo NUMERIC(4,2) := 24.9;
	peso_ideal_minimo NUMERIC(4,2) := 18.5;
	peso_ideal NUMERIC(5,2) := 0;
BEGIN
	IF imc > peso_ideal_maximo THEN
		peso_ideal = altura * altura * peso_ideal_maximo;
	ELSIF imc < peso_ideal_minimo THEN
		peso_ideal = altura * altura * peso_ideal_minimo;
	ELSE
		RETURN 0;
	END IF;

	RETURN ROUND(peso_ideal - peso, 2);
END;
$$ LANGUAGE plpgsql;


CREATE TABLE pessoa(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(45),
	peso NUMERIC(5,2),
	altura NUMERIC(3,2)
);

-- Pessoas abaixo do peso
INSERT INTO pessoa (nome, peso, altura) VALUES
('Lucas Silva', 50.0, 1.80), -- IMC ~15.43
('Ana Oliveira', 45.0, 1.65), -- IMC ~16.53
('Beatriz Almeida', 42.0, 1.60), -- IMC ~16.41
('João Lima', 48.0, 1.85); -- IMC ~14.03

-- Pessoas com peso normal
INSERT INTO pessoa (nome, peso, altura) VALUES
('Carlos Souza', 70.0, 1.75), -- IMC ~22.86
('Juliana Costa', 60.0, 1.70), -- IMC ~20.76
('Mariana Costa', 65.0, 1.68), -- IMC ~23.06
('Gustavo Martins', 77.0, 1.80); -- IMC ~23.77

-- Pessoas acima do peso
INSERT INTO pessoa (nome, peso, altura) VALUES
('Fernanda Santos', 85.0, 1.60), -- IMC ~33.20
('Rafael Pereira', 95.0, 1.85), -- IMC ~27.78
('Roberta Menezes', 92.0, 1.60), -- IMC ~35.94
('Eduardo Silva', 100.0, 1.75); -- IMC ~32.65


SELECT nome, voltar_ao_peso_ideal(peso, altura) FROM pessoa;
