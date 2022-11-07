-- Za koriscenje data.sql-a potrebno je:
--      1. Zakomentarisati kod na liniji 20 u application.properties (spring.sql.init.mode=always) (komentar se pravi sa '#' - postoji mogucnost da je vec zakomentarisan taj deo)
--      2. Pokrenuti program i proveriti da li su se tabele u bazi uspesno napravile
--      3. Ukloniti komentar na delu koji se zakomentarisao u prvom koraku
--      4. Ponovo pokrenuti program i proveriti da li su podaci uneti u tabele

INSERT INTO center (name, address, description, grade) VALUES ('CzDk', 'Preradoviceva 10', 'Centar za davanje krvi', 1.0);
INSERT INTO center (name, address, description, grade) VALUES ('BTB', 'Filipa Visnjica 3E', 'Centar, krv', 1.0);
INSERT INTO center (name, address, description, grade) VALUES ('Daj Krv', 'Zeleznicka 10', 'Opis neki', 1.0);
INSERT INTO center (name, address, description, grade) VALUES ('Njam', 'Strazilovska 5', 'Opis neki', 1.0);

INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('admin', '43211234', 'Admin', 'Adminic', 'admin@gmail.com', '123', true);

INSERT INTO users (role, jmbg, first_name, last_name, email, password, status, center_id) VALUES ('staff', '12345123', 'Staff', 'Staffic', 'staff@gmail.com', '123', true, 2);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status, center_id) VALUES ('staff', '32112341', 'Worker', 'Workeric', 'worker@gmail.com', '123', true, 1);

INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '34141412', 'User', 'Useric', 'user@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '41231231', 'Nikola', 'Nikolic', 'nikola@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '51232131', 'Milica', 'Milicic', 'milica@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '54151231', 'Marko', 'Markovic', 'marko@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '11231414', 'Jelena', 'Jelenic', 'jelena@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '19931414', 'Petar', 'Petrovic', 'petar@gmail.com', '123', true);

