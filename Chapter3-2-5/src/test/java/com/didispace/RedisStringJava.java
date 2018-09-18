package com.didispace;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
	public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("47.52.171.133"); // 默认端口
        //Jedis jedis = new Jedis("10.80.248.22",6379); // 指定端口
         jedis.auth("heyj"); // 指定密码
        System.out.println("Connection to server sucessfully");
        // 设置 redis 字符串数据
        jedis.set("redis", "Redis 2");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: " + jedis.get("redis")); 
        System.out.println("redis : " + jedis.get("redis"));
}
}
