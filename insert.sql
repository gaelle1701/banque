insert into titulaire (prenom, nom, adresse, code_postal) values ('Traci', 'Davidai', '6164 Prentice Point', '75008');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Geordie', 'Lintall', '3 Judy Crossing','13001' );
insert into titulaire (prenom, nom, adresse, code_postal) values ('Brittni', 'Deware', '607 Dawn Plaza', '93600');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Sibbie', 'Maryin', '7641 Lillian Court', '75016');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Matthieu', 'Gierok', '36 Carioca Place', '93270');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Aaron', 'Dykes', '5 Lawn Center', '33120');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Arty', 'Goch', '061 Dapin Place', '93300');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Raffarty', 'Maudsley', '10989 Eastwood Park', '29000');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Sephira', 'McQuade', '289 Jackson Lane', '35019');
insert into titulaire (prenom, nom, adresse, code_postal) values ('Anjanette', 'Inkles', '9 Aberg Point', '49000');

insert into type_compte (code_type_compte, intitule) values ('C', 'Compte_courant');
insert into type_compte (code_type_compte, intitule) values ('E', 'Epargne');
insert into type_compte (code_type_compte, intitule) values ('P', 'Plan_epargne_logement');
insert into type_compte (code_type_compte, intitule) values ('A', 'Assurance_vie');


insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (21433, 'E', 904.40, 1);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (49703, 'C', 1813.48, 2);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (72338, 'C', 3355.57, 3);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (46730, 'P', 2664.03, 4);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (58980, 'C', 3732.98, 5);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (90473, 'E', 4705.07, 6);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (06431, 'A', 2900.98, 7);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (60778, 'C', 4004.47, 8);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (81863, 'C', 1964.48, 9);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (76367, 'E', 1579.30, 9);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (90487, 'A', 4705.07, 10);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (06981, 'C', 2900.98, 10);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (60767, 'P', 4004.47, 10);
insert into compte (num_compte, code_type_compte, solde_compte, code_titulaire) values (81898, 'E', 1964.48, 10);


insert into operation (num_compte, date_op, lib_op, montant, type_op) values (21433, '2021-05-12', 'Retrait', 1189.80, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (49703, '2021-02-02', 'Retrait', 293.91, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (72338, '2021-04-23', 'Virement', 1838.61, 'V');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (46730, '2020-06-04', 'D??p??t', 893.81, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (58980, '2020-09-01', 'Retrait', 345.57, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (90473, '2020-06-02', 'D??p??t', 559.35, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (06431, '2020-07-03', 'Pr??l??vement', 300.65, 'P');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (60778, '2020-11-03', 'D??p??t', 1525.34, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (81863, '2020-10-01', 'Retrait', 14.88, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (76367, '2020-07-03', 'Retrait', 1564.33, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (90487, '2020-06-02', 'D??p??t', 559.35, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (06981, '2020-07-03', 'Pr??l??vement', 300.65, 'P');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (60767, '2020-12-03', 'D??p??t', 1525.34, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (81898, '2020-12-01', 'Retrait', 14.88, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (06431, '2020-07-03', 'Retrait', 1564.33, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (21433, '2021-05-12', 'Retrait', 1189.80, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (49703, '2021-02-02', 'Retrait', 293.91, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (72338, '2021-04-23', 'Virement', 1838.61, 'V');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (46730, '2020-06-04', 'D??p??t', 893.81, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (58980, '2020-09-01', 'Retrait', 345.57, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (90473, '2020-06-02', 'D??p??t', 559.35, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (06431, '2020-07-03', 'Pr??l??vement', 300.65, 'P');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (60778, '2020-11-03', 'D??p??t', 1525.34, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (81863, '2020-10-01', 'Retrait', 14.88, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (76367, '2020-07-03', 'Retrait', 1564.33, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (90487, '2020-06-02', 'D??p??t', 559.35, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (06981, '2020-07-03', 'Pr??l??vement', 300.65, 'P');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (60767, '2020-12-03', 'D??p??t', 1525.34, 'D');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (81898, '2020-12-01', 'Retrait', 14.88, 'R');
insert into operation (num_compte, date_op, lib_op, montant, type_op) values (06431, '2020-07-03', 'Retrait', 1564.33, 'R');