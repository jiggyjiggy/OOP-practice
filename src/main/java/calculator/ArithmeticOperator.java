package calculator;

import calculator.vo.PositiveNumber;

import java.util.Arrays;

public enum ArithmeticOperator {
	ADDITION("+") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 + operand2;
		}
	},
	SUBTRACTION("-") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 - operand2;
		}
	},
	MULTIPLICATION("*") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 * operand2;
		}
	},
	DIVISION("/") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 / operand2;
		}
	};
	
	private final String operator;
	
	ArithmeticOperator(String operator) {
		this.operator = operator;
	}
	
	public abstract int arithmeticCalculate(int operand1, int operand2);
	
	public static int calculate(int operand1, String operator, int operand2) {
		ArithmeticOperator arithmeticOperator = findArithmeticOperator(operator);
		
		return arithmeticOperator.arithmeticCalculate(operand1, operand2);
	}
	
	private static ArithmeticOperator findArithmeticOperator(String operator) {
		return Arrays.stream(values())
			.filter(v -> v.operator.equals(operator))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
	}
}
