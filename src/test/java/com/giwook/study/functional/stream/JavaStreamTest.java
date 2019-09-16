package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
class JavaStreamTest {

	JavaStream javaStream = new JavaStream();

	private static boolean filtering(TestObject testObject) {
		return "name".equals(testObject.getName());
	}

	@DisplayName("Predicate startWith with method reference")
	@Test
	void test_filterByStartWith() {

		List<String> stringList = Lists.newArrayList();
		stringList.add("Aaa");
		stringList.add("Aaa");
		stringList.add("Baa");
		stringList.add("Baa");
		stringList.add("Baa");
		stringList.add("Caa");

		List<String> startWithAList = javaStream.filterByStartWith(stringList, JavaStream::startWithA);
		assertThat(startWithAList).isNotNull();
		assertThat(startWithAList).size().isEqualTo(2);

		List<String> startWithBList = javaStream.filterByStartWith(stringList, JavaStream::startWithB);
		assertThat(startWithBList).isNotNull();
		assertThat(startWithBList).size().isEqualTo(3);

		Collection<String> startWithACollection = javaStream.filter(stringList, JavaStream::startWithA);
		assertThat(startWithACollection).isNotNull();
		assertThat(startWithACollection).size().isEqualTo(2);

	}

	@DisplayName("Predicate startWith with lambda")
	@Test
	void test_predicate_withLambda() {

		List<String> stringList = Lists.newArrayList();
		stringList.add("Aaa");
		stringList.add("Aaa");
		stringList.add("Baa");
		stringList.add("Baa");
		stringList.add("Baa");
		stringList.add("Caa");

		List<String> startWithAList = javaStream.filterByStartWith(stringList, s -> s.startsWith("A"));
		assertThat(startWithAList).isNotNull();
		assertThat(startWithAList).size().isEqualTo(2);

		List<String> startWithBList = javaStream.filterByStartWith(stringList, s -> s.startsWith("B"));
		assertThat(startWithBList).isNotNull();
		assertThat(startWithBList).size().isEqualTo(3);

		Collection<String> startWithACollection = javaStream.filter(stringList, s -> s.startsWith("A"));
		assertThat(startWithACollection).isNotNull();
		assertThat(startWithACollection).size().isEqualTo(2);

	}

	@DisplayName("non-interference")
	@Test
	void test_non_interference() {
		List<String> l = Lists.newArrayList(Arrays.asList("one", "two"));
		Stream<String> sl = l.stream(); // stream generated
		l.add("three");
		String s = sl.collect(Collectors.joining(" "));
		assertThat(s).isNotEqualTo("one two");
		assertThat(s).isEqualTo("one two three");
	}

	@DisplayName("side-effect")
	@Test
	void test_sideEffect() {
		List<TestObject> testObjectList = Lists.newArrayList();
		List<TestObject> result = Lists.newArrayList();

		testObjectList.stream()
			.filter(JavaStreamTest::filtering)
			.forEach(result::add) // may have side-effect
			;

		result = testObjectList.stream()
			.filter(JavaStreamTest::filtering)
			.collect(Collectors.toList()) // no side-effect
			;
	}

}