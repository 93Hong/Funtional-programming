package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author 93Hong on 2019-10-01
 *
 */
public class StreamGroupingBtTest {

	private List<TestObject> testObjectList;

	@BeforeAll
	public void init() {
		testObjectList = Lists.newArrayList();

		testObjectList.add(TestObject.builder().type(TestType.ONE).name("name").age(10).build());
		testObjectList.add(TestObject.builder().type(TestType.ONE).name("name1").age(20).build());
		testObjectList.add(TestObject.builder().type(TestType.TWO).name("name2").age(15).build());
	}

	@Test
	void test_groupingByMax() {

		Map<TestType, Optional<TestObject>> collect = testObjectList.stream()
			.collect(
				Collectors.groupingBy(
					TestObject::getType,
					Collectors.maxBy(Comparator.comparing(TestObject::getAge))))
			;

		Map<TestType, TestObject> collect1 = testObjectList.stream()
			.collect(
				Collectors.groupingBy(
					TestObject::getType,
					Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(TestObject::getAge)), Optional::get)
				)
			);

		Map<TestType, TestObject> collect2 = testObjectList.stream()
			.collect(
				Collectors.toMap(
					TestObject::getType, Function.identity(),
					BinaryOperator.maxBy(Comparator.comparing(TestObject::getAge)))
			);

	}

}
