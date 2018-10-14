package com.momo.lambda.lambdastream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

// 约简操作 - reduce
public class Demo {

	@Test
	public void demo1() {
		// 1 + 2 + 3 + 4
		List<Integer> values = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> sum = values.stream().reduce((x, y) -> x + y);
		System.out.println(sum.get());
		
		Optional<Integer> sum2 = values.stream().reduce(Integer::sum);
		System.out.println(sum.get());
		
		Integer sum3 = values.stream().reduce(0, Integer::sum);
		System.out.println(sum3);
	}
}
