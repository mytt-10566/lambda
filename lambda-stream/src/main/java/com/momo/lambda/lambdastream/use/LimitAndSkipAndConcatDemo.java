package com.momo.lambda.lambdastream.use;

import java.util.stream.Stream;

import org.junit.Test;

public class LimitAndSkipAndConcatDemo {

	// limit对于裁剪无限流的尺寸有用
	@Test
	public void limitDemo1() {
		Stream<Double> stream = Stream.generate(Math::random).limit(100);
	}
	
	// 例如可以跳过某些文档切割后的第一个元素，一般空字符串
	@Test
	public void skipDemo1() {
		Stream<String> stream = Stream.of("", "a", "b").skip(1);
	}
	
	// 连接两个流
	@Test
	public void concatDemo1() {
		Stream<String> stream = Stream.concat(Stream.of("a"), Stream.of("b"));
	}
}
