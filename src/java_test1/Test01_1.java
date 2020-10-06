package java_test1;

import java.util.Arrays;

class Card {
	static int width = 120;
	static int height = 300;
	int num;
	String shape;
}

public class Test01_1 {
	public static void main(String[] args) {
		System.out.println(Card.width);
		Card c = new Card();
		Card c1 = new Card();

		Card[] arr = new Card[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = new Card();
		}
		System.out.println(Arrays.toString(arr));
	}

}
