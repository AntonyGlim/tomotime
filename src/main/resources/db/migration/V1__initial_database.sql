-- *for Windows
-- \! chcp 1251

-- *for Linux
-- sudo -i -u postgres
-- psql


-- \db - список табличных пространств
-- \dn - список схем
-- \dt - список таблиц

-- DROP SCHEMA IF EXISTS tomotime CASCADE;
-- CREATE SCHEMA tomotime;
--
-- SET search_path TO tomotime;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
  id         bigserial,
  email      VARCHAR(50) NOT NULL UNIQUE,
  password   varchar(80) NOT NULL,
  first_name VARCHAR(50),
  last_name  VARCHAR(50),
  registration_date timestamp,
  PRIMARY KEY (id)
);
-- SELECT * FROM users;

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
  id   serial,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
-- SELECT * FROM roles;

DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles
(
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id)
    REFERENCES users (id),
  FOREIGN KEY (role_id)
    REFERENCES roles (id)
);
-- SELECT * FROM users_roles;

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (email, password, first_name, last_name, registration_date)
VALUES  ('admin1@mail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Admin1Name', 'Admin1LastName', LOCALTIMESTAMP),
        ('admin2@mail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Admin3Name', 'Admin2LastName', LOCALTIMESTAMP),
        ('admin3@mail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Admin4Name', 'Admin3LastName', LOCALTIMESTAMP);
-- password 100

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (1, 2);