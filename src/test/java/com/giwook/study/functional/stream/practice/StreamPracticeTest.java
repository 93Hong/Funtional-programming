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

	@DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열")
	@Test
	void test_practice2() {

		List<String> collect = transactionList.stream()
			.map(transaction -> transaction.getTrader().getCity())
			.distinct()
			.collect(Collectors.toList());

		log.info(collect.toString());
	}

	@DisplayName("Cambridge의 거래자들 알파벳순으로 정렬")
	@Test
	void test_practice3() {
		List<String> collect = transactionList.stream()
			.map(Transaction::getTrader)
			.distinct()
			.filter(trader -> "Cambridge".equals(trader.getCity()))
			.sorted(Comparator.comparing(Trader::getName))
			.map(Trader::getName)
			.collect(Collectors.toList());

		log.info(collect.toString());
	}

	@DisplayName("모든 거래자들 알파벳순")
	@Test
	void test_practice4() {

	}

	@DisplayName("밀라노에 거래자가 있는가?")
	@Test
	void test_practice5() {

	}

	@DisplayName("Cambridge에 거주하는 거래자의 모든 트랜젝션값")
	@Test
	void test_practice6() {

	}

	@DisplayName("전체 트랜젝션 중 최댓값")
	@Test
	void test_practice7() {

	}

	@DisplayName("전체 트랜젝션 중 최솟값")
	@Test
	void test_practice8() {

	}



}
