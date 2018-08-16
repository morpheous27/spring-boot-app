create user 'springuser'@'localhost' identified by 'springuser';
create database springuser;
grant all privileges on springuser to 'springuser'@'localhost';
FLUSH PRIVILEGES;

select * from notes;

