package File;

import java.io.FileWriter;

public class FileSave2 {
	public static void main(String[] args) {

		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000

		// 이름 배열 만들기
		String[] names = { "momk", "megait", "github" };
		// 패스워드 배열 만들기
		String[] pws = { "1111", "2222", "3333" };
		// 소유한 돈의 배열 만들기
		int[] moneys = { 20000, 30000, 40000 };

		// 파일이름 만들기 "fileTest02.txt"
		String fileName = "fileTest02.txt";

		// 저장할 데이터 공간 만들어주기
		String data = "";

		// 데이터 내용 삽입
		int size = names.length;
		for (int i = 0; i < size; i++) {
			data += names[i];
			data += "/";
			data += pws[i];
			data += "/";
			data += moneys[i];
			data += "\n";
		}

		// 마지막 글자 삭제
		data = data.substring(0, data.length() - 1);
		System.out.println(data);

		// 파일저장하기
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
