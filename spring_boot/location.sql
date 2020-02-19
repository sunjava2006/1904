create table classes
(
     id number constraint pk_class_id primary key,
     class_name varchar2(20 char)
);

create table students
(
    id number constraint pk_student_id primary key,
    name varchar2(20 char) not null,
    passwd char(6) not null,
    gender char(1 char),
    class_id number CONSTRAINT fk_student_class_id REFERENCES classes(id) 
);
alter table students add student_id varchar2(20) unique;
alter table students modify  gender char(1 char);
insert into classes(id, class_name)values(1,'1502');
insert into students(id,student_id,name,passwd,gender,class_id)
values(1,'150201','Îâð©','123456','ÄÐ',1);


commit;

select * from STUDENTS;

create sequence seq_students ;
select seq_students.nextval from dual;

select * from classes;
update students set passwd='123456';


create sequence seq_classes start with 2;
