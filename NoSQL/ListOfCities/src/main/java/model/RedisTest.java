package model;


public class RedisTest {
    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.addTask("Города", 5000.0, "Москва");
        redis.addTask("Города", 50000.0, "Токио");
        redis.addTask("Города", 10000.0, "Норильск");
        redis.addTask("Города", 15000.0, "Омск");
        redis.addTask("Города", 1000.0, "Ставрополь");
        redis.addTask("Города", 3000.0, "Вологда");
        redis.addTask("Города", 30000.0, "Дэли");
        redis.addTask("Города", 25000.0, "Эль-Рияд");
        redis.addTask("Города", 45000.0, "Пекин");
        redis.addTask("Города", 7000.0, "Санкт-петербург");
        redis.allTaskMax("Города");
        redis.allTaskMin("Города");

        redis.shutdown();
    }
}
