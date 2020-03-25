если postgresql был установлен через yum 
то для добавления разширения contrib:
yum install postgresql11-contrib.x86_64
su - postgres
psql
create extension pgcrypto;
create database spjava;