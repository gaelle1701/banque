CREATE TABLE titulaire (
    code_titulaire INT (4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prenom VARCHAR (32),
    nom VARCHAR (32),
    adresse VARCHAR (32),
    code_postal CHAR (5)
)
    ENGINE=INNODB;

CREATE TABLE type_compte (
     code_type_compte CHAR (1) NOT NULL PRIMARY KEY,
     intitule VARCHAR (25)
)
    ENGINE=INNODB;

CREATE TABLE compte (
    num_compte INT (11) NOT NULL PRIMARY KEY,
    code_type_compte CHAR (1) NOT NULL,
    solde_compte FLOAT (10,2),
    code_titulaire INT (4) NOT NULL,
    CONSTRAINT fk_titulaire FOREIGN KEY (code_titulaire)
    REFERENCES titulaire(code_titulaire) ON DELETE CASCADE,
    CONSTRAINT fk_type_compte FOREIGN KEY (code_type_compte)
    REFERENCES type_compte(code_type_compte) ON DELETE CASCADE
)
    ENGINE=INNODB;

CREATE TABLE operation (
    num_op INT (11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    num_compte INT (5) NOT NULL,
    date_op DATE,
    lib_op VARCHAR (32),
    montant FLOAT (10,2),
    type_op CHAR(1),
    CONSTRAINT fk_compte FOREIGN KEY (num_compte)
    REFERENCES compte(num_compte) ON DELETE CASCADE
)
    ENGINE=INNODB;