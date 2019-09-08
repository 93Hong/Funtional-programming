package com.giwook.study.functional.stream;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
public class Lambda {

	public void lambdaExpression() {
		Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
		Predicate<String> p = (String s) -> s.length() > 3;
		Consumer<String> stringConsumer = (String s) -> {
			System.out.println(s);
		};
		Supplier<String> stringSupplier = () -> "string";
		BiFunction<String, String, String> stringStringStringEntryTransformer = (String s1, String s2) -> s1.concat(s2);

	}

	public void compare() {
		List<TestObject> testObjectList = Lists.newArrayList();

		// 1. Implement Comparator
		testObjectList.sort(new TestComparator());

		// 2. Anonymous class
		testObjectList.sort((new Comparator<TestObject>() {
			@Override
			public int compare(TestObject o1, TestObject o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}));

		// 3. Lambda
		testObjectList.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));

		// 4. Method reference
		testObjectList.sort((Comparator.comparing(TestObject::getName)));

		Stream<String> stringStream = testObjectList.stream().map(testObject -> testObject.getName());

		Stream<String> stringStream1 = stringStream.filter(s -> s.length() > 3);
		Stream<String> stringStream2 = stringStream.filter(s -> s.length() > 4);
	}

	// 코드 전달
	public static class TestComparator implements Comparator<TestObject> {
		@Override
		public int compare(TestObject o1, TestObject o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

}
