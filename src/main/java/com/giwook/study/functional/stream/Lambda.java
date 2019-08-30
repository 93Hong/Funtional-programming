package com.giwook.study.functional.stream;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;

import java.util.function.Consumer;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
public class Lambda {

	public void lambdaExpression() {
		Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
		Function<String, Boolean> stringBooleanFunction = (String s) -> s.length() > 3;
		Consumer<String> stringConsumer = (String s) -> {
			System.out.println(s);
		};
		Supplier<String> stringSupplier = () -> "string";
		Maps.EntryTransformer<String, String, String> stringStringStringEntryTransformer = (String s1, String s2) -> s1.concat(s2);
	}

}
