package 메서드기본구조1;

//2020-09-22
//17:30-17:38 9분"
import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임 : 클래스 + 메서드
 * 1. front 배열 카드 10장을 섞는다.
 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다. 
 */

class MemoryGame {

	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	int[] front = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
	int[] back = new int[10];

	int cnt = 0; // 정답을 맞춘 횟수

	void shuffle() {
		for (int i = 0; i < 1000; i++) {
			int r = ran.nextInt(front.length);
			int temp = front[0];
			front[0] = front[r];
			front[r] = temp;
		}
	}

	void printCard() {
		// 카드 앞면 출력
		System.out.print("front = [ ");
		for (int i = 0; i < front.length; i++) {
			System.out.print(front[i] + " ");
		}
		System.out.print("]\n");

		// 카드 뒷면 출력
		System.out.print("back = [ ");
		for (int i = 0; i < back.length; i++) {
			System.out.print(back[i] + " ");
		}
		System.out.println("]");
	}

	void choiceCard() {
		// 카드 뒤짚기
		while (true) {
			System.out.print("카드1 입력[1~10]");
			int card1 = scan.nextInt() - 1;
			System.out.print("카드2 입력[1~10]");
			int card2 = scan.nextInt() - 1;

			if (card1 >= 0 && card1 < 10 && card2 >= 0 && card2 < 10) {
				if (front[card1] == front[card2]) {
					back[card1] = front[card1];
					back[card2] = front[card2];
					cnt++;
					break;
				}
			} else {
				continue;
			}
		}
	}

	void run() {

		// 셔플(카드 섞기)
		shuffle();

		while (true) {
			// 카드 출력
			printCard();

			// 종료하기
			if (cnt == 5) {
				System.out.println("게임 종료");
				break;
			}

			// 카드 선택하기
			choiceCard();
		}
	}
}

public class day0922_메서드기억력게임 {
	public static void main(String[] args) {

		MemoryGame mg = new MemoryGame();
		mg.run();
	}

}
