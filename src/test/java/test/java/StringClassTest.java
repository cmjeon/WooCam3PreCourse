package test.java;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.StringClass;

public class StringClassTest {
	
	/*
	 * assertj 테스트
	 */
	@Test
	public void aFewSimpleAssertions() {
		assertThat("Hello, world! Nice to meet you.") // 주어진 "Hello, world! Nice to meet you."라는 문자열은
		.isNotEmpty() // 비어있지 않고
		.contains("Nice") // "Nice"를 포함하고
		.contains("world") // "world"도 포함하고
		.doesNotContain("ZZZ") // "ZZZ"는 포함하지 않으며
		.startsWith("Hell") // "Hell"로 시작하고
		.endsWith("u.") // "u."로 끝나며
		.isEqualTo("Hello, world! Nice to meet you."); // "Hello, world! Nice to meet you."과 일치합니다.
	}
	
	/*
	 * 요구사항1
	 */
	@Test
	public void separateStringToArrayAssertions() {
		StringClass sc = new StringClass();
		assertThat(sc.separateStringToArray("1,2")).hasSize(2).containsExactly("1", "2");
		assertThat(sc.separateStringToArray("1,")).hasSize(1).containsExactly("1");
	}
	
	/*
	 * 요구사항2
	 */
	@Test
	public void removeParenthesesFromStringAssertions() {
		StringClass sc = new StringClass();
		assertThat(sc.removeParenthesesFromString("(1,2)")).contains("1,2");
	}
	
	/*
	 * 요구사항3
	 */
	@Test
	@DisplayName("DisplayName 은 어디에서 쓰나요?")
	public void getCharFromStringAssertions() {
		StringClass sc = new StringClass();
		assertThat(sc.removeParenthesesFromString("(1,2)")).contains("1,2");
	}

}
