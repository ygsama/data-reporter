create database data_report DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create user 'reporter' identified by 'reporter';

grant all privileges on data_report.* to 'reporter'@'localhost' identified by 'reporter' with grant option;
flush privileges;

grant all privileges on data_report.* to 'reporter'@'%' identified by 'reporter' with grant option;
flush privileges;