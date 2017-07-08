CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(40) NOT NULL,
  enabled tinyint(1) DEFAULT 1,
  PRIMARY KEY (id),
  UNIQUE KEY users_username_uindex (username)
);


create table roles (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  role VARCHAR(20) UNICODE NOT NULL
);

create table userrole (
  role_id INT,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id)
);

create TABLE photo
(
  id        INT AUTO_INCREMENT PRIMARY KEY,
  photo     LONGBLOB,
  extention VARCHAR(4)
);

create TABLE news
(
  id              INT AUTO_INCREMENT PRIMARY KEY,
  postDate        DATETIME,
  title           VARCHAR(50),
  description     VARCHAR(500)
);

create table newsphoto (
  news_id INT,
  photo_id INT,
  FOREIGN KEY (news_id) REFERENCES news (id),
  FOREIGN KEY (photo_id) REFERENCES photo (id)
);