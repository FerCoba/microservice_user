INSERT INTO users (userName, password, enabled, firstName, lastName, email) VALUES ('FernandoCC','$2a$10$vRg3am/LsWrkNvlJYQUrw.gGFWz4M0/a/h2gC4OVSQreKjilLmcVK',1,'Fernando','Coba','fernandocoba@gmail.com');
INSERT INTO users (userName, password, enabled, firstName, lastName, email) VALUES ('CarlosJC','$2a$10$vRg3am/LsWrkNvlJYQUrw.gGFWz4M0/a/h2gC4OVSQreKjilLmcVK',true,'Carlos','Coba','carloscoba@gmail.com');

INSERT INTO roles (NAME) VALUES ('ROLE_USER');
INSERT INTO roles (NAME) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (USER_ID, ROLES_ID) VALUES (1,1);
INSERT INTO users_roles (USER_ID, ROLES_ID) VALUES (2,2);
INSERT INTO users_roles (USER_ID, ROLES_ID) VALUES (2,1);

