package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
@Component
public class JavaStream {

	public void stream() {

		List<String> stringList = Lists.newArrayList();

		List<String> stringList1 = filterByStartWith(stringList, JavaStream::startWithA);

		final long count = stringList.stream().filter(s -> {
			return stringList1.contains(s);
		}).count();

		int primitive = 3;
		final long count1 = stringList.stream().filter(s -> s.length() > primitive).count();


	}

	public static boolean startWithB(String s) {
		return s.startsWith("B");
	}

	public static boolean startWithA(String s) {
		return s.startsWith("A");
	}

	List<String> filterByStartWith(List<String> stringList, Predicate<String> predicate) {
		return stringList.stream() // source
			.filter(predicate) 	   // intermediate operations
			.collect(Collectors.toList()) // terminal operation
			;
	}

	public <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
		return collection.stream().filter(predicate).collect(Collectors.toList());
	}




}
