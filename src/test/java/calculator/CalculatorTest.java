package calculator;

import calculator.vo.PositiveNumber;
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
	void additionTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result) {
		// Given
		Calculator calculator = new Calculator();
		int actual = calculator.calculate(operand1, operator, operand2);
		
		// When & Then
		assertThat(actual).isEqualTo(result);
	}
	
	private static Stream<Arguments> formulaAndResult() {
		return Stream.of(
			arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
			arguments(new PositiveNumber(1), "-", new PositiveNumber(2), -1),
			arguments(new PositiveNumber(1), "*", new PositiveNumber(2), 2),
			arguments(new PositiveNumber(4), "/", new PositiveNumber(2), 2)
		);
	}
	
	/**
	 * PositiveNumber(VO)를 만들었기때문에 필요가 없어진 test code
	 */
	@DisplayName("나눗셈에서 0으로 나누면 IllegalArgument 예외를 발생한다.")
	@Test
	void calculateExceptionTest() {
		
		Calculator calculator = new Calculator();
		
		assertThatCode(() -> calculator.calculate(new PositiveNumber(1), "/" , new PositiveNumber(0)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
