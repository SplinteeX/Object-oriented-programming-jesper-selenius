package DataStreamsAndExceptions.Task3;

import java.io.Serializable;

public class Student implements Serializable {
    int age;
    String name;
    int id;

    public Student(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
