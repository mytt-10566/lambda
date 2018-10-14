package com.momo.lambda.lambdastream.use;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

public class DistinctAndSortedAndPeakDemo {

	// distinct：剔除重复元素
	@Test
	public void distinctDemo1() {
		Stream<String> stream = Stream.of("a", "a", "b", "b").distinct();
	}
	
	// soted：排序，可以使用Comparator.comparing(Function<? super T, ? extends U> keyExtractor)
	@Test
	public void sortedDemo1() {
		Stream<String> stream = Stream.of("", "a", "b", "de", "lmt").sorted(Comparator.comparing(String::length));
		
		Stream<String> stream2 = Stream.of("", "a", "b", "de", "lmt").sorted((a, b) -> a.length() - b.length());
	}
	
	// 
	@Test
	public void peekDemo1() {
		Object[] objs = Stream
				.iterate(1, p -> p*2)
				.peek(System.out::println)
				.limit(20)
				.toArray();
		System.out.println(Arrays.toString(objs));
	}
}
