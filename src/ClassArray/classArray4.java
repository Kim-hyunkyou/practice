package ClassArray;

import java.util.Scanner;

class Seat {
	//예약여부 체크해주기
	boolean check;

	//예약하면 true => ■ 예약되지 않은 자리는 =>□
	void showData() {
		if (check == true) {
			System.out.print("■ ");
		} else {
			System.out.print("□ ");
		}
	}
}

public class classArray4 {
	public static void main(String[] args) {
		boolean run = true;
		Seat[] seatList = new Seat[8];
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat();
		}
		Scanner scan = new Scanner(System.in);
		while (run) {
			for (int i = 0; i < seatList.length; i++) {
				seatList[i].showData();
			}
			System.out.println();
			System.out.println("번호를 입력하세요 >> ");
			int sel = scan.nextInt();
			if (seatList[sel].check == false) {
				seatList[sel].check = true;
			}
		}

	}

}
