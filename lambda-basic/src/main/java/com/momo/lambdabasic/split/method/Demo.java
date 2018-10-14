package com.momo.lambdabasic.split.method;

import java.util.Arrays;

import javax.swing.Timer;

import org.junit.Test;

/*
 * 方法应用的3种方式：
 * 	object::instanceMethod：
 * 		this::instanceMethod：this::equals 等价于 x -> this.equals(x)
 * 		super:instanceMethod：super::equals 等价于 x -> super.equals(x)
 * 	Class::staticMethod
 * 	Class::instanceMethod：第一个参数成为方法的目标，见下面的实例
 * */
public class Demo {
	
	// 第一种方式：object::instanceMethod
	@Test
	public void demo1() {
//		String[] strings = { "za", "bc", "def" };
//		Arrays.sort(strings, (a, b) -> a.compareToIgnoreCase(b));
//		System.out.println(Arrays.toString(strings));
//		
//		String[] strings2 = { "za", "bc", "def" };
//		String str = "abcdefg";
//		Arrays.sort(strings2, String::compareToIgnoreCase);
//		System.out.println(Arrays.toString(strings2));
	}

	// 第二种方式：Class::staticMethod
	// event -> System.out.println(event) 等价于 System.out::println
	@Test
	public void demo2() {
		Timer timer = new Timer(1000, event -> System.out.println(event));
		timer.start();

		Timer timer2 = new Timer(1000, System.out::println);
		timer2.start();
	}

	// 第三种方式：Class::instanceMethod
	// (a, b) -> a.compareToIgnoreCase(b) 等价于 String::compareToIgnoreCase
	@Test
	public void demo3() {
		String[] strings = { "za", "bc", "def" };
		Arrays.sort(strings, (a, b) -> a.compareToIgnoreCase(b));
		System.out.println(Arrays.toString(strings));
		
		String[] strings2 = { "za", "bc", "def" };
		Arrays.sort(strings2, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(strings2));
	}
	
	
	// this::instanceMethod
	@Test
	public void demo4() {
		Timer timer = new Timer(1000, this::equals);
		timer.start();
	}
	
	// super::instanceMethod
	@Test
	public void myEquals() {
		Timer timer = new Timer(1000, super::equals);
		timer.start();
	}
	
}
