package model;

import redis.clients.jedis.Jedis;


import static java.lang.System.out;

public class RedisStorage {

    String nameStudent;
    String nameCourse;
    String countHorses;

    String host = "127.0.0.1";
    int port = 6379;
    Jedis jedis = new Jedis(host, port);



    void shutdown() {
        jedis.close();
    }

    void allTaskKeys(){
        if (jedis.hkeys(nameStudent).isEmpty()){
            out.println("Нет задач");
        } else {
            out.println(jedis.hkeys(nameStudent));
        }
    }
    void allTaskHorses(){
        if (jedis.hvals(nameStudent).isEmpty()){
            out.println("Нет задач");
        } else {
            out.println(jedis.hvals(nameStudent));
        }
    }

    void getNameTable(){
        out.println(jedis.keys("*"));
    }

    void allDelete(){
        jedis.flushDB();
    }


    // Удаляет
    void deleteTask(String nameCourse, String countHorses) {
        out.println("Задача: " + "<" + jedis.hget(nameStudent, nameCourse) + ">" + " выполнена!");
        jedis.hdel(nameStudent, nameCourse);
    }

    void addTask(String nameCourse, String countHorses) {
        if (jedis.hget(nameStudent, nameCourse) != null) {
            out.println("Задача с ключом " + nameCourse + " суещтвует!");
        } else {
            jedis.hset(nameStudent, nameCourse, countHorses);
        }
    }

    void addTaskAbs(String nameCourse, String countHorses){
        out.println("Количество часов для курса: " + nameCourse + " изменено!");
        jedis.hset(nameStudent, nameCourse, countHorses);
    }

    String getTask(String nameCourse){
        return jedis.hget(nameStudent, nameCourse);
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getCountHorses() {
        return countHorses;
    }

    public void setCountHorses(String countHorses) {
        this.countHorses = countHorses;
    }
}
