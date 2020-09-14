package java_test1;

import java.util.Scanner;

class User {
	String id;
	int money;
}

public class ClassArrayEx01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int max = 100;
		User[] user = new User[max];
		for (int i = 0; i < 100; i++) {
			user[i] = new User();
		}
		System.out.println(user);
		System.out.println(user[0]);
		System.out.println(user[1]);

		user[0].id = "aaaa";
		user[0].money = 1000;

		user[1].id = "bbbb";
		user[1].money = 2000;

		int count = 2;

		for (int i = 0; i < count; i++) {
			System.out.println(user[i].id + " " + user[i].money);
		}

		User temp = user[1];
		temp.id = "ccccc";
		System.out.println("=====================================");
		for (int i = 0; i < count; i++) {
			System.out.println(user[i].id + " " + user[i].money);
		}

		scan.close();
	}

}
