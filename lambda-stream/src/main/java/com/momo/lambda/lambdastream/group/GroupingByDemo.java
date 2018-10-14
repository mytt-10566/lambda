package com.momo.lambda.lambdastream.group;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class GroupingByDemo {

	// 分组
	@Test
	public void demo1() {
		Map<String, List<Locale>> counryToLocales = 
				Stream
					.of(Locale.getAvailableLocales())
					.collect(Collectors.groupingBy(Locale::getCountry));
		
		for (Map.Entry<String, List<Locale>> entry : counryToLocales.entrySet()) {
			System.out.print(entry.getKey() + "：");
			
			for (Locale locale : entry.getValue()) {
				System.out.print(locale.toString() + ",");
			}
			System.out.println();
		}
	}
	
	// 分类函数是断言函数（返回boolean值的函数），流的元素可以分区为两个列表
	@Test
	public void demo2() {
		Map<Boolean, List<Locale>> englishAndOtherLocales = Stream
			.of(Locale.getAvailableLocales())
			.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
		List<Locale> enList = englishAndOtherLocales.get(Boolean.TRUE);
		for (Locale locale : enList) {
			System.out.println(locale.getCountry());
		}
	}
	
	// 指定下游收集器类型
	// groupingBy - toSet
	@Test
	public void demo3() {
		Map<String, Set<Locale>> countryToLocalSet = Stream
			.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
	}
	
	// 下游收集器 - Collectors.counting()
	@Test
	public void demo4() {
		Map<String, Long> countryToLocalCount = Stream
			.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
	}
	
	// groupingBy - summingInt
	@Test
	public void demo5() {
		Map<String, Integer> countryToLocalSet = Stream
			.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(Locale::getCountry, Collectors.summingInt(l -> l.getCountry().length())));
	}
	
	// groupingBy - maxBy
	@Test
	public void demo6() {
		Map<String, Optional<Locale>> countryToLocalSet = Stream
			.of(Locale.getAvailableLocales())
			.collect(Collectors.groupingBy(
							Locale::getCountry, 
							Collectors.maxBy(Comparator.comparing(l -> l.getCountry().length()))));
	}
	
	@Test
	public void demo7() {
		Map<String, Optional<String>> collect = Stream
					.of(Locale.getAvailableLocales())
					.collect(Collectors.groupingBy(
						Locale::getCountry, 
						Collectors.mapping(Locale::getCountry, Collectors.maxBy(Comparator.comparing(String::length)))));
	}
	
	// 
	@Test
	public void demo8() {
		Map<String, Set<String>> collect = Stream
					.of(Locale.getAvailableLocales())
					.collect(Collectors.groupingBy(
						Locale::getCountry, 
						Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
	}
}
