drop table if exists `tweets`;
create table tweets (
                        id INT UNSIGNED AUTO_INCREMENT NOT NULL ,
                        content VARCHAR(4000) DEFAULT '' NOT NULL ,
                        user_id INT DEFAULT 0 NOT NULL ,
                        created_time TIMESTAMP,
                        comment_count BIGINT NOT NULL DEFAULT 0,
                        like_count BIGINT NOT NULL DEFAULT 0,
                        PRIMARY KEY (id)
);