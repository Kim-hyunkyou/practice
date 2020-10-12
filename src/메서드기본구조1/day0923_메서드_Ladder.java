package 메서드기본구조1;

//2020-09-24
//16:10~16:18 9분"
import java.util.Scanner;

//# 사다리 게임

class LadderGame {

	Scanner scan = new Scanner(System.in);

	int[][] ladder = { { 0, 0, 0, 0, 0 }, { 1, 2, 0, 1, 2 }, { 0, 1, 2, 0, 0 }, { 0, 0, 0, 1, 2 }, { 0, 1, 2, 0, 0 },
			{ 1, 2, 1, 2, 0 }, { 0, 0, 0, 1, 2 }, { 0, 0, 0, 0, 0 } };

	int xIdx = 0;
	int yIdx = 0;

	String menu = "";

	// 사다리 출력하기
	void showLadder() {
		System.out.println(" 1  2  3  4  5");
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				if (ladder[i][j] == 0) {
					if (xIdx == i && yIdx == j) {
						System.out.print("  *");
					} else {
						System.out.print("  │");
					}
				} else if (ladder[i][j] == 1) {
					if (xIdx == i && yIdx == j) {
						System.out.print("  * ");
					} else {
						System.out.print("  ├─");
					}
				} else if (ladder[i][j] == 2) {
					if (xIdx == i && yIdx == j) {
						System.out.print(" *");
					} else {
						System.out.print("─┤");
					}
				}
			}
			System.out.println();
		}
		System.out.println("아아 뜨아 김밥 라면 떡볶이");
		System.out.println();

		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사다리 이동하기
	void moveLadder() {
		showLadder();
		while (true) {
			if (ladder[xIdx][yIdx] == 0) {
				xIdx++;
				showLadder();
			} else if (ladder[xIdx][yIdx] == 1) {
				yIdx++;
				showLadder();
				xIdx++;
				showLadder();
			} else if (ladder[xIdx][yIdx] == 2) {
				yIdx--;
				showLadder();
				xIdx++;
				showLadder();
			}
			// 종료하기
			if (xIdx == 7) {
				break;
			}
		}
	}

	// 메뉴 설정하기
	void setMenu() {
		if (yIdx == 0) {
			menu = "아아";
		} else if (yIdx == 1) {
			menu = "뜨아";
		} else if (yIdx == 2) {
			menu = "김밥";
		} else if (yIdx == 3) {
			menu = "라면";
		} else if (yIdx == 4) {
			menu = "떡볶이";
		}
	}

	void run() {
		showLadder();
		xIdx = 0;
		yIdx = 0;
		// 사다리 선택하기
		System.out.print("번호를 선택하세요.[1~5]");
		yIdx = scan.nextInt()-1;
		
		// 사다리 이동하기
		moveLadder();
		
		setMenu();
		System.out.println("오늘의 메뉴는 "+menu+" 입니다.");

	}

}

public class day0923_메서드_Ladder {
	public static void main(String[] args) {

		LadderGame lg = new LadderGame();
		lg.run();

	}

}
