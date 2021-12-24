insert into accommodation_types (accommodation_code, description) values
('RO', 'Room only - без питания'),
('EP', 'European Plan - без питания'),
('BO', 'Bed Only - без питания'),
('AO', 'Accommodation Only - без питания'),
('BB', 'Bed & breakfast - завтрак'),
('HB', 'Half board - полупансион'),
('FB', 'Full board — полный пансион'),
('AI', 'All inclusive');

insert into countries (country_code, name, visa_need) values
('MNE', 'Черногория', false),
('TUR', 'Турция', false),
('ITA', 'Италия', true);

insert into clients (name,phone,email) values
('Иванов Олег Петрович', '89996662134', 'oleg@ivanov.ru'),
('Петрова Альбина Александрович', '89772341133', 'albina@petrova.ru'),
('Павлов Александр Егорович', '89136130988', 'alex@pavlov.ru');

insert into employees (surname, name, patronymic, phone) values
('Ватькова', 'Светлана', 'Геннадьевна', '89652340978'),
('Симонов', 'Евгений', 'Андреевич', '89563458954');

insert into transport (transport_type) values
('Самолет'),
('Поезд'),
('Автобус'),
('Корабль');

insert into cities (name, county_code) values
('Котор', 'MNE'),
('Стамбул', 'TUR'),
('Рим', 'ITA');

insert into hotels (name, address, stars, city_id, accommodation) values
('Kotor Palace', 'Dobrota 16', 3, 1, 'RO'),
('Stambul Prince', 'Attatuerk 32/1', 4, 2, 'AI'),
('Roma Coliseum', 'Romul 2', 4, 3, 'HB');

insert into tours (hotel_id, transport_id, start_date, end_date, price) values
(1, 1, '2021-12-22', '2021-12-26', 56000.00),
(2, 1, '2021-12-23', '2021-12-25', 32000.00),
(3, 1, '2021-12-28', '2021-12-31', 62000.00),
(3, 1, '2022-01-01', '2022-01-05', 72000.00);

insert into covid_constraints(constraint_code, description) values
('VOZ', 'Одобренная ВОЗ вакцина'),
('RUS', 'Спутник, Ковивак и тд'),
('PCR', 'ПЦР'),
('ANY', 'Любая вакцина или ПЦР'),
('NO', 'Нет требований');

insert into filial(address) values
('Москва, ул. 3я Строителей, 25'),
('Саратов, ул. Московская, 16'),
('Санкт-Петербург, ул. Северная, 12');

update clients set filial = 2 where client_id = 1;
update clients set filial = 2 where client_id = 2;
update clients set filial = 3 where client_id = 3;

update employees set filial = 2 where employee_id = 1;
update employees set filial = 3 where employee_id = 2;

