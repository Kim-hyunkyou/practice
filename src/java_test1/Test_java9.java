package java_test1;

import java.util.Arrays;
import java.util.Scanner;

public class Test_java9 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int arr[] = { 10, 20, 30, 40, 50 };
		int b[] = new int[5];

		// 숫자를 5개 입력받고 arr 배열안에 입력한값이 있을때마다
		// b배열안에 해당 값의 인덱스를 차례대로 저장할려고 한다.
		// 조건) 만약에 입력한 숫자가 arr 에 없으면 인덱스 대신 -1 저장
		int run = 0;
		int idx = 0;
		while (run < 5) {
			System.out.print((run + 1) + "번째 숫자입력 :");
			int num = scan.nextInt();
			
			int check = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == num) {
					idx = i;
					check=1;
				} 
			}
			if(check==1) {
				b[run] = idx;
			}else {
				b[run] = -1;
			}
			run++;
		}
		System.out.println(Arrays.toString(b));

		// 예) 10, 20, 10, 1, 50
		// b ={0,1,0,-1,4}

		// 예) 30, 40, 1, 10, 2

		// b = {2,3,-1,0,-1}
		scan.close();
	}
}
