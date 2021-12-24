-- создание справочника ковидных ограничений
create table if not exists covid_constraints (
    constraint_code varchar(10) primary key,
    description text
);
-- добавляем в таблицу стран ковидные ограничения
alter table countries add column covid_constraint varchar(10) references covid_constraints(constraint_code) on delete set null;
-- добавление колонки руководителя в таблицу
alter table employees add column supervisor int references employees(employee_id) on delete set null;
-- создание справочника филиалов
create table if not exists filial (
    filial_id serial primary key,
    address text
);
-- добавляем в таблицу клиентов филиал обслуживания
alter table clients add column filial int references filial(filial_id) on delete set null;
-- добавляем в таблицу сотрудников филиал
alter table employees add column filial int references filial(filial_id) on delete set null;