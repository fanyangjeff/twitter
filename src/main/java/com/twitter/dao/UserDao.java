package com.twitter.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    String TABLE_NAME = "users";

    @Select("SELECT COUNT(*) from users where id = #{id}")
    int userExists(int id);

    @Update("UPDATE " + TABLE_NAME + " SET follower_count = follower_count + 1 where id = #{id}")
    void incrementFollowerById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET follower_count = follower_count - 1 where id = #{id}")
    void decrementFollowerById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET followee_count = followee_count + 1 where id = #{id}")
    void incrementFolloweeById(int id);

    @Update("UPDATE " + TABLE_NAME + " SET followee_count = followee_count - 1 where id = #{id}")
    void decrementFolloweeById(int id);

    @Select("SELECT count(*) from follower_followee where follower_id=#{followerId} AND followee_id=#{followeeId}")
    int hasFollowed(@Param("followerId") int followerId, @Param("followeeId") int followeeId);

    @Insert("INSERT INTO follower_followee (follower_id, followee_id) VALUES (#{followerId}, #{followeeId})")
    void createFollowRelationship (@Param("followerId") int followerId, @Param("followeeId") int followeeId);

    @Delete("DELETE from follower_followee where follower_id=#{followerId} AND followee_id=#{followeeId}")
    void removeFollowRelationShip (@Param("followerId") int followerId, @Param("followeeId") int followeeId);


}
