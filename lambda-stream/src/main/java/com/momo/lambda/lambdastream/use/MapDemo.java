package com.momo.lambda.lambdastream.use;

import java.util.stream.Stream;

import org.junit.Test;

public class MapDemo {

	@Test
	public void demo1() {
		Stream<String> stream = Stream.of("a", "b", "cd", "efg").map(String::toLowerCase);
		
		Stream<String> stream2 = Stream.of("a", "b", "cd", "efg").map(value -> value.substring(0, 1));
		
		// ?
//		Stream<String> stream2 = Stream.of("a", "b", "cd", "efg").flatMap(val);
	}
}
