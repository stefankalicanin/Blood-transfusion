-- Za koriscenje data.sql-a potrebno je:
--      1. Zakomentarisati kod na liniji 20 u application.properties (spring.sql.init.mode=always) (komentar se pravi sa '#' - postoji mogucnost da je vec zakomentarisan taj deo)
--      2. Postaviti spring.jpa.hibernate.ddl-auto na create [linija ~17]
--      3. Pokrenuti program i proveriti da li su se tabele u bazi uspesno napravile
--      4. Ukloniti komentar na delu koji se zakomentarisao u prvom koraku i vrati spring.jpa.hibernate.ddl-auto na update
--      5. Ponovo pokrenuti program i proveriti da li su podaci uneti u tabele
--      6. Zakomentarisati ponovo liniju 20

-- CENTERS
INSERT INTO public.center (name, address, description, grade) VALUES ('CzDk', 'Preradoviceva 10, Subotica', 'Centar za davanje krvi', 3.3);
INSERT INTO public.center (name, address, description, grade) VALUES ('BTB', 'Filipa Visnjica 3E, Beograd', 'Centar, krv', 4.1);
INSERT INTO public.center (name, address, description, grade) VALUES ('Daj Krv', 'Zeleznicka 10, Novi Sad', 'Opis neki', 2.3);
INSERT INTO public.center (name, address, description, grade) VALUES ('Njam', 'Strazilovska 5, Novi Sad', 'Opis neki', 1.5);


-- SYSADMIN
INSERT INTO public.admins (id, jmbg, first_name, last_name, email, password, status, super_admin, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '4312389012341', 'Admin', 'Adminic', 'admin@gmail.com', '123', true, true, 'Kralja Vladislava 16', 'Belgrade', 'Serbia', 'male', '+381610492131', 0);


-- STAFF/ADMIN_CENTER
INSERT INTO public.staffs (id, jmbg, first_name, last_name, email, password, status, center_id, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '12345123231', 'Staff', 'Staffic', 'staff@gmail.com', '123', true, 1, 'Strosmajerova 5', 'Petrovaradin', 'Serbia', 'female', '+381623312131', 1);
INSERT INTO public.staffs (id, jmbg, first_name, last_name, email, password, status, center_id, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '32112341123', 'Worker', 'Workeric', 'worker@gmail.com', '123', true, 2, 'Kaciceva 32', 'Petrovaradin', 'Serbia', 'male', '+381640592121', 1);


-- REGISTERED USERS
INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '34141412321', 'User', 'Useric', 'user@gmail.com', '123', true, 'Pregrevica 146d', 'Belgrade', 'Serbia', 'male', 'Designer', 'Driving instructor', 0, '+381691055491', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '41231231321', 'Nikola', 'Nikolic', 'nikola@gmail.com', '123', true, 'Mazuraniceva 10', 'Petrovaradin', 'Serbia', 'male', 'Mehanicar', 'Inzenjer', 1, '+381601049921', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '51232132131', 'Milica', 'Milicic', 'milica@gmail.com', '123', true, 'Preradoviceva 44', 'Petrovaradin', 'Serbia', 'female', 'Actor', 'Actor', 0, '+381630492122', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '54151321231', 'Marko', 'Markovic', 'marko@gmail.com', '123', true, 'Marka Oreskoviceva 8/a', 'Petrovaradin', 'Serbia', 'male', 'Driving instructor', 'Actor', 2, '+381653492131', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '11233211414', 'Jelena', 'Jelenic', 'jelena@gmail.com', '123', true, 'Dimitrija Tucovica 3', 'Novi Sad', 'Serbia', 'female', 'Designer', 'Footballer', 1, '+3816530421921', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '19932131414', 'Petar', 'Petrovic', 'petar@gmail.com', '123', true, 'Petra Drapsina 41', 'Novi Sad', 'Serbia', 'male', 'Salesman', 'Salesman', 2, '+381624492331', 2);


-- PREDEFINED APPOINTMENTS
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '09:00:00', 1, 1, 2);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '11:00:00', 2, 1, 2);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '14:00:00', 2, 1, 2);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '10:00:00', 1, 1, 2);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '12:00:00', 1, 1, 2);

INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-17', '17:00:00', 1, 2, 3);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '10:00:00', 1, 2, 3);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '12:00:00', 2, 2, 3);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id) VALUES ('2022-11-18', '17:00:00', 3, 2, 3);


-- BLOOD BANK
        -- A_POSITIVE = 0,
        -- A_NEGATIVE = 1,
        -- B_POSITIVE = 2,
        -- B_NEGATIVE = 3,
        -- O_POSITIVE = 4,
        -- O_NEGATIVE = 5,
        -- AB_POSITIVE = 6,
        -- AB_NEGATIVE = 7

INSERT INTO public.blood(type, quantity, center_id) VALUES (0, 5.52, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (1, 3.21, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (2, 1.82, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (3, 0.54, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (4, 4.64, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (5, 3.50, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (6, 7.12, 1);
INSERT INTO public.blood(type, quantity, center_id) VALUES (7, 9.01, 1);


-- SURVEY_QUESTIONS
INSERT INTO public.survey_questions(question) VALUES ('Da li ste ikada do sada davali krv?');
INSERT INTO public.survey_questions(question) VALUES ('Da li ste ikada bili odbijeni kao davaoc krvi?');
INSERT INTO public.survey_questions(question) VALUES ('Da li se sada osećate zdravim i sposobnim da date krv?');
INSERT INTO public.survey_questions(question) VALUES ('Da li smatrate da ste se dovoljno naspavali?');
INSERT INTO public.survey_questions(question) VALUES ('Da li ste nešto jeli pre dolaska na davanje krvi?');
INSERT INTO public.survey_questions(question) VALUES ('Da li se bavite opasnim zanimanjem ili hobijem?');
INSERT INTO public.survey_questions(question) VALUES ('Da li uzimate bilo kakve lekove?');
