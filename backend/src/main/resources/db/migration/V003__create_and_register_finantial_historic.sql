CREATE TABLE tb_financial_historic
(
	id SERIAL,
	description	VARCHAR(60) NOT NULL,
	operation VARCHAR(15) NOT NULL,
	active BOOLEAN DEFAULT TRUE,
	
	financial_account_id BIGINT,	
	
	CONSTRAINT PK_id_tb_financial_historic PRIMARY KEY(id),
	CONSTRAINT FK_id_tb_financial_account FOREIGN KEY(financial_account_id) REFERENCES tb_financial_account(id)
);

INSERT INTO tb_financial_historic VALUES (DEFAULT, 'Recebimento de Matrículas', 'INCOME', true, 1);
INSERT INTO tb_financial_historic VALUES (DEFAULT, 'Depesas com Materias de Limpeza', 'EXPENSE', true, 1);
