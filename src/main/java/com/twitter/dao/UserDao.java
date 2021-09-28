package com.twitter.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    String TABLE_NAME = "users";

    @Select("SELECT COUNT(*) from users where id = #{id}")
    int userExists(int id);


    /*
    follow and unfollow operations
     */
    @Update("UPDATE " + TABLE_NAME + " SET follower_count = follower_count + 1 where id = #{id}")
    void incrementFollowerById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET follower_count = follower_count - 1 where id = #{id}")
    void decrementFollowerById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET followee_count = followee_count + 1 where id = #{id}")
    void incrementFolloweeById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET followee_count = followee_count - 1 where id = #{id}")
    void decrementFolloweeById(int id);

    @Select("SELECT u.username, u.id from users as u, follower_followee as f " +
            "where f.follower_id = #{id} AND f.followee_id = u.id")
    List<Map<String, Object>> getFolloweeListById(int id);

    @Select("SELECT u.username, u.id from users as u, follower_followee as f " +
            "where f.followee_id = #{id} AND f.follower_id = u.id")
    List<Map<String, Object>> getFollowerListById(int id);

    @Select("SELECT count(*) from follower_followee where follower_id=#{followerId} AND followee_id=#{followeeId}")
    int hasFollowed(@Param("followerId") int followerId, @Param("followeeId") int followeeId);

    @Insert("INSERT INTO follower_followee (follower_id, followee_id) VALUES (#{followerId}, #{followeeId})")
    void createFollowRelationship (@Param("followerId") int followerId, @Param("followeeId") int followeeId);

    @Delete("DELETE from follower_followee where follower_id=#{followerId} AND followee_id=#{followeeId}")
    void removeFollowRelationShip (@Param("followerId") int followerId, @Param("followeeId") int followeeId);


}
