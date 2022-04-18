-- лояльность для клиента
create table if not exists c_loyalty (
  code serial primary key,
  description text
);

-- добавляем лояльность клиенту
alter table clients add column loyalty int references c_loyalty(code) on delete set null;
