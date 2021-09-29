package com.twitter.dao;

import com.twitter.entity.Tweet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TweetDao {
    String TABLE_NAME = "tweets";
    String INSERT_FIELDS = "(content, user_id, created_time)";
    String SELECT_FIELDS = "id,content,user_id userId,created_time createdTime," +
            "like_count likeCount,comment_count commentCount";

    @Insert("INSERT INTO " + TABLE_NAME + INSERT_FIELDS +
            "VALUES (#{content}, #{userId}, #{createdTime})")
    int createTweet(Tweet tweet);

    @Select("SELECT " + SELECT_FIELDS + " FROM " + TABLE_NAME + " where user_id=#{userId}")
    List<Map<String, Object>> findAllTweetsByUserId(@Param("userId") int userId);



}
