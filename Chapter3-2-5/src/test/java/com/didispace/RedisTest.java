package com.didispace;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.didispace.service.RedisService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RedisTest {
	@Resource
	private RedisService redisService ;

	@Test
	public void demoTest(){
        redisService.set("abc2","value22222");
    }
}
