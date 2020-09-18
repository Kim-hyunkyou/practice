package File;

//2020-09-18
//17:16-17:34 18분"
import java.util.Scanner;

public class omok {
	// # 오목게임

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int size = 10;
		int[][] omok = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

		int p1Y = 0;
		int p1X = 0;
		int p2Y = 0;
		int p2X = 0;

		int turn = 0;

		int win = 0;

		boolean run = true;
		while (run) {
			// 전체화면 출력
			System.out.println(" ==== OMOK GAME ====");
			System.out.print("  ");
			for (int i = 0; i < size; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			for (int i = 0; i < size; i++) {
				System.out.print(i + " ");
				for (int j = 0; j < size; j++) {
					System.out.print(omok[i][j] + " ");
				}
				System.out.println();
			}
			// 승리조건
			if (win == 1) {
				System.out.println("player1 승리");
				break;
			} else if (win == 2) {
				System.out.println("player2 승리");
				break;
			}
			// 바둑알 두기

			// p1차례
			if (turn % 2 == 0) {
				System.out.print("[p1]y좌표 입력 :");
				p1Y = scan.nextInt();
				System.out.print("[p1]x좌표 입력 :");
				p1X = scan.nextInt();

				if (omok[p1Y][p1X] == 0) {
					omok[p1Y][p1X] = 1;
					turn++;
				}
			}
			// p2차례
			else if (turn % 2 == 1) {
				System.out.print("[p2]y좌표 입력 :");
				p2Y = scan.nextInt();
				System.out.println("[p2]x좌표 입력 :");
				p2X = scan.nextInt();

				if (omok[p2Y][p2X] == 0) {
					omok[p2Y][p2X] = 2;
					turn++;
				}
			}

			// 가로검사
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - 4; j++) {
					if (omok[i][j] == 1 && omok[i][j + 1] == 1 && omok[i][j + 2] == 1 && omok[i][j + 3] == 1
							&& omok[i][j + 4] == 1) {
						win = 1;
					}
					if (omok[i][j] == 2 && omok[i][j + 1] == 2 && omok[i][j + 2] == 2 && omok[i][j + 3] == 2
							&& omok[i][j + 4] == 2) {
						win = 2;
					}
				}
			}
			// 세로검사
			for (int i = 0; i < size - 4; i++) {
				for (int j = 0; j < size; j++) {
					if (omok[i][j] == 1 && omok[i + 1][j] == 1 && omok[i + 2][j] == 1 && omok[i + 3][j] == 1
							&& omok[i + 4][j] == 1) {
						win = 1;
					}
					if (omok[i][j] == 2 && omok[i + 1][j] == 2 && omok[i + 2][j] == 2 && omok[i + 3][j] == 2
							&& omok[i + 4][j] == 2) {
						win = 2;
					}
				}
			}
			// 좌측부터 대각선
			for (int i = 0; i < size - 4; i++) {
				for (int j = 0; j < size - 4; j++) {
					if (omok[i][j] == 1 && omok[i + 1][j + 1] == 1 && omok[i + 2][j + 2] == 1 && omok[i + 3][j + 3] == 1
							&& omok[i + 4][j + 4] == 1) {
						win = 1;
					}
					if (omok[i][j] == 2 && omok[i + 1][j + 1] == 2 && omok[i + 2][j + 2] == 2 && omok[i + 3][j + 3] == 2
							&& omok[i + 4][j + 4] == 2) {
						win = 2;
					}
				}
			}
			// 우측부터 대각선
			for (int i = 9; i > size - 7; i--) {
				for (int j = 0; j < size - 4; j++) {
					if (omok[i][j] == 1 && omok[i - 1][j + 1] == 1 && omok[i - 2][j + 2] == 1 && omok[i - 3][j + 3] == 1
							&& omok[i - 4][j + 4] == 1) {
						win = 1;
					}
					if (omok[i][j] == 2 && omok[i - 1][j + 1] == 2 && omok[i - 2][j + 2] == 2 && omok[i - 3][j + 3] == 2
							&& omok[i - 4][j + 4] == 2) {
						win = 2;
					}
				}
			}
		}
		//입력닫기
		scan.close();
	}

}
