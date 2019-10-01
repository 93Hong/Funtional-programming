package com.giwook.study.functional.stream.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 93Hong on 2019-10-01
 *
 */
@Slf4j
public class StreamPracticeTest {

	List<Transaction> transactionList;

	@BeforeEach
	public void init() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		transactionList = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
		);
	}

	@DisplayName("2011년에 일어난 모든 트랜젝션을 오름차순으로 정렬")
	@Test
	void test_practice1() {

		List<Transaction> collect = transactionList.stream()
			.filter(transaction -> transaction.getYear() == 2011)
			.sorted(Comparator.comparing(Transaction::getValue))
			.collect(Collectors.toList());

		log.info(collect.toString());

	}



}
