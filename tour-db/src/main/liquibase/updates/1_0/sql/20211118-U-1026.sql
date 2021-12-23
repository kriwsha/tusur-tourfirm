create table if not exists accommodation_types (
    accommodation_code varchar(10) primary key,
    description text
);

create table if not exists countries (
    country_code varchar(10) primary key,
    name varchar(50) not null,
    visa_need boolean
);

create table if not exists clients (
    client_id serial primary key,
    name varchar(100) not null,
    phone varchar(20) unique not null,
    email varchar(50) null
);

create table if not exists employees (
    employee_id serial primary key,
    surname varchar(20),
    name varchar(20),
    patronymic varchar(20),
    phone varchar(20) unique not null
);

create table if not exists transport (
    transport_id serial primary key,
    transport_type varchar(50) not null
);

create table if not exists cities (
    city_id serial primary key,
    name varchar(250) not null,
    county_code varchar(10) references countries(country_code) on delete set null
);

create table if not exists hotels (
    hotel_id serial primary key,
    name varchar(50) not null,
    address text,
    stars int,
    city_id serial references cities(city_id) on delete set null ,
    accommodation varchar(10) references accommodation_types(accommodation_code) on delete set null
);

create table if not exists tours (
    tour_id serial primary key,
    hotel_id serial references hotels(hotel_id) on delete set null,
    transport_id serial references transport(transport_id) on delete set null,
    start_date date not null,
    end_date date not null,
    price money not null
);

create table if not exists sales (
    sale_id serial primary key,
    tour_id serial references tours(tour_id) on delete set null,
    client_id serial references clients(client_id) on delete set null,
    employee_id serial references employees(employee_id) on delete set null
);

