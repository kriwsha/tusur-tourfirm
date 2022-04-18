-- удаляем колонку лояльности
alter table clients drop column loyalty;

-- удаляем таблицу лояльности
drop table c_loyalty;