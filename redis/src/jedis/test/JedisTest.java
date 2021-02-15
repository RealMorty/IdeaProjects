package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username", "morty");

        jedis.close();

    }
    @Test
    public void test2() {
        Jedis jedis = new Jedis();//默认
        jedis.set("username", "morty");
        String username = jedis.get("username");
        System.out.println(username);

        jedis.setex("activecode",20,"hehe");
        jedis.close();

    }
    @Test
    public void test3() {
        Jedis jedis = new Jedis();//默认
        jedis.hset("user","name","Morty");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        String hget = jedis.hget("user", "name");
        System.out.println(hget);

        Map<String,String> userMap = jedis.hgetAll("user");

        Set<String> stringSet = userMap.keySet();
        for (String key : stringSet) {
            System.out.println(key+":"+userMap.get(key));
        }

        jedis.close();

    }
    @Test
    public void test4() {
        Jedis jedis = new Jedis();//默认
        jedis.lpush("myList","a","b","c");
        jedis.rpush("myList","a","b","c");

        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);

        String element = jedis.lpop("myList");
        System.out.println(element);

        String element1 = jedis.rpop("myList");
        System.out.println(element1);

        List<String> myList1 = jedis.lrange("myList", 0, -1);
        System.out.println(myList1);

        jedis.close();

    }
    @Test
    public void test5() {
        Jedis jedis = new Jedis();//默认

        jedis.sadd("myset","java","php","c++");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();

    }
    @Test
    public void test6() {
        Jedis jedis = new Jedis();//默认

        jedis.zadd("mysortedset",3,"鲁班");
        jedis.zadd("mysortedset",1,"亚瑟");
        jedis.zadd("mysortedset",7,"后羿");
        Set<String> mayst = jedis.zrange("mysortedset",0,-1);
        System.out.println(mayst);
        jedis.close();

    }

    @Test
    public void test7() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        Jedis resource = jedisPool.getResource();
        resource.set("hehe","hh");
        resource.close();
    }

    @Test
    public void test8() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("he","hehe");
        jedis.close();
    }
}
