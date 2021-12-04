CREATE TABLE clients (
    client_id serial PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    surname VARCHAR (50) NOT NULL,
    patronymic VARCHAR (50) NULL,
    phone_number VARCHAR (20) UNIQUE NOT NULL
);
CREATE TABLE employees (
    employee_id serial PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    surname VARCHAR (50) NOT NULL,
    patronymic VARCHAR (50) NULL,
    phone_number VARCHAR (20) UNIQUE NOT NULL
);
CREATE TABLE hotels (
    employee_id serial PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    type VARCHAR (20) NOT NULL
);
