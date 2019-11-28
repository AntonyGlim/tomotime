DROP TABLE IF EXISTS tasks CASCADE;
CREATE TABLE tasks
(
  id              bigserial PRIMARY KEY,
  title           varchar(255),
  description     varchar(255),
  time_start_task timestamp,
  total_time      timestamp
);
-- \d tasks;
INSERT INTO tasks (title, description, time_start_task, total_time)
VALUES ('1 Task-16', 'description-16', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('2 Task-32', 'description-32', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('3 Task-50', 'description-50', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('4 Task-65', 'description-65', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('5 Task--16', 'description--16', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('6 Task--32', 'description--32', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('7 Task--50', 'description--50', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('8 Task--65', 'description--65', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('9 Task-105', 'description-105', LOCALTIMESTAMP, LOCALTIMESTAMP),
       ('10 Task-210', 'description-210', LOCALTIMESTAMP, LOCALTIMESTAMP)
;
-- SELECT * FROM tasks;
