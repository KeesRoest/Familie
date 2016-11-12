INSERT INTO person(id, achternaam, doopnaam, email, geboortedatum, geboorteplaats, geslacht, huisnr, huisnrtoev, land, overlijdensdatum, password, plaatsnaam, postcode, roepnaam, staat, straatnaam, telefoon, tussenvoegsel) 	VALUES (1001, 'Berg', 'Wouter', null, '1915-12-07', 'Oegstgeest', 'M', 0, null, 'Nederland', '1999-11-02', '12345678', null, null, 'Wout', null, null, null, 'van den');
INSERT INTO person(id, achternaam, doopnaam, email, geboortedatum, geboorteplaats, geslacht, huisnr, huisnrtoev, land, overlijdensdatum, password, plaatsnaam, postcode, roepnaam, staat, straatnaam, telefoon, tussenvoegsel) 	VALUES (1002, 'Berg-van der Krogt', 'Suzanna Maria', null, '1919-06-04', 'Leiden', 'V', 0, null, 'Nederland', '2004-01-11', '12345678', null, null, 'Suus', null, null, null, 'van den');
INSERT INTO relationtype(id, partner, relationtype) VALUES(1, true, 'Is gehuwd met');
INSERT INTO relationtype(id, partner, relationtype) VALUES(2, true, 'Is partner van');
INSERT INTO relationtype(id, partner, relationtype) VALUES(3, false, 'Is kind van');
INSERT INTO relation(id, relatietype, partner, person1_id, person2_id) VALUES(10001, 'Is gehuwd met', true, 1001, 1002);
INSERT INTO relation(id, relatietype, partner, person1_id, person2_id) VALUES(10002, 'Is gehuwd met', true, 1002, 1001);
