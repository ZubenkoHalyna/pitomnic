CREATE TABLE news
(
  id SERIAL PRIMARY KEY,
  postDate timestamp,
  title VARCHAR(50),
  description VARCHAR(500)
);


CREATE TABLE photo
(
  id SERIAL PRIMARY KEY,
  photo BYTEA
);

CREATE TABLE newsphoto
(
  news_id INTEGER,
  photo_id INTEGER,
  CONSTRAINT newsphoto_ibfk_1 FOREIGN KEY (news_id) REFERENCES news (id),
  CONSTRAINT newsphoto_ibfk_2 FOREIGN KEY (photo_id) REFERENCES photo (id)
);

CREATE TABLE roles
(
  id SERIAL PRIMARY KEY,
  role VARCHAR(20) NOT NULL
);

CREATE TABLE users
(
  id SERIAL PRIMARY KEY,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(40) NOT NULL,
  enabled BOOL DEFAULT '1'
);

CREATE TABLE userrole
(
  role_id INTEGER,
  user_id INTEGER,
  CONSTRAINT userrole_ibfk_2 FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT userrole_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (id)
);
