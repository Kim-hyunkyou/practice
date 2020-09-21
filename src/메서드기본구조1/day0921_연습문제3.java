package 메서드기본구조1;

//2020-09-21
//
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class TestM3 {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);


	void printArray(int scores[]) {
		for (int i = 0; i < scores.length; i++) {
			scores[i] = ran.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(scores));
	}

	void printTotalAverage(int scores[]) {
		Double total = 0.0;
		Double avg = 0.0;

		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
			avg = total / scores.length;
		}
		System.out.println("total = " + total);
		System.out.println("avg = " + avg);
	}
 
	void printPassStudents(int scores[]) {
		int passCnt = 0;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > 60) {
				passCnt++;
			}
		}
		System.out.println("합격자수 = " + passCnt);
	}

	void printScores(int idx, int scores[]) {
		System.out.println((idx) + "번째 학생의 점수는 " + scores[idx - 1]);
	}

	void printIdx(int score, int scores[]) {
		int i = 0;
		for (int j = 0; j < scores.length; j++) {
			if (score == scores[j]) {
				i = j;
			}
		}
		System.out.println(score + "점은 " + (i + 1) + "번째 학생입니다.");
	}

	void printHakbunScore(int hakbuns[], int[] scores) {
		Scanner scan = new Scanner(System.in);
		System.out.println(Arrays.toString(hakbuns));
		System.out.println("학번을 입력하세요 : ");
		int value = scan.nextInt();
		boolean check = false;
		for (int i = 0; i < hakbuns.length; i++) {
			if (value == hakbuns[i]) {
				System.out.println(scores[i]);
				check = true;
			}
		}
		if (check == false) {
			System.out.println("없는학번입니다.");
		}
	}

	void printNumberOne(int[] hakbuns, int[] scores) {
		int max = scores[0];
		int maxindex = 0;

		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
				maxindex = i;
			}
		}
		System.out.println(max + " " + hakbuns[maxindex]);
	}

}

public class day0921_연습문제3 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = new int[5];
		TestM3 t3 = new TestM3();

		// 문제1) scores배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		t3.printArray(scores);;

		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		t3.printTotalAverage(scores);

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		t3.printPassStudents(scores);

		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점

		System.out.print("인덱스를 입력해주세요 :");
		int idx = scan.nextInt();
		t3.printScores(idx,scores);

		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		System.out.print("성적을 입력해주세요 : ");
		int score = scan.nextInt();
		t3.printIdx(score, scores);

		// 문제6) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 정답6) 학번 입력 : 1003 성적 : 45점
		t3.printHakbunScore(hakbuns , scores);

		// 문제7) 1등학생의 학번과 성적 출력
		// 정답7) 1004번(98점)
		t3.printNumberOne(hakbuns, scores);
	}

}
