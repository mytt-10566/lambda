package com.momo.lambdabasic.split.constructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Demo {

	class Person {
		
		private String name;
		public Person(String name) {
			this.name = name;
		}
	}
	
	// str -> new Person(str) 等价于 Person::new
	@Test
	public void demo1() {
		List<String> strList = Arrays.asList("a", "b", "c");
		
		Stream<Person> personStrem = strList.stream().map(str -> new Person(str));
		List<Person> personList = personStrem.collect(Collectors.toList());
		
		Stream<Person> personStrem2 = strList.stream().map(Person::new);
		List<Person> personList2 = personStrem2.collect(Collectors.toList());
	}
	
	// Integer[]::new 等价于 n -> new Integer[n]
	@Test
	public void demo2() {
		Function<Integer, Integer[]> func = Integer[]::new;
		Integer[] apply = func.apply(5);
		System.out.println(Arrays.toString(apply));
		
		Function<Integer, Integer[]> func2 = n -> new Integer[n];
		Integer[] apply2 = func2.apply(5);
		System.out.println(Arrays.toString(apply2));
	}
}
