package com.didispace.web;

import com.didispace.domain.Users;
import com.didispace.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value="/adduser", method= RequestMethod.GET)
    @Transactional
    public String addUser() {
        usersRepository.save(new Users("AAA", 10));
        usersRepository.save(new Users("BBB", 20));
        return "success";
    }

    @RequestMapping(value="/getuser", method=RequestMethod.GET)
    public Users getUser() {
        Users usr=usersRepository.findByName("AAA");
        return usr;
    }
}
