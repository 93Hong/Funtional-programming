package com.giwook.study.functional.stream.collector;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *
 * @author 93Hong on 2019-10-01
 *
 */
@Slf4j
class GetPrimeWithCollectorTest {

	@Test
	void test_with_predefined() {
		GetPrimeWithPredefinedCollector collector = new GetPrimeWithPredefinedCollector();
		Map<Boolean, List<Integer>> collect = collector.partitionPrimes(100);

		log.info(collect.toString());
	}

	@Test
	void test_with_custom() {
		int n = 100;

		Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, n).boxed()
			.collect(new GetPrimeWithCustomCollector());

		log.info(collect.toString());

	}

}