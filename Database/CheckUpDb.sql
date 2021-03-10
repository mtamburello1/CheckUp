drop schema IF exists CheckUpDb;
CREATE SCHEMA CheckUpDB;
USE CheckUpDB;

CREATE TABLE User(
fiscal_code						varchar(16) NOT NULL,
user_name						varchar(20) NOT NULL,
surname							varchar(20) NOT NULL,
birth_date						date NOT NULL,
birth_place						varchar(20) NOT NULL,
residence						varchar(50) NOT NULL,
user_password					varchar(256) NOT NULL,
phone_number					bigint NOT NULL,
email							varchar(50) NOT NULL,
type_user						enum('doctor', 'secretary', 'patient'),
specialization					varchar(50),
PRIMARY KEY (fiscal_code),
KEY (email));


CREATE TABLE BookingVisit(
booking_code					varchar(100) NOT NULL,
doctor 							varchar(16) NOT NULL,
patient							varchar(16) NOT NULL,
booking_day						date NOT NULL,
booking_hour					time NOT NULL,
booking_type					varchar(50) NOT NULL,
carried_out						boolean NOT NULL,
PRIMARY KEY (booking_code),
FOREIGN KEY (doctor) REFERENCES User(fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE,
FOREIGN KEY (patient) REFERENCES User (fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE
);

CREATE TABLE ExamResult(
exam_code							int NOT NULL,
doctor 								varchar(16) NOT NULL,
patient								varchar(16) NOT NULL,
revised								boolean NOT NULL,
report_type							varchar(50) NOT NULL,
note								varchar(200),
report_file							varchar(500) NOT NULL,
medical_record_code					varchar(100) NOT NULL,
insertion_date						date NOT NULL,
PRIMARY KEY (exam_code),
FOREIGN KEY (doctor) REFERENCES User(fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE,
FOREIGN KEY (patient) REFERENCES User (fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE);

CREATE TABLE Diagnosis(
diagnosis_code						int NOT NULL,
doctor 								varchar(16) NOT NULL,
patient								varchar(16) NOT NULL,
medical_record_code					varchar(100) NOT NULL,
diagnosis_description				varchar(500) NOT NULL,
reason_for_the_visit                varchar(250) NOT NULL,
insertion_date						date NOT NULL,
PRIMARY KEY (diagnosis_code),
FOREIGN KEY (doctor) REFERENCES User(fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE,
FOREIGN KEY (patient) REFERENCES User (fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE);

CREATE TABLE VisitTimetable(
timetable_code						varchar(100) NOT NULL,
doctor 								varchar(16) NOT NULL,
hour_visit							time NOT NULL,
date_visit							date NOT NULL,
duration							int NOT NULL,
availability						boolean NOT NULL,
PRIMARY KEY (timetable_code),
FOREIGN KEY (doctor) REFERENCES User(fiscal_code)
ON UPDATE CASCADE
ON DELETE CASCADE);