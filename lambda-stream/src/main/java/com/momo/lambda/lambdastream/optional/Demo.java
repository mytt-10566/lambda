package com.momo.lambda.lambdastream.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class Demo {

	@Test
	public void maxDemo1() {
		Optional<String> max1 = Stream.of("a", "bc", "lmt").limit(0).max(String::compareToIgnoreCase);
		System.out.println(max1.orElse("abcdefg"));
		
		Optional<String> max = Stream.of("a", "bc", "lmt").max(String::compareToIgnoreCase);
		System.out.println(max.orElse("abcdefg"));
	}
	
	@Test
	public void minDemo1() {
		Optional<String> min1 = Stream.of("a", "bc", "lmt").limit(0).min(String::compareToIgnoreCase);
		System.out.println(min1.orElse("abcdefg"));
		
		Optional<String> min2 = Stream.of("a", "bc", "lmt").min(String::compareToIgnoreCase);
		System.out.println(min2.orElse("abcdefg"));
	}
	
	@Test
	public void findFirstDemo1() {
		Optional<String> optional = Stream.of("a", "bc", "lll", "lmt").filter(p -> p.startsWith("l")).findFirst();
		System.out.println(optional.get());
	}
	
	// findAny：适合并行查找，一旦找到就停止
	@Test
	public void findAnyDemo1() {
		for (int i = 0; i < 1000; i++) {
			Optional<String> optional = Arrays.asList("a", "bc", "lmt", "lll", "lmm").parallelStream().filter(p -> p.startsWith("l")).findAny();
			if (!optional.get().equals("lmt")) {
				System.out.println("非lmt, i=" + i);
				break;
			}
		}
	}
	
	// 适合并行
	@Test
	public void anyMatchDemo1() {
		boolean bool = Stream.of("a", "bc", "lmt", "lll", "lmm").parallel().anyMatch(p -> p.startsWith("l"));
		System.out.println(bool);
	}

	// 适合并行
	@Test
	public void allMatchDemo1() {
		boolean bool = Stream.of("a", "bc", "lmt", "lll", "lmm").parallel().allMatch(p -> p.startsWith("l"));
		System.out.println(bool);
	}
	
	// 适合并行
	@Test
	public void noneMatchDemo1() {
		boolean bool = Stream.of("a", "bc", "lmt", "lll", "lmm").parallel().noneMatch(p -> p.startsWith("l"));
		System.out.println(bool);
	}
}
