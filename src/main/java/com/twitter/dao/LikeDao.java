package com.twitter.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LikeDao {
    String TABLE_NAME = "likes";
    String INSERT_FIELDS = "(user_id, tweet_id)";

    @Insert("INSERT INTO " + TABLE_NAME + INSERT_FIELDS + "VALUES (#{userId}, #{tweetId})")
    void createLike(@Param("userId") int userId, @Param("tweetId") int tweetId);

    
}
