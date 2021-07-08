CREATE TABLE tb_finantial_movement
(
	id SERIAL,
	invoice_number INTEGER NOT NULL,
	portion_number INTEGER NOT NULL,
	origin VARCHAR(60) NOT NULL,
	due_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	paid_date TIMESTAMP WITHOUT TIME ZONE,
	moment TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	description TEXT NOT NULL,
	value DECIMAL(10,2) NOT NULL,
	situation VARCHAR(60) NOT NULL,
	attachment_url TEXT,
	
	person_id BIGINT NOT NULL,
	financial_historic_id BIGINT NOT NULL,	
	user_id BIGINT NOT NULL,
	
	CONSTRAINT PK_id_tb_finantial_movement PRIMARY KEY(id),
	CONSTRAINT FK_id_tb_person FOREIGN KEY(person_id) REFERENCES tb_person(id),
	CONSTRAINT FK_id_tb_financial_historic FOREIGN KEY(financial_historic_id) REFERENCES tb_financial_historic(id),
	CONSTRAINT FK_id_tb_user FOREIGN KEY(user_id) REFERENCES tb_user(id)
);

INSERT INTO tb_finantial_movement VALUES (DEFAULT, 123456, 1, 'SINGLE', TIMESTAMP WITH TIME ZONE '2021-08-07T00:00:00.0Z', 
										  TIMESTAMP WITH TIME ZONE '2021-07-07T00:00:00.0Z', TIMESTAMP WITH TIME ZONE '2021-07-07T00:00:00.0Z',
										  'Pagamento teste', 52.00, 'PAID',null, 1, 2, 1);
