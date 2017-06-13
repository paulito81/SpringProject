package phasfjo.mysql;

import java.io.Serializable;

/**
 * Created by paulito on 09.06.2017.
 */
public class Student implements Serializable{

    private int age;
    private String name;
    private long id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    Student(){
    }

    public Student(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
