DROP TABLE attendance_management.work_info;

CREATE TABLE attendance_management.work_info (info_no BIGINT AUTO_INCREMENT PRIMARY KEY, emp_no VARCHAR(4) NOT NULL, date VARCHAR(10) NOT NULL, work_year SMALLINT NOT NULL, work_month TINYINT NOT NULL, work_day TINYINT NOT NULL, work_start VARCHAR(10), work_last VARCHAR(10), real_start VARCHAR(10), real_last VARCHAR(10));

INSERT INTO attendance_management.work_info (emp_no, date, work_year, work_month, work_day, work_start, real_start) VALUES ('E010', '2000-01-01', 2000, 1, 1 , '12:00', '11:59');

UPDATE attendance_management.work_info SET work_last = '18:00', real_last = '17:59' WHERE emp_no = 'E010' AND date = '2000-01-01';

commit;