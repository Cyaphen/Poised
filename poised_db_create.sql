create database if not exists poisedpms;
use poisedpms;
create table customer(cust_surname varchar(15), cust_name varchar(15), cust_email varchar(35), cust_tel long, cust_address varchar(35),
	primary key(cust_surname));
create table architect(arch_name varchar(15), arch_surname varchar(15), arch_email varchar(35), arch_tel long, arch_address varchar(35),
	primary key(arch_name));
create table contractor(cont_name varchar(15), cont_surname varchar(15), cont_email varchar(35), cont_tel long, cont_address varchar(35),
	primary key(cont_name));
create table proj_address(proj_name varchar(25), erf_num int, proj_address varchar(35), proj_suburb varchar(15), build_type varchar(15),
	primary key(proj_name));
create table invoice(proj_num int, inv_num int, date_complete varchar(15), total_paid long, primary key(proj_num));
create table proj_info(proj_num int, proj_fee long, proj_deadline date, arch_name varchar(15), cont_name varchar(15), proj_name varchar(25), 
	cust_surname varchar(15), primary key(proj_num), foreign key(arch_name) references architect(arch_name), 
	foreign key(cont_name) references contractor(cont_name), foreign key(proj_name) references proj_address(proj_name),
	foreign key(cust_surname) references customer(cust_surname), 
	constraint foreign key(proj_num) references invoice(proj_num));	