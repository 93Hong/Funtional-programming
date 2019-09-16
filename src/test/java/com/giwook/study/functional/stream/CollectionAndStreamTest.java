package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 93Hong on 2019-09-16
 *
 */
public class CollectionAndStreamTest {

	@DisplayName("")
	@Test
	void test_CollectionAndStreamTest() {
		List<TestObject> testObjectList = Lists.newArrayList();
		List<TestObject> result = Lists.newArrayList();

		testObjectList.add(TestObject.builder().name("name").age(10).build());
		testObjectList.add(TestObject.builder().name("age").age(20).build());

		// Collection
		for (TestObject testObject : testObjectList) {
			if ("name".equals(testObject.getName())) {
				result.add(testObject);
			}
		}

		// Stream
		result = testObjectList.stream()
			.filter(testObject -> "name".equals(testObject.getName()))
			.collect(Collectors.toList());

		Iterator<TestObject> iterator = testObjectList.stream().iterator();
		while (iterator.hasNext()) {
			TestObject testObject = iterator.next();
			if ("name".equals(testObject.getName())) {
				result.add(testObject);
			}
		}

	}

}
