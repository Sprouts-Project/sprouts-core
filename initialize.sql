drop database if exists `sprouts-core-notebook`;
create database `sprouts-core-notebook`;

create user 'manager'@'%' identified by password '*81F5E21E35407D884A6CD4A731AEBFB6AF209E1B';

grant select, insert, update, delete, create, drop, references, index, alter, 
        create temporary tables, lock tables, create view, create routine, 
        alter routine, execute, trigger, show view
    on `sprouts-core-notebook`.* to 'manager'@'%';
    