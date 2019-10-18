DROP TABLE IF EXISTS USER;
  
CREATE TABLE USER (
  user_id VARCHAR(50)  PRIMARY KEY,
  first_name VARCHAR(200) NOT NULL,
  last_name VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  login VARCHAR(50) NOT NULL,
  password_enc VARCHAR(50) NOT NULL,
  created_on TIMESTAMP,
  created_by VARCHAR(50),
  updated_on TIMESTAMP,
  updated_by VARCHAR(50),
  status TINYINT(1) DEFAULT 0
);

DROP TABLE IF EXISTS PROJECT;
  
CREATE TABLE PROJECT (
  project_id INT AUTO_INCREMENT NOT NULL,
  user_id VARCHAR(50) NOT NULL,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(500) NOT NULL,
  status VARCHAR(10) DEFAULT 'ACTIVE' NOT NULL,
  bid_end_date TIMESTAMP NOT NULL, 
  primary key(project_id)
);

alter table PROJECT add constraint FKcaf6ht0hfw93lwc13ny0sdmvo foreign key (user_id) references USER(user_id);



DROP TABLE IF EXISTS PROJECT_BID;

CREATE TABLE BID (
  bid_id INT AUTO_INCREMENT NOT NULL,
  project_id INT NOT NULL,
  user_id VARCHAR(50) NOT NULL,
  bid_amount DECIMAL NOT NULL, 
  primary key(bid_id)
);

alter table PROJECT add constraint FKbdf6wt0hfw45lwc89ca1tmtov foreign key (project_id) references PROJECT(project_id);
alter table PROJECT add constraint FKubb7cw1poc45lre62de1samst foreign key (user_id) references USER(user_id);