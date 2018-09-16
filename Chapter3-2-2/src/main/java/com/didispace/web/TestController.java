package com.didispace.web;

import com.didispace.dao.UserRepository;
import com.didispace.domain.User;
import com.didispace.domain.Users;
import com.didispace.domain.Weibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/searchUser/{username}")
    public @ResponseBody
    List<User> searchUser(@PathVariable("username") String username) {
        List<User> result = this.userRepository.findByUsernameContaining(username);
        return result;
    }

    @RequestMapping(value="/setUser", method= RequestMethod.GET)
    public String setUser() {
        User user=new User("aaa","bbb");
        Weibo weibo1=new Weibo(user,"text1",new Date());
        Weibo weibo2=new Weibo(user,"text2",new Date());
        Set<Weibo> weiboset=new HashSet<>();
        weiboset.add(weibo1);
        weiboset.add(weibo2);
        user.setWeibos(weiboset);

        userRepository.save(user);
        return "success";
    }
}
