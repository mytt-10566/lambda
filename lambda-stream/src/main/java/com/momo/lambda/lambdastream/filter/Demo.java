package com.momo.lambda.lambdastream.filter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo {

    @Test
    public void testFilter() {
        List<Integer> numList = Arrays.asList(-1, -2, 0, 1, 2, 3);

        // true表示满足条件不过滤
        List<Integer> resultList = numList.stream().filter(num -> num > 0).collect(Collectors.toList());
        System.out.println(resultList);
    }

    @Test
    public void testFilterUpdate() {
        List<Person> personList = Arrays.asList(new Person(1, "张三"), new Person(2, "李四"));

        Optional<Person> optionalPerson = personList.stream().filter(item -> item.getId() == 1).findFirst();
        Person person = null;
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
            person.setName("王五");
        }
        System.out.println(personList.get(0) == person);// true
    }


    public static class Person {
        private Integer id;

        private String name;

        public Person() {
        }

        public Person(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
