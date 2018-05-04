package cn.gzsxt.test;


import cn.gzsxt.utli.JedisUtli;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Demo01 {


    @Test
    public void conn(){
        Jedis jedis = JedisUtli.getConn();
        System.out.println("连接jredis正常");
        System.out.println("测试是否正常运行"+jedis.ping());
        System.out.println("redis服务器信息?"+jedis.info());
    }

    @Test
    public void testString(){
        Jedis jedis = JedisUtli.getConn();
        String mykey = jedis.get("mykey");
        System.out.println(mykey);
        String set = jedis.set("testString", "Hello wolrd");
        System.out.println(set);
        String testString = jedis.getrange("testString", 0, -2);
        System.out.println(testString);
        jedis.setbit("c",30,"1");
        jedis.setbit("c",100,"1");
        Long bitcount = jedis.bitcount("c");
        System.out.println(bitcount);
    }


    @Test
    public void testList(){
        Jedis conn = JedisUtli.getConn();
        conn.del("list");
        conn.lpush("list","java","python","c++");
        List<String> list = conn.lrange("list", 0, -1);
        for (String str: list
             ) {
            System.out.println(str);
        }
    }

    @Test
    public void testHash(){
        Jedis conn = JedisUtli.getConn();
        conn.del("testHash");
        conn.hset("testHash","qq","472801225");
        Map<String,String> map = new HashMap<String, String>();
        map.put("wx","13924027112");
        map.put("gender","1");
        conn.hmset("testHash",map);
        Map<String, String> testHash = conn.hgetAll("testHash");
        System.out.println(testHash.get("gender"));
        System.out.println(testHash.get("qq"));
    }


    @Test
    public void testSet(){
        Jedis conn = JedisUtli.getConn();
        conn.del("testSet");
        conn.sadd("testSet","java","python","oracle","c++");
        Set<String> testSet = conn.smembers("testSet");
        for (String str:testSet
             ) {
            System.out.println(str);
        }
    }

    @Test
    public void testSortSet(){
        Jedis conn = JedisUtli.getConn();
        conn.del("testSortSet");
        Map<String,Double> map = new HashMap<String, Double>();
        map.put("java",1.0);
        map.put("redis",2.0);
        map.put("c++",3d);
        map.put("oracle",4d);
        conn.zadd("testSortSet",map);
        Set<String> testSortSet = conn.zrange("testSortSet", 0, -1);
        for (String str: testSortSet
             ) {
            System.out.println(str);
        }
    }



}
