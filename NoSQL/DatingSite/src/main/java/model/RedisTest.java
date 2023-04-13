package model;


public class RedisTest {
    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.allDelete();
        redis.setCountUsers(20);
        redis.setMaxRandomRange(10);
        redis.setUpdateFrequency(1000);
        redis.createUsers();
        redis.allTask();
        redis.action();
        redis.allDelete();

        redis.shutdown();
    }
}
