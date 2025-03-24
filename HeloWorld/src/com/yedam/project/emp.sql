create table tbl_member(
user_id varchar2(10) primary key,
password varchar2(30) not null,
user_name varchar2(50) not null
);
insert into tbl_member
values ('user01', '1111', '홍길동');
insert into tbl_member
values ('user02', '2222', '김길동');
insert into tbl_member
values ('user03', '3333', '박길동');

select *
from tbl_member;

select *
from tbl_member
where user_id = '' and password = '';


create table tbl_emp (
  emp_no varchar2(10) primary key,
  emp_name varchar2(100) not null,
  phone varchar2(20),
  hire_date date,
  salary number
);



insert into tbl_emp(
                    emp_no,
                    emp_name,
                    phone,
                    hire_date,
                    salary
                    )
values (?, ?, ?, ?, ?);

select *
from tbl_emp;

delete from tbl_emp
where emp_no = ?;


update tbl_emp
set    emp_no = ?,
       emp_name = ?,
       phone = ?,
       hire_date = ?,
       salary = ?
where  emp = ? and salary = ?;



commit;



--사용자 테이블
create table tbl_user (
                       user_id varchar2 (20), 
                       user_pw varchar2 (20)
                       );
                       
--판매자 테이블
create table tbl_company (
                          company_num varchar2 (10),
                          company_id varchar2 (20),
                          company_pw varchar2 (20)
                          );
                       
                       
-- 로그인을 할 사용자 계정을 확인
select user_id,
       user_pw
from   tbl_user
where  user_id = ? and user_pw = ?;

-- 로그인 할 판매자 계정을 확인
select company_num,
       company_id,
       company_pw
from   tbl_company
where  company_num = ? or company_id = ? and company_pw = ?;

-- 회원가입을 위한 insert
insert into tbl_user (user_id, user_pw)
values (?, ?);
--회원가입 중 id 중첩 확인
select *
from   tbl_user
where  user_id = ?;

insert into tbl_company (company_num, company_id, company_pw)
values (?, ?, ?);

select *
from tbl_company
where company_num = ?;

insert into tbl_user
values ('1111', '1111');
       
insert into tbl_company
values ('A000', '1111', '1111');              
                  
select *
from tbl_user;


select *
from tbl_company;

delete from tbl_company
where company_id = '1111';

commit;
