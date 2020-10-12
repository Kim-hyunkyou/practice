package ClassArray;

import java.util.Scanner;

class Tic {
	int[] line = new int[3];

	void printLine() {
		for (int i = 0; i < 3; i++) {
			if (line[i] == 0) {
				System.out.print("[ ]");
			} else if (line[i] == 1) {
				System.out.print("[o]");
			} else if (line[i] == 2) {
				System.out.print("[x]");
			}
		}
		System.out.println();
	}
}

public class classArray5 {
	public static void main(String[] args) {
		boolean run = true;
		Tic[] ticList = new Tic[3];
		for (int i = 0; i < ticList.length; i++) {
			ticList[i] = new Tic(); // 제일많이 실수.
		}
		Scanner scan = new Scanner(System.in);
		boolean turn = true;
		while (run) {
			for (int i = 0; i < ticList.length; i++) {
				ticList[i].printLine();
			}
			System.out.println();
			System.out.println("y (0~2)를 입력하세요 >> ");
			int y = scan.nextInt();
			System.out.println("x (0~2)를 입력하세요 >> ");
			int x = scan.nextInt();
			if (turn == true && ticList[y].line[x] == 0) {
				ticList[y].line[x] = 1;
				turn = false;
			} else {
				ticList[y].line[x] = 2;
				turn = true;
			}
		}
	}

}
