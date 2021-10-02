package test.java;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.StringClass;

public class StringClassTest {

	/*
	 * 요구사항1 1. "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다. 2. "1"을 ,로
	 * split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	 */
	@Test
	public void separateStringToArrayAssertions() {
		StringClass sc = new StringClass();
		assertThat(sc.separateStringToArray("1,2")).hasSize(2).containsExactly("1", "2");
		assertThat(sc.separateStringToArray("1,")).hasSize(1).containsExactly("1");
	}

	/*
	 * 요구사항2 1. "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 확용해 ()을 제거하고 "1,2"를 반환하도록
	 * 구현한다.
	 */
	@Test
	public void removeParenthesesFromStringAssertions() {
		StringClass sc = new StringClass();
		assertThat(sc.removeParenthesesFromString("(1,2)")).isEqualTo("1,2");
	}

	/*
	 * 요구사항3 1. "abc"값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를
	 * 구현한다. 2. String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
	 * StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다. 3.
	 * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
	 */
	@Test
	@DisplayName("특정위치를 입력하면 해당 위치의 문자를 리턴받는 메소드 검증")
	public void getCharFromStringAssertions() {
		StringClass sc = new StringClass();
		assertThat(sc.getCharFromString("abc", 0)).isEqualTo('a');
		assertThat(sc.getCharFromString("abc", 1)).isEqualTo('b');
		assertThat(sc.getCharFromString("abc", 2)).isEqualTo('c');
//		assertThat(sc.getCharFromString("abc", 3)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index:2, Size: 2");
//		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
//			throw new IndexOutOfBoundsException("Index: 3, Size: 3");
//		}).withMessageMatching("Index: \\d+, Size: \\d+");
		assertThatThrownBy(() -> sc.getCharFromString("abc", 3)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index: 3, Size: 3");
	}

}
