insert into authority (id, name) values (1, 'ADMIN');
insert into authority (id, name) values (2, 'USER');
insert into authority (id, name) values (3, 'CLIENT');

insert into utilisateur (id, username,password,enabled) values (1, 'admin','$2a$12$2NkOYYaole9eQYxCI2GZ.OqfRVltN/PcchQyKiLCEc1Fzltd6ioR.',true);
insert into utilisateur (id, username,password,enabled) values (2, 'user','$2a$12$NZd1eKTy2oPXSa3ZFUluk.puxlW1DoMy4nhazc9nwBw8PinY5wD9W',true);
insert into utilisateur (id, username,password,enabled) values (3, 'client','$2a$12$8i24fAKjAudIfewNUJ5Qwup0XKFfxEKKUoOAvawnxvgoL0Q6oLx0e',true);
insert into utilisateur (id, username,password,enabled) values (4, 'disabled','$2a$12$Rr/rR02kAYk3fSCtYLXLbuHV/LjoNgcFNCxHkJb0.QBOuNfVMa.0K',false);

insert into utilisateur_authorities values (1,1);
insert into utilisateur_authorities values (2,2);
insert into utilisateur_authorities values (3,3);
insert into utilisateur_authorities values (4,1);
insert into utilisateur_authorities values (4,2);
insert into utilisateur_authorities values (4,3);