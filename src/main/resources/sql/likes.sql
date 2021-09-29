drop table if exists `likes`;
create table likes (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       user_id INT UNSIGNED,
                       tweet_id INT UNSIGNED,
                       PRIMARY KEY (id)
);