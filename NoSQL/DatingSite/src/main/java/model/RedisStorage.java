package model;

import lombok.Data;
import redis.clients.jedis.Jedis;


import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

@Data
public class RedisStorage {

    int countUsers;
    int maxRandomRange;
    int updateFrequency;
    double score;

    String key = "Dating_site";


    String host = "127.0.0.1";
    int port = 6379;
    Jedis jedis = new Jedis(host, port);


    void shutdown() {
        jedis.close();
    }

    void allTask() {
        out.println(jedis.zrangeByScore(key, "-inf", "+inf", 0, 1));
    }

    String getTask() {
       return jedis.zrangeByScore(key, "-inf", "+inf", 0, 1).get(0);

    }

    void allDelete() {
        jedis.flushDB();
    }

    void upUser(String value){
        double scoreNow = jedis.zscore(key, value);
        double scoreTop = jedis.zscore(key, getTask());
        double score1 = scoreNow + (scoreTop - scoreNow - 1);
        jedis.zadd(key, score1, value);
    }

    void downUser(String value) {
        score = (double) new Date().getTime();
        jedis.zadd(key, score, value);
    }


    // Удаляет
    void deleteTask(String value) {
        jedis.zrem(key, value);
    }

    void addTask(String value) {
        score = (double) new Date().getTime();
        jedis.zadd(key, score, value);
    }

    void createUsers() {
        for (int i = 1; i < countUsers + 1; i++) {
            addTask(String.valueOf(i));
            out.println(i);
        }
    }


    void action() {
        Random random = new Random();
        int intRandom = random.nextInt(1, 10);
        int count = 1;
        while (countUsers > 0) {
            if (count > 10) {
                count = 1;
            }
            if (count == intRandom) {
                intRandom = random.nextInt(1, 10);
                int randomIdUser = random.nextInt(1, countUsers);
                String idUser = String.valueOf(jedis.zrank(key, String.valueOf(randomIdUser)));
                out.println("Пользователь " + idUser + " оплатил платную услугу");
                upUser(idUser);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            out.println("На главной странице показываем пользователя " + getTask());
            downUser(getTask());
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
