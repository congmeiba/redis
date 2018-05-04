package cn.gzsxt.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 使用泛型,是可以方便我们以后比如要放入一个User对象也好还是String 对象也好,都可以灵活写入写出
 * @param <String>
 * @param <V>
 */
@Component
public class RedisManager<String,V> {

    @Resource
    private RedisTemplate<String,V> redisTemplate;
    /**
     * 保存到string类型的
     * @param key
     * @param v
     */
    public void setString(String key,V v){
        ValueOperations<String, V> string = redisTemplate.opsForValue();
        string.set(key,v);
    }
    /**
     * 读取string类型的
     * @param key
     * @return
     */
    public V getString(String key){
        ValueOperations<String, V> string = redisTemplate.opsForValue();
        return string.get(key);
    }
    /**
     * 插入到list类型中
     * @param key
     * @param v
     */
    public void setList(String key,V v){
        redisTemplate.opsForList().leftPush(key,v);
    }
    /**
     * 插入hash类型
     * @param key
     * @param hk
     * @param v
     */
    public void setHash(String key,String hk,V v){
        redisTemplate.opsForHash().put(key,hk,v);
    }

    /**
     * 插入hash 类型使用Map来插入
     * @param key
     * @param map
     */
    public void setHash(String key, Map<String,V> map){
        redisTemplate.opsForHash().putAll(key,map);
    }


}
