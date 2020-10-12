package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//# 파일 로드하기 : 연습문제
public class FileRoad {
	public static void main(String[] args) {

		// ids 배열 생성
		String[] ids = null;
		// pws 배열 생성
		String[] pws = null;
		// moneys 배열 생성
		int[] moneys = null;
		// 파일 이름 = "fileTest02.txt"
		String fileName = "fileTest02.txt";

		// 파일 생성
		File file = new File(fileName);
		// 파일 내용 저장할 공간 만들기
		int size = 0;
		String data = "";

		// 파일이 존재 한다면 파일 불러주기
		if (file.exists()) {
			// if문안에 파일로드 문 만들어주기
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
				data = data.substring(0, data.length() - 1);

				String[] temp = data.split("\n");
				size = temp.length;

				ids = new String[size];
				pws = new String[size];
				moneys = new int[size];
				// info배열은 temp배열을 "/"로 구분하여 초기화된 배열에 넣어준다
				for (int i = 0; i < temp.length; i++) {
					String[] info = temp[i].split("/");
					ids[i] = info[0];
					pws[i] = info[1];
					moneys[i] = Integer.parseInt(info[2]);
				}
				// 구분된 배열을 출력해준다.
				for (int i = 0; i < temp.length; i++) {
					System.out.println(ids[i] + ":" + pws[i] + ":" + moneys[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
