INSERT INTO users (userName, password, enabled, firstName, lastName, email) VALUES ('FernandoCC','Fer$C_C',1,'Fernando','Coba','fernandocoba@gmail.com');
INSERT INTO users (userName, password, enabled, firstName, lastName, email) VALUES ('CarlosJC','Carlos$J_C',true,'Carlos','Coba','carloscoba@gmail.com');

INSERT INTO roles (NAME) VALUES ('ROLE_USER');
INSERT INTO roles (NAME) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (USER_ID, ROLES_ID) VALUES (1,1);
INSERT INTO users_roles (USER_ID, ROLES_ID) VALUES (2,2);
INSERT INTO users_roles (USER_ID, ROLES_ID) VALUES (2,1);

