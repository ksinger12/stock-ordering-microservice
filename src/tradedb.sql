-- drop database tradingDB;

CREATE DATABASE IF NOT EXISTS tradingDB;
use tradingDB;

create table trades (id int primary key auto_increment,
ticker_symbol varchar (50),
company_name varchar(50),
date_entered datetime,
order_type varchar(50),
quantity int,
price double);

CREATE TABLE holdings (
id int primary key auto_increment,
ticker_symbol varchar (50),
company_name varchar (50),
number_of_shares int
);

CREATE TABLE cash (
    id int primary key auto_increment,
    cash double
);

insert into trades values(1, 'SPY', 'SPDR S&P 500 ETF Trust', '2022-01-23 12:45:56', 'BUY', 2, 350.21);
insert into trades values(2, 'SPY','SPDR S&P 500 ETF Trust', '2022-01-24 12:45:56', 'SELL', 2, 650.21);
insert into trades values(3, 'SPY','SPDR S&P 500 ETF Trust', '2022-01-25 12:45:56', 'BUY', 2, 150.21);
insert into trades values(4, 'AAPL','Apple Inc', '2022-02-23 12:45:56', 'BUY', 2, 650.21);
insert into trades values(5, 'AAPL','Apple Inc', '2022-02-24 12:45:56', 'SELL', 2, 850.21);
insert into trades values(6, 'AAPL','Apple Inc', '2022-02-25 12:45:56', 'BUY', 2, 715.21);

use tradingDB;

insert into holdings values(1, 'SPY', 'SPDR S&P 500 ETF Trust', 50);
insert into holdings values(2, 'AAPL', 'Apple Inc', 50);

use tradingDB;

insert into cash values(1, 1000000.00);