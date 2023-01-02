package calculator;

public class Calculator {
	public int calculate(int operand1, String operator, int operand2) {
		if ("+".equals(operator)) {
			return operand1 + operand2;
		}
		if ("-".equals(operator)) {
			return operand1 - operand2;
		}
		if ("*".equals(operator)) {
			return operand1 * operand2;
		}
		if ("/".equals(operator)) {
			return operand1 / operand2;
		}
		return 0;
	}
}
