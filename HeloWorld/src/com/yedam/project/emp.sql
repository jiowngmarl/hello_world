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

--사용자 테이블
create table tbl_user (
                       user_id varchar2 (20) PRIMARY KEY, 
                       user_pw varchar2 (20) not null
                       );
                  
       
--판매자 테이블
create table tbl_company (
                          company_num varchar2 (10) PRIMARY KEY,
                          company_id varchar2 (20) not null,
                          company_pw varchar2 (20) not null
                          );
                          
-- 로그인 할 사용자 계정을 확인
select user_id,
       user_pw
from   tbl_user
where  user_id = ? and user_pw = ?;

-- 로그인 할 판매자 계정을 확인
select company_num,
       company_id,
       company_pw
from   tbl_company
where  company_num = ? and company_id = ? and company_pw = ?;

-- 로그인 한 사용자의 구매목록 테이블
CREATE TABLE tbl_userProduct (
                              user_id VARCHAR2(20) NOT NULL,                     
                              product_code VARCHAR2(10) NOT NULL,                 
                              product_name VARCHAR2(20),                         
                              product_price VARCHAR2(20),                         
                              product_company VARCHAR2(20),                                      
                              FOREIGN KEY (user_id) REFERENCES tbl_user(user_id), 
                              FOREIGN KEY (product_code) REFERENCES tbl_product(product_code)  
                              );

drop table tbl_userProduct;

-- 사용자 구매 insert
insert into tbl_userProduct (
                             user_id,
                             product_code,
                             product_name,
                             product_price,
                             product_company
                             )
values(?, ?, ?, ?, ?);


-- 사용자 회원가입을 위한 insert
insert into tbl_user (user_id, user_pw)
values (?, ?);
-- 사용자 회원가입 중 id 중첩 확인
select *
from   tbl_user
where  user_id = ?;

--판매자 회원가입을 위한 insert
insert into tbl_company (company_num, company_id, company_pw)
values (?, ?, ?);

-- 판매자 회원가입 중 사업자번호, id 중첩 확인
select *
from tbl_company
where company_num = ? or company_id = ?;

-- 상품을 관리하는 테이블 생성 (company 테이블의 primary key를 받는 자식 테이블)
create table tbl_product(
                         company_num VARCHAR(20),
                         product_code VARCHAR(10) primary key,
                         product_name VARCHAR2(20),
                         product_price VARCHAR(20),
                         product_company VARCHAR(20),
                         FOREIGN KEY (company_num) REFERENCES tbl_company(company_num)
                         );
                         
drop table tbl_product;

-- 사용자가 상품 정보를 볼 테이블 출력

select product_code,
       product_name,
       product_price,
       product_company
from   tbl_product
order by product_code;

-- 사용자가 검색한 상품코드의 정보를 출력
select product_code,
       product_name,
       product_price,
       product_company
from   tbl_product
where  product_code = ?;

select *
from tbl_userproduct
where user_id = ?
order by product_code;



-- 상품 정보를 추가하는 insert
insert into tbl_product(company_num ,product_code, product_name, product_price, product_company)
values(? ,?, ?, ?, ?);

-- 상품 정보를 추가할 때 상품코드의 중복을 제거
select *
from tbl_product
where product_code = ?;

-- 등록한 상품을 출력
select *
from tbl_product
where company_num = ?
order by product_code;

-- 등록한 상품을 수정
update tbl_product
   set product_name = nvl(?, product_name),
       product_price = ?,
       product_company = nvl(?, product_company)
where  product_code = ?;

-- 등록한 상품을 삭제
delete from tbl_product
where product_code = ?;

delete from tbl_userproduct
where product_price = '500';


insert into tbl_product
values ('A000','001','지우개','500','모나미');
insert into tbl_product
values ('A000','002','연필','2000','모나미');
insert into tbl_product
values ('A001','003','볼펜','1500','모나미');
insert into tbl_product
values ('A001','004','필통','5000','모나미');

insert into tbl_userproduct
values ('1111','001','지우개','500','모나미');
insert into tbl_userproduct
values ('1111','002','볼펜','1500','모나미');
insert into tbl_userproduct
values ('1111','003','볼펜','1500','모나미');

insert into tbl_user
values ('1111', '1111');  
insert into tbl_company
values ('A000', '1111', '1111'); 

insert into tbl_company
values ('A001','1112','1112');



select *
from tbl_user;
select *
from tbl_company;
select *
from tbl_product;
select *
from tbl_userproduct;

rollback;
commit;