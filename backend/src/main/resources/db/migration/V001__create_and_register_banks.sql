CREATE TABLE tb_bank
(
	id SERIAL,
	name VARCHAR(60) NOT NULL,
	number VARCHAR(3) NOT NULL,
	CONSTRAINT PK_id_tb_bank PRIMARY KEY(id)
);

INSERT INTO tb_bank VALUES (DEFAULT, 'Banco do Brasil', '001');
INSERT INTO tb_bank VALUES (DEFAULT, 'Caixa Econômica Federal', '104');