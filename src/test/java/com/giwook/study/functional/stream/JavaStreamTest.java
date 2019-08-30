package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
class JavaStreamTest {

	JavaStream javaStream = new JavaStream();

	@DisplayName("Predicate > filterByStartWith")
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

	}

}