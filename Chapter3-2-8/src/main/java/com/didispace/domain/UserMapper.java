package com.didispace.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM users")
    List<User> findAll();

    @Insert("INSERT INTO users(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE users SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

    @Insert("INSERT INTO users(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO users(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

}