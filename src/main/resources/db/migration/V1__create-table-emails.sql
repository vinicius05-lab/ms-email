create table emails(
    id bigint primary key not null auto_increment,
    sender varchar(100) not null,
    email_from varchar(100) not null,
    email_to varchar(100) not null,
    subject varchar(100) not null,
    body text not null,
    send_date_email timestamp not null,
    status_email varchar(5) not null
);