package java_test1;

import java.util.Arrays;
import java.util.Scanner;

public class Test_java {

	public static void main(String[] args) {

		// 문제) 시험점수3개를 입력받고 학점출력
		// 조건 1) 3과목의 평균을 가지고 점수를 매긴다.
		// 조건 2) 3과목의 평균이 100~90 ==> A
		// 조건 3) 3과목의 평균이 89~80 ==> B
		// 조건 4) 3과목의 평균이 79~70 ==> C
		// 조건 5) 69이하 ==> 재시험
		// 추가조건) 각점수대별로 끝자리가 7점 이상은 + 가붙는다.
		// 예) 98 ==> A+
		// 예) 89 ==> B+
		// 예) 79 ==> C+
		Scanner scan = new Scanner(System.in);
		int score[] = new int[3];
		String grade[] = new String[3];

		for (int i = 0; i < score.length; i++) {
			System.out.print("[성적" + (i + 1) + "] 입력: ");
			score[i] = scan.nextInt();
		}
		for (int i = 0; i < score.length; i++) {
			if (90 <= score[i] && score[i] <= 100) {
				if (score[i] % 10 >= 7) {
					grade[i] = "A+";
				} else {
					grade[i] = "A";
				}
			} else if (80 <= score[i] && score[i] <= 89) {
				if (score[i] % 10 >= 7) {
					grade[i] = "B+";
				} else {
					grade[i] = "B";
				}
			} else if (70 <= score[i] && score[i] <= 79) {
				if(score[i]%10>=7) {
					grade[i] = "C+";
				}else {
					grade[i] = "C";
				}
			} else if (score[i] <= 69) {
				grade[i] = "재시험";
			}
		}
		System.out.println(Arrays.toString(score));
		System.out.println(Arrays.toString(grade));
	}

}
