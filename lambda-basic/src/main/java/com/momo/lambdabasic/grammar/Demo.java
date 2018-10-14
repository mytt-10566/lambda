package com.momo.lambdabasic.grammar;

import java.awt.event.ActionListener;
import java.util.function.BiFunction;

import org.junit.Test;

public class Demo {

	/*
	 * 格式1：(String a, String b, ...) -> a.length() - b.length()
	 * 格式2：(a, b) -> a.length() - b.length()
	 * 格式3：() -> System.out.println("123");
	 * 格式4：() -> { System.out.println("123"); }
	 * 格式5：a -> System.out.println(a);
	 * */
	
	@Test
	public void demo1() {
		BiFunction<String, String, Integer> func = (String first, String second) -> {
			return first.length() - second.length();
		};
		int count = func.apply("abc", "d");
		System.out.println(count);
	}
	
	// 无需声明变量类型，根据BiFunction<String, String, Integer>泛型自动推导
	@Test
	public void demo2() {
		BiFunction<String, String, Integer> func = (first, second) -> {
			return first.length() - second.length();
		};
		int count = func.apply("abc", "d");
		System.out.println(count);
	}
	
	// 只有一个参数，可以不用()
	@Test
	public void demo3() {
		ActionListener ac = event -> {
			System.out.println(event);
		};
	}
	
	// 无参，需要()
	@Test
	public void demo4() {
		Runnable target = () -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(System.currentTimeMillis());
			}
		};
		
		new Thread(target).start();
	}
	
}
