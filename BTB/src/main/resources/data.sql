-- CENTERS
INSERT INTO public.center (name, address, description, grade) VALUES ('CzDk', 'Preradoviceva 10, Subotica', 'Centar za davanje krvi', 3.3);
INSERT INTO public.center (name, address, description, grade) VALUES ('BTB', 'Filipa Visnjica 3E, Beograd', 'Centar, krv', 4.1);
INSERT INTO public.center (name, address, description, grade) VALUES ('Daj Krv', 'Zeleznicka 10, Novi Sad', 'Opis neki', 2.3);
INSERT INTO public.center (name, address, description, grade) VALUES ('Njam', 'Strazilovska 5, Novi Sad', 'Opis neki', 1.5);


-- SYSADMIN
INSERT INTO public.admins (id, jmbg, first_name, last_name, email, password, status, super_admin, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '4312389012341', 'Admin', 'Adminic', 'admin@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, true, 'Kralja Vladislava 16', 'Belgrade', 'Serbia', 'male', '+381610492131', 0);


-- STAFF/ADMIN_CENTER
INSERT INTO public.staffs (id, jmbg, first_name, last_name, email, password, status, center_id, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '12345123231', 'Staff', 'Staffic', 'staff@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 1, 'Strosmajerova 5', 'Petrovaradin', 'Serbia', 'female', '+381623312131', 1);
INSERT INTO public.staffs (id, jmbg, first_name, last_name, email, password, status, center_id, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '32112341123', 'Worker', 'Workeric', 'worker@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 2, 'Kaciceva 32', 'Petrovaradin', 'Serbia', 'male', '+381640592121', 1);


-- REGISTERED USERS
-- "$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6" = '123',
INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '34141412321', 'User', 'Useric', 'user@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 'Pregrevica 146d', 'Belgrade', 'Serbia', 'male', 'Designer', 'Driving instructor', 0, '+381691055491', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '41231231321', 'Nikola', 'Nikolic', 'nikola@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 'Mazuraniceva 10', 'Petrovaradin', 'Serbia', 'male', 'Mehanicar', 'Inzenjer', 1, '+381601049921', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '51232132131', 'Milica', 'Milicic', 'milica@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 'Preradoviceva 44', 'Petrovaradin', 'Serbia', 'female', 'Actor', 'Actor', 0, '+381630492122', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '54151321231', 'Marko', 'Markovic', 'marko@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 'Marka Oreskoviceva 8/a', 'Petrovaradin', 'Serbia', 'male', 'Driving instructor', 'Actor', 2, '+381653492131', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '11233211414', 'Jelena', 'Jelenic', 'jelena@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 'Dimitrija Tucovica 3', 'Novi Sad', 'Serbia', 'female', 'Designer', 'Footballer', 1, '+3816530421921', 2);

INSERT INTO public.users (id, jmbg, first_name, last_name, email, password, status, address, city, country, gender, job, profession, penalty, phone, role)
VALUES (nextval('global_id_sequence'), '19932131414', 'Petar', 'Petrovic', 'petar@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 'Petra Drapsina 41', 'Novi Sad', 'Serbia', 'male', 'Salesman', 'Salesman', 2, '+381624492331', 2);


INSERT INTO public.staffs (id, jmbg, first_name, last_name, email, password, status, center_id, address, city, country, gender, phone, role)
VALUES (nextval('global_id_sequence'), '32124541123', 'Pera', 'Peric', 'pera@gmail.com', '$2a$10$Io18FqjIJDYLfM.MLWvo5uCfdb0QgQWV/B.OoF0II9xGQV8AzV/m6', true, 1, 'Patrijarha Rajacica 32', 'Petrovaradin', 'Serbia', 'male', '+381640533521', 1);



-- ROLES
INSERT INTO ROLE(name) VALUES ('ROLE_USER');
INSERT INTO ROLE(name) VALUES ('ROLE_STAFF');
INSERT INTO ROLE(name) VALUES ('ROLE_ADMIN');

-- GRANT ADMIN ROLE
INSERT INTO ADMINS_ROLES(admin_id, roles_id) VALUES (1, 1);
-- INSERT INTO ADMINS_ROLES(admin_id, role_id) VALUES (1, 2);
INSERT INTO ADMINS_ROLES(admin_id, roles_id) VALUES (1, 3);

-- GRANT STAFF ROLE
INSERT INTO STAFFS_ROLES(staff_id, roles_id) VALUES (2, 1);
INSERT INTO STAFFS_ROLES(staff_id, roles_id) VALUES (2, 2);

INSERT INTO STAFFS_ROLES(staff_id, roles_id) VALUES (3, 1);
INSERT INTO STAFFS_ROLES(staff_id, roles_id) VALUES (3, 2);

-- GRANT USERS ROLE
INSERT INTO USERS_ROLES(user_id, roles_id) VALUES (4, 1);
INSERT INTO USERS_ROLES(user_id, roles_id) VALUES (5, 1);
INSERT INTO USERS_ROLES(user_id, roles_id) VALUES (6, 1);
INSERT INTO USERS_ROLES(user_id, roles_id) VALUES (7, 1);
INSERT INTO USERS_ROLES(user_id, roles_id) VALUES (8, 1);
INSERT INTO USERS_ROLES(user_id, roles_id) VALUES (9, 1);

INSERT INTO STAFFS_ROLES(staff_id, roles_id) VALUES (10, 1);
INSERT INTO STAFFS_ROLES(staff_id, roles_id) VALUES (10, 2);


-- PREDEFINED APPOINTMENTS [AVAILABLE]
-- AVAILABLE, SCHEDULED, FINISHED == 0, 1, 2
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '09:00:00', 1, 1, 2, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '11:00:00', 2, 1, 2, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '14:00:00', 2, 1, 2, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-04', '10:00:00', 1, 1, 2, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-04', '12:00:00', 1, 1, 2, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '11:00:00', 1, 2, 3, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '12:30:00', 1, 2, 3, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '12:00:00', 2, 2, 3, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '14:25:00', 3, 2, 3, 0);

-- PREDEFINED APPOINTMENTS [SCHEDULED]
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-01', '08:00:00', 1, 1, 2, 1);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-01', '11:00:00', 2, 1, 2, 1);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-01', '14:00:00', 2, 1, 2, 1);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-02', '10:00:00', 1, 1, 2, 1);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-02', '12:00:00', 1, 1, 2, 1);

-- Nov Worker
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '09:30:00', 1, 1, 10, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '11:30:00', 1, 1, 10, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '13:20:00', 2, 1, 10, 0);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-03', '16:00:00', 1, 1, 10, 0);

INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-01', '09:30:00', 1, 1, 10, 1);
INSERT INTO public.appointment(date, time, duration, center_id, staff_id, state) VALUES ('2023-02-01', '13:45:00', 2, 1, 10, 1);

-- SCHEDULED APPOINTMENTS
INSERT INTO public.scheduled_appointment(users_id, appointment_id) VALUES (4, 10);
INSERT INTO public.scheduled_appointment(users_id, appointment_id) VALUES (5, 11);
INSERT INTO public.scheduled_appointment(users_id, appointment_id) VALUES (6, 12);
INSERT INTO public.scheduled_appointment(users_id, appointment_id) VALUES (7, 13);
INSERT INTO public.scheduled_appointment(users_id, appointment_id) VALUES (8, 14);
INSERT INTO public.scheduled_appointment(users_id, appointment_id) VALUES (9, 6);

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

INSERT INTO public.blood(type, quantity, center_id) VALUES (0, 3.52, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (1, 1.21, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (2, 0.82, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (3, 4.54, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (4, 1.64, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (5, 0.50, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (6, 0.12, 2);
INSERT INTO public.blood(type, quantity, center_id) VALUES (7, 1.01, 2);

INSERT INTO public.blood(type, quantity, center_id) VALUES (0, 4.21, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (1, 1.21, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (2, 1.42, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (3, 4.42, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (4, 1.42, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (5, 5.11, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (6, 0.22, 3);
INSERT INTO public.blood(type, quantity, center_id) VALUES (7, 1.41, 3);

INSERT INTO public.blood(type, quantity, center_id) VALUES (0, 5.21, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (1, 0.34, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (2, 0.12, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (3, 4.42, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (4, 1.46, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (5, 2.11, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (6, 3.22, 4);
INSERT INTO public.blood(type, quantity, center_id) VALUES (7, 2.41, 4);

-- SURVEY_QUESTIONS
INSERT INTO public.survey_questions(id, question) VALUES (1, 'Da li ste ikada do sada davali krv?');
INSERT INTO public.survey_questions(id, question) VALUES (2, 'Da li se sada osećate zdravim i sposobnim da date krv?');
INSERT INTO public.survey_questions(id, question) VALUES (3, 'Da li smatrate da ste se dovoljno naspavali?');
INSERT INTO public.survey_questions(id, question) VALUES (4, 'Da li ste ikada bili odbijeni kao davaoc krvi?');
INSERT INTO public.survey_questions(id, question) VALUES (5, 'Da li ste nešto jeli pre dolaska na davanje krvi?');
INSERT INTO public.survey_questions(id, question) VALUES (6, 'Da li se bavite opasnim zanimanjem ili hobijem?');
INSERT INTO public.survey_questions(id, question) VALUES (7, 'Da li uzimate bilo kakve lekove?');


-- SURVEY_ANSWERS
-- USER USERIC
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 1, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 2, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 3, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 4, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 5, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 6, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (4, 7, true);

-- NIKOLA NIKOLIC
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 1, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 2, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 3, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 4, false);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 5, false);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 6, false);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (5, 7, true);

-- MILICA MILICIC
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 1, false);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 2, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 3, false);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 4, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 5, true);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 6, false);
INSERT INTO public.survey_answers(users_id, survey_questions_id, answer) VALUES (6, 7, false);

--COMPLAINT
INSERT INTO public.complaint(context, answer, type, user_id, admin_id) VALUES ('Zalim se', 'Odgovaram na zalbu', 0, 4, 1);
INSERT INTO public.complaint(context, type, user_id, admin_id) VALUES ('Zalim se', 0, 4, 1);
