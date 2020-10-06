package java_test1;

import java.util.Random;
import java.util.Scanner;

public class Test_java1 {

	public static void main(String[] args) {
		/*
		 * # 구구단 게임[2단계] 1. 구구단 문제를 출제하기 위해, 숫자 2개를 랜덤하게 저장한다. 2. 저장된 숫자를 토대로 구구단 문제를
		 * 출력한다. 예) 3 x 7 = ? 3. 문제에 해당하는 정답을 입력받는다. 4. 정답을 비교 "정답" 또는 "땡"을 출력한다.
		 */
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int ran1 = ran.nextInt(8)+2;
		int ran2 = ran.nextInt(9)+1;
		
		System.out.println("[문제]"+ran1+"x"+ran2+" = ?" );
		
		System.out.print("정답을 입력하세요 : ");
		int answer = scan.nextInt();
		
		if(ran1*ran2 == answer) {
			System.out.println("정답 ["+(ran1*ran2)+"]");
		}else {
			System.out.println("땡");
		}
		
	}
}
