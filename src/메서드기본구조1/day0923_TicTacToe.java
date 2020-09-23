package 메서드기본구조1;

import java.util.Scanner;

//# 틱택토

class TicTacToe {

	Scanner scan = new Scanner(System.in);

	String[][] game = new String[3][3];

	int turn = 0;
	int win = 0; // 1[turn1승리] 2[turn2승리]

	// game 배열을 공백(" ")으로 초기화
	void setGame() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				game[i][j] = " ";
			}
		}
	}

	// 게임 화면 출력
	void showGame() {
		System.out.println("==== TicTacToe ====");
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				System.out.print("[" + game[i][j] + "]\t");
			}
			System.out.println();
		}
		System.out.println("===================");
	}

	// 인덱스 선택
	void choiceIdx() {
		if (turn % 2 == 0) {
			System.out.println("[1턴]x인덱스 입력 : ");
			int xIdx = scan.nextInt();
			System.out.println("[1턴]y인덱스 입력 : ");
			int yIdx = scan.nextInt();
			if (game[xIdx][yIdx].equals(" ")) {
				game[xIdx][yIdx] = "O";
				turn++;
			} else {
				System.out.println("다시입력하세요.");
			}
		} else if (turn % 2 == 1) {
			System.out.println("[2턴]x인덱스 입력 : ");
			int xIdx = scan.nextInt();
			System.out.println("[2턴]y인덱스 입력 : ");
			int yIdx = scan.nextInt();

			if (game[xIdx][yIdx].equals(" ")) {
				game[xIdx][yIdx] = "X";
				turn++;
			} else {
				System.out.println("다시입력하세요.");
			}
		}
	}

	// 종료 : 가로 검사
	// 00 01 02
	// 10 11 12
	// 20 21 22
	void exitWidth() {
		for (int i = 0; i < game.length; i++) {
			if (game[i][0].equals("O") && game[i][1].equals("O") && game[i][2].equals("O")) {
				win = 1;
			}
			if (game[i][0].equals("X") && game[i][1].equals("X") && game[i][2].equals("X")) {
				win = 2;
			}
		}
	}

	// 종료 : 세로 검사
	// 00 10 20
	// 01 11 21
	// 02 12 22
	void exitHeight() {
		for (int i = 0; i < game.length; i++) {
			if (game[0][i].equals("O") && game[1][i].equals("O") && game[2][i].equals("O")) {
				win = 1;
			}
			if (game[0][i].equals("X") && game[1][i].equals("X") && game[2][i].equals("X")) {
				win = 2;
			}
		}
	}

	// 종료 : 대각선 검사
	// 00 11 22
	// 02 11 20
	void exitCross() {
		for (int i = 0; i < game.length; i++) {
			if (game[0][0].equals("O") && game[1][1].equals("O") && game[2][2].equals("O")) {
				win = 1;
			} else if (game[0][2].equals("O") && game[1][1].equals("O") && game[2][0].equals("O")) {
				win = 1;
			}
			if (game[0][2].equals("X") && game[1][1].equals("X") && game[2][0].equals("X")) {
				win = 2;
			} else if (game[0][0].equals("X") && game[1][1].equals("X") && game[2][2].equals("X")) {
				win = 2;
			}
		}
	}

	void run() {

		// game배열을 공백 문자열(" ")로 초기화
		setGame();
		while (true) {
		try {

				showGame();

				// 게임 종료
				if (win == 1) {
					System.out.println("turn1 승리");
					break;
				} else if (win == 2) {
					System.out.println("tur2 승리");
					break;
				}

				choiceIdx();

				exitWidth();
				exitHeight();
				exitCross();
		} catch (Exception e) {
			System.out.println("존재하지 않는 위치입니다.");
			continue;
			}
		}
	}

}

public class day0923_TicTacToe {
	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe();
		tic.run();
	}
}
