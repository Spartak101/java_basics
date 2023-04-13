package model;

import redis.clients.jedis.Jedis;


import static java.lang.System.out;

public class RedisStorage {

    String host = "127.0.0.1";
    int port = 6379;
    Jedis jedis = new Jedis(host, port);



    void shutdown() {
        jedis.close();
    }

    void allTaskMax(String key){
            out.println(jedis.zrevrangeByScoreWithScores(key, "+inf", "-inf", 0, 3));
    }

    void allTaskMin(String key){
        out.println(jedis.zrangeByScoreWithScores(key, "-inf", "+inf", 0, 3));
    }

    void allDelete(){
        jedis.flushDB();
    }


    // Удаляет
    void deleteTask(String key, String value) {
        jedis.zrem(key, value);
    }

    void addTask(String key, Double score, String value) {
            jedis.zadd(key, score, value);
    }

}
