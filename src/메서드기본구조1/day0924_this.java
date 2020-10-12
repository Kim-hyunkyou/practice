package 메서드기본구조1;

class MyTest {
	int a;
	String name;
	int score;

	void test() {
		int a = 10; // test()안의 "a"와 함수밖에있는 a 는 서로 다른a 이다.
		// 1) 색깔로 구분가능하다. 갈색과 파란색
		// 2) 서로를 구분짓기 위해서는 this.를 붙여야한다.
		// 3) 원래 클래스 함수밖에 있는 변수들을
		// 함수안에서 사용할때는 this.를 붙이는게 원칙이고,
		// 다만 생략가능하다만 명확성을 위해 붙이는게 좋다.
		this.a = 100;
		System.out.println("------------------");
		System.out.println(a);
		System.out.println(this.a);
		System.out.println("------------------");

		this.name = "aaa";
		this.score = 100;
	}
}

public class day0924_this {
	public static void main(String[] args) {
		MyTest t = new MyTest();
		t.test();
		System.out.println(t.a);
		System.out.println();

	}
}
