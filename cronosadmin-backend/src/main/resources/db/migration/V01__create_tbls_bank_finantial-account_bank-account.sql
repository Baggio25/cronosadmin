CREATE TABLE bank (
   id BIGINT(20) AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   number VARCHAR(5) NOT NULL,
   active BOOLEAN NOT NULL DEFAULT TRUE,

   CONSTRAINT pk_bank PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE bank_account (
   id BIGINT(20) AUTO_INCREMENT,
   number VARCHAR(50) NOT NULL,
   digit DECIMAL(2) NOT NULL,
   agency VARCHAR(50) NOT NULL,
   digit_agency DECIMAL(2) NOT NULL,

   CONSTRAINT pk_bank_account PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE finantial_account (
   id BIGINT(20) AUTO_INCREMENT,
   description VARCHAR(50) NOT NULL,
   balance DECIMAL(6,2) NOT NULL,
   bank BOOLEAN NOT NULL DEFAULT FALSE,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   bank_account_id BIGINT(20) NOT NULL DEFAULT TRUE,

   CONSTRAINT pk_finantial_account PRIMARY KEY (id),
   CONSTRAINT fk_finantial_account_bank_account FOREIGN KEY (bank_account_id) REFERENCES bank_account(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

