package model;

import static java.lang.System.out;

public class RedisTest {
    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.addTask("TaskOne", "Купить молока");
        out.println(redis.getTask("TaskOne"));
        redis.addTask("TaskTwo", "Заправить машину");
        redis.addTask("TaskTwo", "Погладить кота");
        out.println(redis.getTask("TaskTwo"));
        redis.addTask("TaskThree", "Покормить кота");
        out.println(redis.getTask("TaskThree"));
        redis.deleteTask("TaskOne");
        redis.deleteTask("TaskTwo");
        redis.deleteTask("TaskThree");
        redis.allTask();

        redis.shutdown();
    }
}
