package cn.gzsxt.utli;

import redis.clients.jedis.Jedis;

public class JedisUtli {

    private static Jedis jedis;


    static{
        jedis = new Jedis("192.168.232.140");
    }


    public static Jedis getConn(){
        return jedis;
    }
}
