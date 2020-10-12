package java_test1;

//2020-09-23
//15:55-16:04 10분"
import java.util.Scanner;

/*
 * # 2차원배열[삭제]
 * . 이름과 번호를 입력받아 삭제하기
 * 예)
 * 입력 : 철수	1
 * 삭제 : 김밥
 * 
 * 입력 : 철수 2
 * 삭제 : 바나나
 */

public class Array_Del {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[][] jang = { { "철수", "소고기" }, { "철수", "김밥" }, { "영희", "김치" }, { "철수", "바나나" }, { "철수", "새우깡" },
				{ "영희", "오징어" }, { "영희", "맛밤" } };
		// jang 배열 출력
		for (int i = 0; i < jang.length; i++) {
			System.out.print("(" + (i + 1) + ")");
			for (int j = 0; j < jang[i].length; j++) {
				System.out.print(jang[i][j]);
				if (j < 1)
					System.out.print(" : ");
			}
			System.out.println();
		}

		System.out.print("[삭제]이름을 입력하세요 : ");
		String name = scan.next();

		System.out.print("[삭제]할 인덱스를 입력하세요.");
		int idx = scan.nextInt() - 1;

		int delIdx = -1;
		
		int count = 0;
		for (int i = 0; i < jang.length; i++) {
			if (name.equals(jang[i][0])) {
				if (count == idx) {
					delIdx = i;
				}
				count++;
			}
		}

		String[][] temp = jang;
		jang = new String[temp.length - 1][2];

		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (i != delIdx) {
				jang[j] = temp[i];
				j++;
			}
		}

		for (int i = 0; i < jang.length; i++) {
			System.out.println("("+(i+1)+")"+jang[i][0]+" : "+jang[i][1]);
		}
	}

}
