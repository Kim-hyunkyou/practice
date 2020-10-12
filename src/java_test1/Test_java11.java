package java_test1;

import java.util.Arrays;
import java.util.Scanner;

public class Test_java11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int game[] = { 0, 2, 0, 2, 8, 0, 0, 4, 0 };
		int temp[] = new int[game.length];
		// 1)left , 2)right

		// 문제1)번호를 입력받고 각방향으로 숫자를모으시요.
		// 조건) 만약에 같은숫자2개가 붙었을경우는 서로 더해진다.
		// 아래 2단계출력
		// 예) left
		// 1단계 : {2,2,8,4,0,0,0,0,0};
		// 2단계 : {4,8,4,0,0,0,0,0,0}; 2가 2개붙었으니 4가된다.
		System.out.print("[1]Left [2]Right :");
		int dir = scan.nextInt();

		if (dir == 1) {
			int j = 0;
			for (int i = 0; i < temp.length; i++) {
				if (game[i] != 0) {
					temp[j] = game[i];
					j++;
				}
			}

			for (int i = 0; i < temp.length - 1; i++) {
				int cnt = 0;
				if (temp[i] == temp[i + 1]) {
					temp[i] = temp[i] + temp[i + 1];
					cnt++;
				}
				for (int k = cnt; k < temp.length; k++) {
					temp[k] = temp[i + 1];
				}
			}
			System.out.println(Arrays.toString(temp));
		}

	}
}
