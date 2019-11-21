DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE tasks
(
  id              bigserial PRIMARY KEY,
  title           varchar(255),
  time_start_task timestamp,
  total_time      timestamp
);
-- \d products;
INSERT INTO tasks (title, time_start_task, total_time)
VALUES ('1 Task-16', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('2 Task-32', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('3 Task-50', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('4 Task-65', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('5 Task--16', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('6 Task--32', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('7 Task--50', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('8 Task--65', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('9 Task-105', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('10 Task-210', LOCALTIMESTAMP, LOCALTIMESTAMP)
;
-- SELECT * FROM products;
