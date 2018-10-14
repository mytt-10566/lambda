package com.momo.lambda.lambdastream.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Demo {

	@Test
	public void forEach1() {
		Stream.of("a", "b", "c")
			.forEach(System.out::println);
		
		// 并行，无序
		Stream.of("a", "b", "c")
			.parallel()
			.forEach(System.out::println);
		
		// 并行，有序
		Stream.of("a", "b", "c")
			.parallel()
			.forEachOrdered(System.out::println);
	}
	
	@Test
	public void toArray1() {
		Object[] array1 = Stream.of("a", "b", "c").toArray();
		
		String[] array2 = Stream.of("a", "b", "c").toArray(String[]::new);
	}
	
	@Test
	public void collect1() {
		// list
		// 1.ArrayList
		List<String> arrayList = Stream.of("a", "b", "c").collect(Collectors.toList());
		System.out.println(arrayList.getClass().getName());
		
		// 2.指定为ArrayList
		ArrayList<String> arrayList2 = Stream.of("a", "b", "c").collect(Collectors.toCollection(ArrayList::new));
		
		// 3.
		LinkedList<String> strLinkedList = Stream.of("a", "b", "c").collect(Collectors.toCollection(LinkedList::new));
		
		// 4.
		Vector<String> strVector = Stream.of("a", "b", "c").collect(Collectors.toCollection(Vector::new));
		
		
		// set
		// 1.
		Set<String> strSet = Stream.of("a", "b", "c").collect(Collectors.toSet());
		// 2.
		TreeSet<String> strTreeSet = Stream.of("a", "b", "c").collect(Collectors.toCollection(TreeSet::new));
	}
	
	@Test
	public void join1() {
		String result = Stream.of("a", "b", "c").collect(Collectors.joining());
		
		String result2 = Stream.of("a", "b", "c").collect(Collectors.joining(","));
		System.out.println(result2);
	}
	
	@Test
	public void summary1() {
		IntSummaryStatistics summary = Stream.of("a", "b", "c").collect(Collectors.summarizingInt(String::length));
		double average = summary.getAverage();
		int maxLength = summary.getMax();
	}
	
	@Test
	public void map1() {
		Map<Integer, String> personMap = Stream
				.of(new Person(1, "小明"), new Person(2, "小名"))
				.collect(Collectors.toMap(Person::getId, Person::getName));
		
		Map<Integer, Person> personMap2 = Stream
			.of(new Person(1, "小明"), new Person(2, "小名"))
			.collect(Collectors.toMap(Person::getId, Function.identity()));
		
		// key相同，使用第一次存储的值
		Map<Integer, Person> personMap3 = Stream
				.of(new Person(1, "小明"), new Person(1, "小名"))
				.collect(Collectors.toMap(
						Person::getId, 
						Function.identity(), 
						(existValue, newValue) -> existValue));
		for (Map.Entry<Integer, Person> entry : personMap3.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue().getName());
		}
	}
	
	@Test
	public void map2() {
		// public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(
		//				  Function<? super T, ? extends K> keyMapper,
		//                Function<? super T, ? extends U> valueMapper,
		//                BinaryOperator<U> mergeFunction) {
		//	return toMap(keyMapper, valueMapper, mergeFunction, HashMap::new);
		//}
		
		// HashMap（默认，参考API）
		Map<String, Set<String>> countryLanguageMap = Stream
				.of(Locale.getAvailableLocales())
				.collect(Collectors.toMap(
						Locale::getDisplayCountry, 
						l -> Collections.singleton(l.getDisplayLanguage()),
						(a, b) -> {
							Set<String> union = new HashSet<>();
							union.addAll(b);
							return union;
						}));
		
		// TreeMap
		TreeMap<String, Set<String>> countryLanguageMap2 = Stream
				.of(Locale.getAvailableLocales())
				.collect(Collectors.toMap(
						Locale::getDisplayCountry, 
						l -> Collections.singleton(l.getDisplayLanguage()),
						(a, b) -> {
							Set<String> union = new HashSet<>();
							union.addAll(b);
							return union;
						},
						TreeMap::new));
		
		for (Map.Entry<String, Set<String>> entry : countryLanguageMap.entrySet()) {
			System.out.println(entry.getKey() + "：" + entry.getValue().stream().collect(Collectors.joining(",")));
		}
	}
	
	private class Person {
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
