package com.momo.lambdabasic.function;

import java.util.function.Supplier;

import org.junit.Test;

public class SupplierDemo {

	@Test
	public void demo1() {
		Supplier<String> supplier = () -> {
			return "abc";
		};
		System.out.println(supplier.get());
	}
	
	@Test
	public void demo2() {
		Supplier<String> supplier = () -> "abc";
		System.out.println(supplier.get());
	}
}
