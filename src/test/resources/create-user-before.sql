delete from user_role;
delete from usr;

insert into usr (id, active, password, username) values
(1, true, '123', 'BDN'),
(2, true, '123', 'mike');

insert into user_role(user_id,roles) values
(1,'USER'), (1,'ADMIN'),
(2,'USER');