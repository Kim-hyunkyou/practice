package 메서드기본구조1;

class Calculation {
	double num1;
	double num2;
	double result;

	// 매서드는 모두 독립공간이라서 갈색으로 표시된 변수들은 중복이되어도 전부 다른 변수이다.
	// double a, double b 은 4번이나 사용하지만 각각다른변수이다.

	// plus
	void plus(double a, double b) {
		result = a + b;
	}

	// minus
	void minus(double a, double b) {
		result = a - b;
	}

	// multiply
	void multiply(double a, double b) {
		result = a * b;
	}

	// division
	void division(double a, double b) {
		result = a / b;
	}
	// printResult
	void printResult() {
		System.out.println(result);
	}
}

public class day0919_메서드4 {

	public static void main(String[] args) {
		
		Calculation cal = new Calculation();
		cal.plus(10, 3);
		cal.printResult();
		cal.minus(10, 3);
		cal.printResult();
		cal.multiply(10, 3);
		cal.printResult();
		cal.division(10, 3);
		cal.printResult();
	
	}
}
