package com.momo.lambda.lambdastream.create;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 创建流常见的几种方式
 * */
public class Demo {

	// 1.Collection#stream() 或 Collection#parallelStream()
	@Test
	public void demo1() {
		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		Stream<String> stream = strList.stream();
	}

	// 2. Stream.of(T..)
	@Test
	public void demo2() {
		Stream<String> stream = Stream.of("a", "b", "c");
	}

	// 3. Arrays.stream([])
	@Test
	public void demo3() {
		Stream<String> stream = Arrays.stream(new String[] { "a", "b" });
		
		Stream<String> stream2 = Arrays.stream(new String[] { "a", "b" }, 0, 1);
	}
	
	// 4.空流 Stream.empty()
	@Test
	public void demo4() {
		Stream<String> empty = Stream.empty();
	}
	
	// 5.无限流
	@Test
	public void demo5() {
		// 参数：Supplier<T>
		Stream<String> stream = Stream.generate(() -> "123");
		
		// 无限序列
		// 第二个参数：UnaryOperator<T> 一元操作符
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ZERO));
	}
	
	// 6.Pattern.compile(regex).splitAsStream(input)
	public void demo6() {
		Stream<String> words = Pattern.compile("\\m").splitAsStream("abcdefhijklmn");
	}
	
	// 7.Files
	public void demo7() throws Exception {
		Path path = Paths.get("aabbcc.txt");
		Stream<String> stream = Files.lines(path);
	}
}
