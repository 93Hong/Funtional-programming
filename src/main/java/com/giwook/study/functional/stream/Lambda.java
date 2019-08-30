package com.giwook.study.functional.stream;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

}
