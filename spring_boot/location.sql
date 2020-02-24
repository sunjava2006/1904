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
values(1,'150201','吴皓','123456','男',1);
--=====================================================================
create table builds
(
  id number constraint pk_builds_id primary key,
  name varchar2(20 char),
  latitude number(17,14),
  longitude number(17,14)
);
create sequence seq_builds;
insert into builds(id, name,latitude, longitude)
values(seq_builds.nextval,'明德楼',118.71855656085205,32.20466832956472);

select * from BUILDS;

create table classrooms
(
   id number constraint pk_classroo_id primary key,
   classroom_name varchar2(20 char),
   build_id number constraint fk_classroom_build_id references builds(id)
);
CREATE SEQUENCE seq_classrooms;
insert into classrooms(id, classroom_name, build_id)
values(seq_classrooms.nextval, '明德楼302',1);

create table subjects
(
  id number constraint pk_subjects_id primary key,
  subject_id varchar2(20 char) ,
  subject_name varchar2(20 char)
);
create sequence seq_subjects;
INSERT into subjects(id, subject_id, subject_name)
values(seq_subjects.nextval, 'J001','C语言程序设计');

create table times
(
 id number constraint pk_tims_id primary key,
 time_name varchar2(20 char),
 start_time date,
 end_time date
);

insert into times values (1,'第1节',to_date('08:00','hh24:mi'),to_date('09:40','hh24:mi'));
insert into times values (2,'第2节',to_date('10:10','hh24:mi'),to_date('11:50','hh24:mi'));
insert into times values (3,'第3节',to_date('13:30','hh24:mi'),to_date('15:10','hh24:mi'));
insert into times values (4,'第4节',to_date('15:40','hh24:mi'),to_date('17:20','hh24:mi'));
select * from times;


create table plans
(
id number constraint pk_plans_id primary key,
classroom_id number constraint fk_plans_room_id references classrooms(id),
class_id number constraint fk_plans_class_id references classes(id),
subject_id number constraint fk_plans_subj_id references subjects(id),
times_id number constraint fk_plans_times_id references times(id)
);

create table clocking_id
(
  id number primary key,
  student_id number references students(id),
  plan_id number references plans(id),
  clocking_in_time date
);

create table day
(
    id number primary key,
    day varchar2(3 char)
);

insert into day values(1,'星期1');
insert into day values(2,'星期2');
insert into day values(3,'星期3');
insert into day values(4,'星期4');
insert into day values(5,'星期5');

--===========================================================================
commit;

select * from STUDENTS;

create sequence seq_students ;
select seq_students.nextval from dual;

select * from classes;
update students set passwd='123456';


create sequence seq_classes start with 2;

select * from(
select a.*, rownum ro from(
select * from classes order by id desc)a where rownum<=4) where ro>2;

update CLASSES set CLASS_NAME='1504' where CLASS_NAME is null;

--==========================================================================
-- 根据班级名查询一课程安排，按星期排序
select * from plans p
join classrooms r on r.id = p.classroom_id
join classes c on c.id = p.CLASSROOM_ID
join SUBJECTS s on s.id = p.SUBJECT_ID
join TIMES t on t.id = p.TIMES_ID
join day d on d.id = p.day_id 
where c.class_name='1502'
order by d.id;


select * from plans where class_id=(select id  from classes where class_name='1505')
order by DAY_ID;


select * from classes;

select * from classrooms where id=1;
