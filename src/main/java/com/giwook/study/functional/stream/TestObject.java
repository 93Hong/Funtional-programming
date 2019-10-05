package com.giwook.study.functional.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class TestObject {
	private TestType type;
	private String name;
	private int age;
	private Optional<Integer> optionalInteger;
}
