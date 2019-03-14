package com.momo.lambda.lambdastream.minmax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    @Test
    public void testMin() {
        List<Person> personList = new ArrayList<>();
        List<Person> personList2 = Arrays.asList(new Person(1, "a"), new Person(2, "b"), new Person(3, "c"));
        Integer max = personList.stream().map(Person::getAge).max(Integer::compareTo).orElse(0).intValue();
        System.out.println(max);
    }

    public static class Person {

        private Integer age;

        private String name;

        public Person() {
        }

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
