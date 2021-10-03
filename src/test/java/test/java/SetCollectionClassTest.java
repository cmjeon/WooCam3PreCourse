package test.java;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.java.SetCollectionClass;

public class SetCollectionClassTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	/*
	 * 요구사항1
	 * 1. Set 의 size() 메소드를 활용해 Set의 크기를 확인하 학습테스트를 구현한다.
	 */
	@Test
	public void getSetSizeAssertions() {
		SetCollectionClass scc = new SetCollectionClass();
		assertThat(scc.getSize(numbers)).isEqualTo(3);
	}

	/*
	 * 요구사항2
	 * 1. Set 의 contains() 메소드를 활용해 1, 2, 3 의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
	 * 2. 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
	 * 3. JUnit 의 ParameterizedTest 를 활용해 중복 코드를 제거해 본다.
	 */
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void conatainsAssertions(int num) {
		assertThat(numbers.contains(num)).isTrue();
	}

	/*
	 * 요구사항3
	 * 1. 요구사항 2는 contains 메소드 결과값이 true 인 경우만 테스트 가능하다. 
	 *    입력값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
	 * 2. 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case 로 구현한다.
	 */
	@ParameterizedTest
	@CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false" }, delimiter=':')
	public void conatainsFourAndFiveAssertion(String num, String expected) {
		assertEquals(numbers.contains(Integer.valueOf(num)), Boolean.valueOf(expected));
	}
}
