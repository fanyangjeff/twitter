package com.twitter.dao;

import com.twitter.entity.Tweet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TweetDao {
    String TABLE_NAME = "tweets";
    String INSERT_FIELDS = "content, user_id,comment_count,like_count,created_time ";
    @Insert("insert into " + TABLE_NAME + " ( " + INSERT_FIELDS + ")"
            + "values (#{content}, #{userId}, #{commentCount}, #{likeCount}, #{createdTime})")
    int addTweet(Tweet tweet);

}
