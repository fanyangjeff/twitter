drop table if exists `comments`;
create table comments (
                          id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                          content VARCHAR(4000),
                          user_id INT UNSIGNED,
                          tweet_id INT UNSIGNED,
                          date TIMESTAMP,
                          PRIMARY KEY (id)
);