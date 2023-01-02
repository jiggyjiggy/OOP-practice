package calculator;

import calculator.operator.AdditionOperator;
import calculator.operator.DivisionOperator;
import calculator.operator.MultiplicationOperator;
import calculator.operator.NewArithmeticOperator;
import calculator.operator.SubtractionOperator;
import calculator.vo.PositiveNumber;

import java.util.List;

public class Calculator {
	private static final List<NewArithmeticOperator> arithmeticOperators= List.of(
		new AdditionOperator(),
		new SubtractionOperator(),
		new MultiplicationOperator(),
		new DivisionOperator()
	);
	
	public int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
		return arithmeticOperators.stream()
			.filter(arithmeticOperator -> arithmeticOperator.supports(operator))
			.map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
	}
}
