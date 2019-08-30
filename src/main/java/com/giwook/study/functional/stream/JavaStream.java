package com.giwook.study.functional.stream;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

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
		List<String> result = Lists.newArrayList();
		for (String s : stringList) {
			if (predicate.test(s)) {
				result.add(s);
			}
		}
		return result;
	}

}
