drop table if exists `user_tweet_like`;
create table like_user (
                           id INT UNSIGNED AUTO_INCREMENT,
                           user_id INT UNSIGNED,
                           tweet_id INT UNSIGNED,
                           PRIMARY KEY (id)
);