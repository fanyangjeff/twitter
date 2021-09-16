drop table if exists `users`;
create table users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(30),
                       password VARCHAR(100),
                       follower_count INT UNSIGNED,
                       followee_count INT UNSIGNED,
                       date TIMESTAMP,
                       PRIMARY KEY (id)
);