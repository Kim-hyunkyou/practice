package File;

//2020-09-14
//14:00-16:07 8분"
import java.io.FileWriter;

//# 파일 저장하기 : 연습문제1
public class FileSave {
	public static void main(String[] args) {

		// 김철수/20,이만수/30,이영희/40

		// 이름 배열
		String[] names = { "김철수", "이만수", "이영희" };
		// 나이 배열
		int[] ages = { 20, 30, 40 };

		// file 이름 설정 "fileTest01.txt"
		String fileName = "fileTest01.txt";
		// data 생성
		String data = "";

		// 데이터 내 내용 삽입해주기
		int size = names.length;
		for (int i = 0; i < size; i++) {
			data+=names[i];
			data+="/";
			data+=ages[i];
			if(i!=size-1) {
				data+=",";
			}
		}
		// 데이터 내용 출력
		System.out.println(data);
		// 데이터 저장하기
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
