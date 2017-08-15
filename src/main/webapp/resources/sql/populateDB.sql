
INSERT INTO roles(id,role) VALUES (1, "ROLE_ADMIN");
INSERT INTO roles(id, role) VALUES (2, "ROLE_USER");
INSERT INTO roles(id, role) VALUES (3, "ROLE_ANONYMOUS");

/*login - admin, password - 1*/
INSERT INTO users(username,password) VALUES ("admin","a4d404eed2f06a5935cf47edfd412cbf2deb216a");
INSERT INTO userrole(user_id, role_id) VALUES (1,1),(1,2);
