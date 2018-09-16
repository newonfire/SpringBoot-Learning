package com.didispace.web;

import com.didispace.dao.UserRepository;
import com.didispace.dao.WeiboRepository;
import com.didispace.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.beans.Transient;

@RestController
public class WeboController {

    @Autowired
    private WeiboRepository weiboRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/setWeibo",method = RequestMethod.GET)
    public String setWeibo(){
        User user=new User("name","pwd");
        weiboRepository.setUserWeiboContent("aaa",user);
        return "success";
    }

    @RequestMapping(value="/setWeibo2",method = RequestMethod.GET)
    public String setWeibo2(){
            User user=userRepository.getByUsernameIs("aa1");
        weiboRepository.setUserWeiboContent("aaabbb112",user);
        return "success";
    }
}
