DROP TABLE IF EXISTS tasks CASCADE;
CREATE TABLE tasks
(
  id              bigserial PRIMARY KEY,
  user_id         bigint,
  title           varchar(255),
  description     varchar(255),
  status          varchar(10),
  time_start_task timestamp,
  total_time      timestamp,
  FOREIGN KEY (user_id) REFERENCES users (id)
);
-- \d tasks;
INSERT INTO tasks (user_id, title, description, status, time_start_task, total_time)
VALUES (1, '1-1 Task-16', 'description-16', 'NEW', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (1, '1-2 Task-32', 'description-32', 'IN_PROCESS', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (1, '1-3 Task-50', 'description-50', 'PAUSE', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (1, '1-4 Task-65', 'description-65', 'DONE', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (2, '2-5 Task--16', 'description--16','NEW', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (2, '2-6 Task--32', 'description--32','IN_PROCESS', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (2, '2-7 Task--50', 'description--50','DONE', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (3, '3-8 Task--65', 'description--65','DONE', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (3, '3-9 Task-105', 'description-105', 'NEW', LOCALTIMESTAMP, LOCALTIMESTAMP),
       (3, '3-10 Task-210', 'description-210', 'DONE', LOCALTIMESTAMP, LOCALTIMESTAMP)
;
-- SELECT * FROM tasks;
