package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author 93Hong on 2019-09-08
 *
 */
public class PrimitiveStreamTest {

	@DisplayName("IntStream and Stream<Integer>")
	@Test
	void test_IntStream_and_StreamInteger() {

		List<TestObject> testObjectList = Lists.newArrayList();
		testObjectList.add(TestObject.builder().name("name").age(10).build());
		testObjectList.add(TestObject.builder().name("age").age(20).build());


		// Operate with integerStream
		Stream<Integer> integerStream = testObjectList.stream()
			.map(TestObject::getAge);
		int sumWithStream = integerStream
			.reduce(0, Integer::sum);

		// Operate with intStream
		IntStream intStream = testObjectList.stream()
			.mapToInt(TestObject::getAge);
		int sumWithPrimitiveStream = intStream
			.sum();

		assertThat(sumWithStream).isEqualTo(sumWithPrimitiveStream);

		// intStream <-> Stream<Integer>
		final Stream<Integer> boxed = intStream.boxed();
		final IntStream unboxed = integerStream.mapToInt(Integer::intValue);
	}

}

