package com.momo.lambda.lambdastream.use;

import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

public class FilterDemo {

	@Test
	public void demo1() {
		// filter(Predicate<? super T> predicate)：T - boolean
		Stream<String> stream = Stream.of("a", "b", "cd", "efg").filter(value -> value.length() > 1);
	}
}
