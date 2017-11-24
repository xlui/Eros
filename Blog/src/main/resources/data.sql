# create database eros;
# grant all privileges on eros.* to admin@localhost identified by 'admin';

insert into article VALUES
    (1, "admin", "Hello World! This is my first blog.", "default", now(), "Hello"),
    (2, "admin", "This is second blog. Just for test", "default", now(), "Hello");
