package File;

import java.util.Arrays;
import java.util.Scanner;

public class moveToNum {
	public static void main(String[] args) {

		int game[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
		int yx[][] = new int[10000][2];
		// 문제1) 0 이 플레이어이다
		// 1) left 2)right 3)up 4)down 5)되감기
		// 번호를 입력받고 해당위치로 이동 ==> 이동할때 값을 서로 교환한다.
		// 예) 1 ==>
		/*
		 * {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,0,15}
		 */

		Scanner scan = new Scanner(System.in);

		int pX = 3;
		int pY = 3;
		int player = 0; // 플레이어 위치 만들어주기
		int size = game.length;
		
		while (true) {

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (yx[i][j] == 0) {
						System.out.println("옷 \t");
					} else {
						System.out.print(game[i][j] + "\t");
					}
				}
				System.out.println();
			}
			System.out.println("=====숫자 이동=====");
			System.out.println("[플레이어를 이동하세요]");
			System.out.println("[1]왼쪽 [2]오른쪽 [3]위 [4]아래");
			System.out.println("[5]이전[6]종료");
			// 해당
			System.out.print("이동해주세요.");
			int move = scan.nextInt();

			if (move == 1 || move == 2 || move == 3 || move == 4 || move == 5) {

				int tempX = pY;
				int tempY = pX;

				if (move == 1) {
					game[tempY][tempX] = game[tempY][tempX - 1];
					game[tempY][tempX - 1] = 0;

				} else if (move == 2) {
					game[tempY][tempX] = game[tempY][tempX + 1];
					game[tempY][tempX + 1] = player;
				} else if (move == 3) {
					game[tempY][tempX] = game[tempY - 1][tempX];
					game[tempY - 1][tempX] = player;
				} else if (move == 4) {
					game[tempY][tempX] = game[tempY + 1][tempX];
					game[tempY + 1][tempX] = player;
				} else if (move == 5) {

				}

			} else if (move == 6) {
				break;
			}
		}
		// 문제2) 심화 ==> 한칸한칸이동할때마다 yx 에 배열에 이동한경로를 저장했다가
		// 5번입력시 ==> 왔던길로 되돌아가기 한다.

	}
}
