package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 구현 사항
 * - 사칙연산
 * - 양수로만 계산
 * - 나눗셈에서 0으로 나누는 경우 IllegalArgument 예외를 발생시킨다
 * - MVC(Model-View-Controller) pattern 으로 구현한다
 */
public class CalculatorTest {
	
	@DisplayName("사칙 연산을 수행한다")
	@ParameterizedTest()
	@MethodSource("formulaAndResult")
	void additionTest(int operand1, String operator, int operand2, int result) {
		// Given
		Calculator calculator = new Calculator();
		int actual = calculator.calculate(operand1, operator, operand2);
		
		// When & Then
		assertThat(actual).isEqualTo(result);
	}
	
	private static Stream<Arguments> formulaAndResult() {
		return Stream.of(
			arguments(1, "+", 2, 3),
			arguments(1, "-", 2, -1),
			arguments(1, "*", 2, 2),
			arguments(4, "/", 2, 2)
		);
	}
	
	@DisplayName("나눗셈에서 0으로 나누면 IllegalArgument 예외를 발생한다.")
	@Test
	void calculateExceptionTest() {
		
		Calculator calculator = new Calculator();
		
		assertThatCode(() -> calculator.calculate(1, "/" , 0))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
