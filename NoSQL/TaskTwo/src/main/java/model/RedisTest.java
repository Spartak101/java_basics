package model;

import static java.lang.System.out;

public class RedisTest {
    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.allDelete();
        redis.setNameStudent("Иванов И.И.");
        String nameStudent = redis.getNameStudent();
        redis.setNameCourse("Web-Разработчик");
        String nameCourseOne = redis.getNameCourse();
        redis.setNameCourse("Data Science");
        String nameCourseTwo = redis.getNameCourse();
        redis.setCountHorses("1");
        String countHorsesOne = redis.getCountHorses();
        redis.setCountHorses("4");
        String countHorsesTwo = redis.getCountHorses();
        redis.addTask(nameCourseOne, countHorsesOne);
        redis.addTask(nameCourseTwo, countHorsesTwo);
        redis.getNameTable();
        redis.allTaskKeys();
        redis.allTaskHorses();
        countHorsesTwo = String.valueOf((Integer.parseInt(redis.getTask(nameCourseTwo)) + 1));
        redis.addTaskAbs(nameCourseTwo, countHorsesTwo);
        redis.getTask(nameCourseTwo);
        redis.allTaskHorses();

        redis.shutdown();
    }
}
