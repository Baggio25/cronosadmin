CREATE TABLE tb_role (
	id  SERIAL NOT NULL, 
	authority VARCHAR(60) NOT NULL,
	
	CONSTRAINT PK_id_tb_role PRIMARY KEY(id)
);

CREATE TABLE tb_user_group (
	id  SERIAL NOT NULL, 
	name VARCHAR(60) NOT NULL,
	active BOOLEAN DEFAULT TRUE,	
	
	CONSTRAINT PK_id_tb_user_group PRIMARY KEY(id)
);

CREATE TABLE tb_user (
	id  SERIAL NOT NULL, 
	email VARCHAR(100) NOT NULL, 
	name VARCHAR(60) NOT NULL, 
	password VARCHAR(80) NOT NULL, 
	active    BOOLEAN DEFAULT TRUE,	 
	
	user_group_id BIGINT NOT NULL,
	
	CONSTRAINT PK_id_tb_user PRIMARY KEY(id),
	CONSTRAINT FK_id_tb_user_group FOREIGN KEY(user_group_id) REFERENCES tb_user_group(id)
);


CREATE TABLE tb_user_group_role (
	user_group_id INTEGER NOT NULL, 
	role_id       INTEGER NOT NULL, 
	
	CONSTRAINT PK_id_tb_user_group_role PRIMARY KEY (user_group_id, role_id),
	CONSTRAINT FK_id_tb_role FOREIGN KEY(role_id) REFERENCES tb_role(id),
	CONSTRAINT FK_id_tb_group_id FOREIGN KEY(user_group_id) REFERENCES tb_user_group(id)	
);

INSERT INTO tb_user_group (id, name) 
			 VALUES (DEFAULT, 'ADMINISTRADOR');
			 
INSERT INTO tb_user (id, email, name, password, user_group_id) 
			 VALUES (DEFAULT, 'rodrigo.baggio.si@gmail.com', 'Rodrigo Baggio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 1);

INSERT INTO tb_role (id, authority) VALUES (DEFAULT, 'ROLE_ADMIN');

INSERT INTO tb_user_group_role (user_group_id, role_id) VALUES (1, 1);



