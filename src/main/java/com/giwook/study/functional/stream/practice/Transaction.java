package com.giwook.study.functional.stream.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author 93Hong on 2019-10-01
 *
 */
@Getter
@AllArgsConstructor
@ToString
public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;

}
