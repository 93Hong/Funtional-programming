package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 *
 * @author 93Hong on 2019-09-01
 *
 */
class LambdaTest {

	private static boolean test(String s) {
		return s.length() > 3;
	}

	@DisplayName("A stream should be operated on (invoking an intermediate or terminal stream operation) only once.")
	@Test
	void test_operated_multiply() {
		List<TestObject> testObjectList = Lists.newArrayList();

		testObjectList.add(TestObject.builder().name("name").age(10).build());
		testObjectList.add(TestObject.builder().name("age").age(20).build());

		Stream<String> stringStream = testObjectList.stream().map(TestObject::getName);

		final long count = stringStream.filter(s -> s.length() > 3).count();

		assertThatThrownBy(() -> {
			long count1 = stringStream.filter(s -> s.length() > 4).count();
		}).isInstanceOf(IllegalStateException.class);

		Stream<Integer> test = testObjectList
			.stream()
			.map(TestObject::getAge);

		test.forEach(System.out::println);

		IntStream test1 = testObjectList
			.stream()
			.mapToInt(TestObject::getAge);

		test1.forEach(System.out::println);
		test1.close();
	}

}