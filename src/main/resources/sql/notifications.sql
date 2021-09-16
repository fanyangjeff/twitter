drop table if exists `notifications`;
create table notifications (
                               id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                               user_one_id int NOT NULL DEFAULT 0,
                               user_two_id int NOT NULL DEFAULT 0,
                               message VARCHAR(256) NOT NULL DEFAULT '',
                               is_read int NOT NULL DEFAULT 0,
                               date TIMESTAMP,
                               PRIMARY KEY (id)
);