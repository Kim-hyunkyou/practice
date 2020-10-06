package java_test1;

import java.util.Arrays;
import java.util.Scanner;

public class Test_java8 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int arr[] = { 0, 2, 0, 3, 4, 0, 0, 5, 0 };
		// 아래 번호를 입력받고 각방향 으로 0 이아닌숫자를 모으시요.
		// 1)left 2)right 3)reverse
		System.out.print("[1]Left [2]Right [3]Reverse");
		int dir = scan.nextInt();

		if (dir == 1) {
			int temp1[] = new int[arr.length];
			int j = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					temp1[j] = arr[i];
					j++;
				}
			}
			System.out.println(Arrays.toString(temp1));
		} else if (dir == 2) {
			int temp1[] = new int[arr.length];
			int cnt = 0;

			for (int i = 0; i < temp1.length; i++) {
				if (arr[i] == 0) {
					cnt++;
				}
			}
			int j = cnt;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					if (j < temp1.length) {
						temp1[j] = arr[i];
						j++;
					}
				}
			}
			System.out.println(Arrays.toString(temp1));
		} else if (dir == 3) {
			int temp1[] = new int[arr.length];
			int j = arr.length - 1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					temp1[j] = arr[i];
					j--;
				}
			}
			System.out.println(Arrays.toString(temp1));
		}

		// 예) 1) left ==> arr = {2,3,4,5,0,0,0,0,0};
		// 예) 1) right ==> arr = {0,0,0,0,0,2,3,4,5};
	}
}
