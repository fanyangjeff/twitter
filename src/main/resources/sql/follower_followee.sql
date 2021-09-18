drop table if exists `follower_followee`;
create table follower_followee (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    follower_id INT UNSIGNED,
    followee_id INT UNSIGNED,
);