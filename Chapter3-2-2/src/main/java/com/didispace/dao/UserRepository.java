package com.didispace.dao;

import com.didispace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsernameContaining(String username);

    User getByUsernameIsAndUserpwdIs(String username,String pwd);

    User getByUsernameIs(String username);


}
