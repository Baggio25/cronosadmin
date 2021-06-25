CREATE TABLE tb_financial_account
(
	id SERIAL,
	description	VARCHAR(60) NOT NULL,
	balance NUMERIC(10,2) NOT NULL,
	bank BOOLEAN DEFAULT FALSE,
	number VARCHAR(20),
	digit VARCHAR(2),
	agency VARCHAR(20),
	digit_agency VARCHAR(2),
	bank_id BIGINT,	
	
	CONSTRAINT PK_id_tb_financial_account PRIMARY KEY(id),
	CONSTRAINT FK_id_tb_bank FOREIGN KEY(bank_id) REFERENCES tb_bank(id)
);

INSERT INTO tb_financial_account VALUES (DEFAULT, 'Caixa Geral', 0.0);
INSERT INTO tb_financial_account VALUES (DEFAULT, 'Conta Banco do Brasil 7894-1', 1200.0, true, '7894', '1', '123', '1', 1);
