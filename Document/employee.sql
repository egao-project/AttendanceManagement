DROP TABLE attendance_management.employee;

CREATE TABLE attendance_management.employee (emp_no VARCHAR(4) PRIMARY KEY, emp_name VARCHAR(30) NOT NULL, emp_pass VARCHAR(15) NOT NULL);

INSERT INTO attendance_management.employee VALUES ('M001','田中寿法','tanakats');

INSERT INTO attendance_management.employee VALUES ('M002','牛木幸紀','ushikit');

INSERT INTO attendance_management.employee VALUES ('E002','笹原大時','sasaharad');

INSERT INTO attendance_management.employee VALUES ('E003','齋藤渉','saitow');

INSERT INTO attendance_management.employee VALUES ('E005','岡本潤','okamotoj');

INSERT INTO attendance_management.employee VALUES ('E006','田端亮','tabatar');
INSERT INTO attendance_management.employee VALUES ('E007','盛竜也','morit');

INSERT INTO attendance_management.employee VALUES ('E008','國小葉','kokusyoy');

INSERT INTO attendance_management.employee VALUES ('E009','西尾知美','nishiot');

INSERT INTO attendance_management.employee VALUES ('E010','滝本博昭','takimotoh');

INSERT INTO attendance_management.employee VALUES ('E011','大滝昇平','ohtakis');

commit;