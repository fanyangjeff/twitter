package com.twitter.dao;

import com.twitter.entity.Tweet;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TweetDao {
    String TABLE_NAME = "tweets";
    String INSERT_FIELDS = "(content, user_id, created_time)";
    String SELECT_FIELDS = "id,content,user_id userId,created_time createdTime," +
            "like_count likeCount,comment_count commentCount";

    //insert a tweet, the database will initialize like_count and comment_count to zero
    @Insert("INSERT INTO " + TABLE_NAME + INSERT_FIELDS +
            "VALUES (#{content}, #{userId}, #{createdTime})")
    int createTweet(Tweet tweet);

    //get all the tweets posted by one person
    @Select("SELECT " + SELECT_FIELDS + " FROM " + TABLE_NAME + " WHERE user_id=#{userId}")
    List<Map<String, Object>> findAllTweetsByUserId(@Param("userId") int userId);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    Map<String, Object> getTweetById(int id);

    @Select("SELECT * FROM " + TABLE_NAME + " ORDER BY created_time DESC LIMIT 10")
    List<Map<String, Object>> getMostTenRecentTweets();

    //delete a tweet by tweet id
    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id}")
    void deleteTweetById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET like_count = #{updatedLikeCount} WHERE id = #{id}")
    void updateLikeCount(@Param("updatedLikeCount") int updatedLikeCount, @Param("id") int id);

}
