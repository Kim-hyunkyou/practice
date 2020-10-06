package java_test1;

import java.util.Scanner;

public class Test_java3 {

	public static void main(String[] args) {
		/*
		 * # 반복문 종료(-100) 
		 * 1. 무한 반복을 하면서 숫자를 입력받는다.
		 * 2. 입력한 숫자가 -100이면, 프로그램은 종료된다. 
		 * 예) 숫자입력[EXIT:-100] : 1
		 *  숫자 입력[EXIT:-100] : 3 
		 *  숫자 입력[EXIT:-100] : 4
		 *  숫자 입력[EXIT:-100]
		 * : -100 프로그램 종료
		 */

		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("숫자입력[EXIT:-100] :");
			int exit = scan.nextInt();
			
			if(exit == -100) {
				System.out.println("[프로그램 종료]");
				break;
			}
					
		}
		scan.close();
	}
}
