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

    void allTask(){
        if (jedis.keys("*").isEmpty()){
            out.println("Нет задач");
        } else {
            out.println(jedis.keys("*"));
        }
    }

    void allDelete(){
        jedis.flushDB();
    }


    // Удаляет
    void deleteTask(String key) {
        out.println("Задача: " + "<" +jedis.get(key) + ">" + " выполнена!");
        jedis.del(key);
    }

    void addTask(String key, String value) {
        if (jedis.get(key) != null) {
            out.println("Задача с ключом " + key + " суещтвует!");
        } else {
            jedis.set(key, value);
        }
    }

    String getTask(String key){
        return jedis.get(key);
    }
}
