package 메서드기본구조1;
//2020-09-20
//01:11-01:26 15분"
class Test_2 {
	int total;
	int cnt = 0;
	int FthTotal;
	int SndCnt = 0;

	void printSum(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println("총합 = " + total);
	}

	void printSumMultiple4(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 4 == 0) {
				FthTotal += arr[i];
			}
		}
		System.out.print("4의 배수의 총합 = " + FthTotal);
		System.out.println();
	}

	void printCountMultiple4(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 4 == 0) {
				cnt++;
			}
		}
		System.out.println("4의  배수의 총 갯수 = " + cnt + "개");
	}

	void printCountMultiple2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				SndCnt++;
			}
		}
		System.out.println("짝수의 갯수는 = " + SndCnt + "개");
	}
}

public class day0920_연습문제2 {

	public static void main(String[] args) {
		int[] arr = { 87, 100, 11, 72, 92 };

		Test_2 t = new Test_2();
		// 문제 1) 전체 합 출력
		// 정답 1) 362
		t.printSum(arr);
		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		t.printSumMultiple4(arr);
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		t.printCountMultiple4(arr);

		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
		t.printCountMultiple2(arr);
	}

}
