-- удаляем филиал из таблицы сотрудников
alter table employees drop column filial;

-- удаляем филиал из таблицы клиентов
alter table clients drop column filial;

-- удаляем таблицу filial
drop table filial;

-- удаляем колонку supervisor в таблице employees
alter table employees drop column supervisor;

-- удаляем колонку covid_constraint в таблице countries
alter table countries drop column covid_constraint;

-- удаляем таблице covid_constraints
drop table covid_constraints;
