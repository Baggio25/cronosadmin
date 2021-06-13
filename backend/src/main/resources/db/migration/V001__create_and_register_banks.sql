CREATE TABLE tb_bank
(
	id SERIAL PRIMARY KEY,
	name VARCHAR(60) NOT NULL,
	number VARCHAR(3) NOT NULL	
);

INSERT INTO tb_bank VALUES (DEFAULT, 'Banco do Brasil', '001');
INSERT INTO tb_bank VALUES (DEFAULT, 'Caixa Econômica Federal', '104');