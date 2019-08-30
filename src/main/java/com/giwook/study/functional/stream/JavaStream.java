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

	}

	public static boolean startWithB(String s) {
		return s.startsWith("B");
	}

	public static boolean startWithA(String s) {
		return s.startsWith("A");
	}

	public List<String> filterByStartWith(List<String> stringList, Predicate<String> predicate) {
		return stringList.stream().filter(predicate).collect(Collectors.toList());
	}

	public <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
		return collection.stream().filter(predicate).collect(Collectors.toList());
	}

}
