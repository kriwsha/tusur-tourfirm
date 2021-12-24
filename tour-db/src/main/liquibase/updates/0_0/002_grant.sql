-- добавляем права
grant all privileges on database tourfirm to tfadmin;

grant connect on database tourfirm to leader;
grant connect on database tourfirm to employee;
grant connect on database tourfirm to client;

grant select, update, insert on all tables in schema public to leader;

grant select on all tables in schema public to employee;
grant update, insert on clients to employee;
grant update, insert on hotels to employee;
grant update, insert on tours to employee;
grant insert on sales to employee;

grant select on tours to client;
grant select on hotels to client;
grant select on cities to client;
grant select on countries to client;
grant select on accommodation_types to client;

-- добавляем права на ковидный справочник
grant select on covid_constraints to client;
