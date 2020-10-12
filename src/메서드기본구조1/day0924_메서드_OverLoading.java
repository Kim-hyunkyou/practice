package 메서드기본구조1;

class OverLoading {

	int id(int a, int b) {
		return a * b;
	}

	int id(int a) {
		return a * a;
	}
	
	String id(String a) {
		return a;
	}

}

public class day0924_메서드_OverLoading {
	public static void main(String[] args) {
		OverLoading ol = new OverLoading();

		System.out.println(ol.id(3, 5));
		System.out.println(ol.id("김"));
		System.out.println(ol.id(5));
	}
}
