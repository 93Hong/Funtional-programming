package com.giwook.study.functional.stream.collector;

import com.giwook.study.functional.stream.TestObject;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 *
 * @author 93Hong on 2019-10-01
 *
 */
public class GetPrimeWithCustomCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		return () -> new HashMap<>() {{
			put(true, new ArrayList<>());
			put(false, new ArrayList<>());
		}};
	}

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
			// prime 으로 prime 을 체크 (이전에 구해논 prime 을 재사용)
			acc.get(isPrime(acc.get(true), candidate))
				.add(candidate);
		};
	}

	// A function that accepts two partial results and merges them.
	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
			map1.get(true).addAll(map2.get(true));
			map1.get(false).addAll(map2.get(false));
			return map1;
		};
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
	}

	public boolean isPrime(List<Integer> primes, int candidate) {

		Optional<TestObject> testObject = Optional.empty();
		final Optional<String> s = testObject.map(TestObject::getName);

		final String s1 = s.orElse("");
		Optional.empty();

		final Optional<Integer> integer = testObject.flatMap(TestObject::getOptionalInteger);

		int candidateRoot = (int)Math.sqrt(candidate);
		return takeWhile(primes, i -> i <= candidateRoot)
			.stream()
			.noneMatch(p -> candidate % p == 0);
	}

	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i = 0;
		for (A item : list) {
			if (!p.test(item)) {
				return list.subList(0, i);
			}
			i++;
		}

		return list;
	}

}
