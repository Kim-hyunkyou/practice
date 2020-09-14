package java_test1;

class Product {
	String name;
	int price;
}

public class Test01 {
	public static void main(String[] args) {
		Product pr = new Product();
		pr.name = "감자깡";
		pr.price = 1000;
		// 배열
		Product[] arr = new Product[3];
		arr[0] = new Product();
		arr[1] = new Product();
		arr[2] = new Product();
		arr[0].price = 10;
		arr[1].price = 20;
		arr[2].price = 30;
		arr[0].name = "이만수";
		arr[1].name = "이영희";
		arr[2].name = "김철민";
		System.out.println(arr[1].name);

		Product temp = arr[1];
		System.out.println(temp.name);
	}
}
