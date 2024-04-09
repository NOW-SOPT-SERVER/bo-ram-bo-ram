package org.sopt.classes;

// Person 클래스 정의
public class Person {
    private String name;
    private int age;
    private String sex;

    public void walk() {
        System.out.println("사람이 걷습니다");
    }

    public static void run() {
        System.out.println("사람이 뜁니다.");
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static Person create(String name, int age, String sex) {
        return new Person(name, age, sex);
    }

    public Person(String name, int age) {
        this(name, age, "unknown");
    }


}