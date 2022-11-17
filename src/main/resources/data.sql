-- Za koriscenje data.sql-a potrebno je:
--      1. Zakomentarisati kod na liniji 20 u application.properties (spring.sql.init.mode=always) (komentar se pravi sa '#' - postoji mogucnost da je vec zakomentarisan taj deo)
--      2. Pokrenuti program i proveriti da li su se tabele u bazi uspesno napravile
--      3. Ukloniti komentar na delu koji se zakomentarisao u prvom koraku
--      4. Ponovo pokrenuti program i proveriti da li su podaci uneti u tabele

INSERT INTO survey_questions(question) VALUES ('Da li ste ikada do sada davali krv?');
INSERT INTO survey_questions(question) VALUES ('Da li ste ikada bili odbijeni kao davaoc krvi?');
INSERT INTO survey_questions(question) VALUES ('Da li se sada osećate zdravim i sposobnim da date krv?');
INSERT INTO survey_questions(question) VALUES ('Da li smatrate da ste se dovoljno naspavali?');
INSERT INTO survey_questions(question) VALUES ('Da li ste nešto jeli pre dolaska na davanje krvi?');
INSERT INTO survey_questions(question) VALUES ('Da li se bavite opasnim zanimanjem ili hobijem?');
INSERT INTO survey_questions(question) VALUES ('Da li uzimate bilo kakve lekove?');

INSERT INTO center (name, address, description, grade) VALUES ('CzDk', 'Preradoviceva 10, Subotica', 'Centar za davanje krvi', 3.3);
INSERT INTO center (name, address, description, grade) VALUES ('BTB', 'Filipa Visnjica 3E, Beograd', 'Centar, krv', 4.1);
INSERT INTO center (name, address, description, grade) VALUES ('Daj Krv', 'Zeleznicka 10, Novi Sad', 'Opis neki', 2.3);
INSERT INTO center (name, address, description, grade) VALUES ('Njam', 'Strazilovska 5, Novi Sad', 'Opis neki', 1.5);

INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('admin', '4312389012341', 'Admin', 'Adminic', 'admin@gmail.com', '123', true);

INSERT INTO users (role, jmbg, first_name, last_name, email, password, status, center_id) VALUES ('staff', '12345123231', 'Staff', 'Staffic', 'staff@gmail.com', '123', true, 1);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status, center_id) VALUES ('staff', '32112341123', 'Worker', 'Workeric', 'worker@gmail.com', '123', true, 2);

INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '34141412321', 'User', 'Useric', 'user@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '41231231321', 'Nikola', 'Nikolic', 'nikola@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '51232132131', 'Milica', 'Milicic', 'milica@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '54151321231', 'Marko', 'Markovic', 'marko@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '11233211414', 'Jelena', 'Jelenic', 'jelena@gmail.com', '123', true);
INSERT INTO users (role, jmbg, first_name, last_name, email, password, status) VALUES ('user', '19932131414', 'Petar', 'Petrovic', 'petar@gmail.com', '123', true);

INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '09:00:00', 1, 1, 2);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '11:00:00', 2, 1, 2);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '14:00:00', 2, 1, 2);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '10:00:00', 1, 1, 2);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '12:00:00', 1, 1, 2);

INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '17:00:00', 1, 2, 3);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '10:00:00', 1, 2, 3);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '12:00:00', 2, 2, 3);
INSERT INTO appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '17:00:00', 3, 2, 3);

INSERT INTO blood(type, quantity, center_id) VALUES ('A+', 12.5, 1);
INSERT INTO blood(type, quantity, center_id) VALUES ('B+', 2.5, 1);
INSERT INTO blood(type, quantity, center_id) VALUES ('A-', 3.5, 1);
