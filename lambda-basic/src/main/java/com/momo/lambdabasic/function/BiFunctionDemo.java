package com.momo.lambdabasic.function;

import java.util.function.BiFunction;

import org.junit.Test;

public class BiFunctionDemo {

	@Test
	public void demo1() {
		BiFunction<String, String, Integer> func = (String first, String second) -> {
			return first.length() - second.length();
		};
		int count = func.apply("abc", "d");
		System.out.println(count);
	}
	
	// 无需声明变量
	@Test
	public void demo2() {
		BiFunction<String, String, Integer> func = (first, second) -> {
			return first.length() - second.length();
		};
		int count = func.apply("abc", "d");
		System.out.println(count);
	}
	
	@Test
	public void demo3() {
		BiFunction<String, String, Integer> func = (String first, String second) -> {
			return first.length() - second.length();
		};
		int count = func.apply("abc", "d");
		System.out.println(count);
	}
	
	private void demo2Extend(BiFunction<String, String, Integer> func) {
	}
}
