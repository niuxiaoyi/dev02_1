package com.fc.test;

import com.fc.entity.Person;
import org.junit.Test;

import java.util.Date;

public class PersonTest {
    @Test
    public void test() {
        Person.PersonBuilder builder = Person.builder();

        Person person = builder.name("易烊千玺")
                .age(20)
                .birthday(new Date())
                .gender("男")
                .info("真帅")
                .build();

        System.out.println(person);
    }
}
