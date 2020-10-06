package java_test1;

import java.util.Scanner;

public class Test_java4 {

	public static void main(String[] args) {

		/*
		 * # 답없음 문제 1. 5회 반복을 하면서 정수를 입력받는다. 2. 입력받은 정수를 전부 합을 출력한다. 3. 만약에 입력받은 합이 100
		 * 이상이면 반복이 5회가 아닐지라도 즉시 종료
		 * 
		 * 예) 7 ==> 합 : 7 , 14 ==> 합 : 21 , 1000 ==> 합 : 1021 !종료
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int tot = 0;
		int run = 0;
		while (run<5) {
			System.out.print("[숫자 입력]");
			int num = scan.nextInt();

			tot+=num;
			System.out.println("[합] = "+ tot);
			if(tot>=100) {
				break;
			}
			run++;
		}
		System.out.println("종료");
		scan.close();
	}

}
