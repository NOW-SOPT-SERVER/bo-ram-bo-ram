package org.sopt;

import org.sopt.classes.Person;
import org.sopt.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        //Person 클래스의 객체 생성
        Person person = new Person("김보람", 26, "female");
        //Person 클래스 내부 메소드 호출
        person.walk();

        System.out.println(person.getName());

        System.out.println(person.getName());

        person.setName("보람");

        System.out.println(person.getName());

        Person.run();

        Person personWithBuilder = new
                PersonBuilder()
                .name("김보람")
                .age(26)
                .sex("female")
                .build();

        Person personWithFactoryMethod = Person.create("김보람", 26, "female");
    }
}