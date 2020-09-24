package 메서드기본구조1;

import java.util.Random;
import java.util.Scanner;

//# 틱택토

class SpeedGame {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	
	int[][] front = new int[5][5];
	int[][] back = new int[5][5];

	int num = 1;

	// 숫자 셋팅하기
	void setNumber() {
		int k = 1;
		for (int i = 0; i < front.length; i++) {
			for (int j = 0; j < front[i].length; j++) {
				front[i][j] = k;
				k += 1;
			}
		}
		for (int i = 0; i < back.length; i++) {
			for (int j = 0; j < back[i].length; j++) {
				back[i][j] = k;
				k += 1;
			}
		}
	}

	// 카드 섞기
	void suffleCard() {
		for (int i = 0; i < front.length; i++) {
			for (int j = 0; j < front[i].length; j++) {
				int xR = ran.nextInt(front.length);
				int yR = ran.nextInt(front[i].length);

				int tmp = front[0][0];
				front[0][0] = front[xR][yR];
				front[xR][yR] = tmp;

				tmp = back[0][0];
				back[0][0] = back[xR][yR];
				back[xR][yR] = tmp;
			}
		}
	}

	// 화면 출력하기
	void showCard() {
		System.out.println("-"+num+"-");
		System.out.print("\t");
		for (int i = 0; i < 5; i++) {
			System.out.print("["+(i+1)+"]"+"\t");
		}System.out.println();
		for (int i = 0; i < front.length; i++) {
			System.out.print("["+(i+1)+"]"+"\t");
			
			for (int j = 0; j < front[i].length; j++) {
				System.out.print(front[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}

	// 입력받기
	void selectCard() {
		System.out.print("x입력 : ");
		int xIdx = scan.nextInt()-1;
		System.out.print("y입력 : ");
		int yIdx = scan.nextInt()-1;
		if (num == front[xIdx][yIdx]) {
			if (num <= 25) {
				front[xIdx][yIdx] = back[xIdx][yIdx];
			} else {
				front[xIdx][yIdx] = 0;
			}
			num += 1;
		}
	}

	void run() {

		setNumber();
		suffleCard();

		while (true) {

			showCard();

			// 종료하기
			if (num == 51) {
				System.out.println("게임종료");
				break;
			}

			selectCard();
		}
	}
}

public class day0923_메서드_1to50 {
	public static void main(String[] args) {

		SpeedGame sg = new SpeedGame();
		sg.run();

	}

}
