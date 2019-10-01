package com.giwook.study.functional.stream.collector;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author 93Hong on 2019-10-01
 *
 */
public class GetPrimeWithPredefinedCollector {

	// candidate 를 2부터 자기 자신까지 나누어서 떨어지는 값이 있는지 확인
	public boolean isPrime(int candidate) {
		return IntStream.range(2, candidate)
			.noneMatch(i -> candidate % i == 0);
	}

	public boolean isPrimeNew(int candidate) {
		return IntStream.rangeClosed(2, (int)Math.sqrt(candidate))
			.noneMatch(i -> candidate % i == 0);
	}

	public Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
			.collect(Collectors.partitioningBy(this::isPrimeNew));
	}

}
