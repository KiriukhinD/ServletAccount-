create table bank_account_test
(
    id             serial
        primary key,
    name_account   varchar(50),
    number_account varchar(100),
    status_account boolean
);