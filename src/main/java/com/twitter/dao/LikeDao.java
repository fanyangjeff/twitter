package com.twitter.dao;

import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeDao {
    String TABLE_NAME = "likes";
    String INSERT_FIELDS = "(user_id, tweet_id)";

    @Insert("INSERT INTO " + TABLE_NAME + INSERT_FIELDS + "VALUES (#{userId}, #{tweetId})")
    int createLike(@Param("userId") int userId, @Param("tweetId") int tweetId);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE user_id = #{userId} AND tweet_id = #{tweetId}")
    int removeLike(@Param("userId") int userId, @Param("tweetId") int tweetId);

}
