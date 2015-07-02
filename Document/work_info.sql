DROP TABLE attendance_management.work_info;

CREATE TABLE attendance_management.work_info (info_no BIGINT AUTO_INCREMENT PRIMARY KEY, emp_no VARCHAR(4) NOT NULL, date VARCHAR(10) NOT NULL, work_year SMALLINT NOT NULL, work_month TINYINT NOT NULL, work_day TINYINT NOT NULL, work_start VARCHAR(10), work_last VARCHAR(10), real_start VARCHAR(10), real_last VARCHAR(10));

commit;