package com.momo.lambdabasic.sort;

import javafx.scene.control.Pagination;
import org.junit.Test;

import java.util.*;

/**
 * @author: MQG
 * @date: 2018/10/25
 */
public class Demo {

    @Test
    public void listSortAsc() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(11, 3, 4));

        // 1.8以前的排序方式，当然也可以构造集合中元素类的排序方法
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x - y;
            }
        });

        // 利用lambda传入排序行为
        Collections.sort(list, (Integer x, Integer y) -> x < y ? -1 : 1);

        Collections.sort(list, (x, y) -> x < y ? -1 : 1);

        Collections.sort(list, (x, y) -> x < y ? -1 : 1);

        Collections.sort(list, Comparator.comparing(Integer::intValue));

        System.out.println(list);
        
        list.sort((Integer x, Integer y) -> x - y);

        list.sort((x, y) -> x - y);

        list.sort(Comparator.comparing(Integer::intValue));

        System.out.println(list);
    }

    @Test
    public void listSortDesc() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(11, 3, 4));


        // 利用lambda传入排序行为，下面两种方式都可以
        Collections.sort(list, (x, y) -> y - x);

        list.sort((x, y) -> y < x ? 1 : -1);

        list.sort((x, y) -> y - x);

        System.out.println(list);
        
        // 反转排序
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
        list.sort(comparator.reversed());
        
        System.out.println(list);
    }
    
    // 多条件
    @Test
    public void multiCondition() {
        List<Human> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Human("小明", 20), new Human("小明", 18), new Human("小钧", 19)));

        list.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));

        System.out.println(list);
    }
    
    public static class Human {
        private String name;
        private Integer age;

        public Human() {
        }

        public Human(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
