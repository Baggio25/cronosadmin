CREATE TABLE tb_person
(
	id SERIAL,
	name	  VARCHAR(60) NOT NULL,
	cpf_cnpj  VARCHAR(15),
	telephone VARCHAR(15),
	celular   VARCHAR(15),
	active    BOOLEAN DEFAULT TRUE,	
	
	CONSTRAINT PK_id_tb_person PRIMARY KEY(id)
);

INSERT INTO tb_person VALUES (DEFAULT, 'Rodrigo Baggio', '08125291970', null, null, true);
INSERT INTO tb_person VALUES (DEFAULT, 'Tânia Mara Mondardo Baggio', null, null, null, true);
INSERT INTO tb_person VALUES (DEFAULT, 'Analu Baggio', null, null, null, true);
INSERT INTO tb_person VALUES (DEFAULT, 'No Ponto Supermercados', null, null, null, true);

