package com.giwook.study.functional.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 93Hong on 2019-08-30
 *
 */
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class TestObject {
	private String name;
	private int age;
}
