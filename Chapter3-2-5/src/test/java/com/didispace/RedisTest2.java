package com.didispace;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.didispace.util.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RedisTest2 {
	@Resource
	private RedisUtil redisUtil ;

	@Test
	public void demoTest(){
		redisUtil.set("1","value22222");
    }
}
