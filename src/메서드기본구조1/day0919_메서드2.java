package 메서드기본구조1;

class Test2 {
	void printSum() {
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}

public class day0919_메서드2 {

	public static void main(String[] args) {
		// 1~5의 합을 출력하는함수
		Test2 test2 = new Test2();
		test2.printSum();
	}

}
