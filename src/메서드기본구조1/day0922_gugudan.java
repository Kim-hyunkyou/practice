package 메서드기본구조1;

//2020-09-22
//메서드 구구단_복습
//17:45-17:50	6분"
import java.util.Scanner;

class Gugudan {
	Scanner scan = new Scanner(System.in);

	void calculator() {
		System.out.print("a 입력:");
		int a = scan.nextInt();
		System.out.print("b 입력:");
		int b = scan.nextInt();

		System.out.println(a + " * " + b + " = " + (a * b));
	}

	void gugudan() {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
}

public class day0922_gugudan {
	public static void main(String[] args) {

		Gugudan gugu = new Gugudan();
		gugu.calculator();
		gugu.gugudan();

	}
}
