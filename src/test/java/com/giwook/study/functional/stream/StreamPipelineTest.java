package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 93Hong on 2019-09-11
 *
 */
@Slf4j
public class StreamPipelineTest {

	@DisplayName("Stream pipeline")
	@Test
	void test_streamPipeline() {

		List<TestObject> testObjectList = Lists.newArrayList();

		testObjectList.add(TestObject.builder().name("kim").age(10).build());
		testObjectList.add(TestObject.builder().name("hong").age(20).build());
		testObjectList.add(TestObject.builder().name("lee").age(30).build());
		testObjectList.add(TestObject.builder().name("park").age(30).build());

		List<String> collect = testObjectList.stream()
			.filter(testObject -> {
				log.info("filter {}", testObject.getName());
				return testObject.getAge() > 15;
			})
			.map(testObject -> {
				log.info("map {}", testObject.getName());
				return testObject.getName();
			})
			.limit(2)
			.collect(Collectors.toList());

		log.info(collect.toString());
	}

}
