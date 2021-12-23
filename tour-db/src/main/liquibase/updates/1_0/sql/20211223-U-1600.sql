create table if not exists covid_constraints (
    constraint_code varchar(10) primary key,
    description text
);

alter table countries add column covid_constraint varchar(10) references covid_constraints(constraint_code) on delete set null;