package com.didispace.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * author 程序猿DD
 * version 1.0.0
 * date 16/3/23 下午2:34.
 * blog http://blog.didispace.com
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByName(String name);

    Users findByNameAndAge(String name, Integer age);

    @Query("from Users u where u.name=:name")
    Users findUser(@Param("name") String name);


}
