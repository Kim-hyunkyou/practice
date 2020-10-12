package File;

// # 파일 컨트롤러[1단계] : 벡터
//2020-09-14
//17:00-17:33 34분"
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileVector {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] vector = null;
		int count = 0;

		String fileName = "vector.txt";

		while (true) {

			System.out.println(Arrays.toString(vector));
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				// 배열이 0일 때 조건
				if (count == 0) {
					vector = new int[count + 1];
				} // 배열이 1개이상일 때 조건
				else if (count > 0) {
					//temp에 기존의 vector의 정보를 저장시켜놓는다.
					int[] temp = vector;
					//벡터의 크기를 하나 더 늘려주고
					vector = new int[count + 1];
					
					//벡터에 기존의 정보를 다시 입력해준다.
					for (int i = 0; i < count; i++) {
						vector[i] = temp[i];
					}
					//기존의 정보는 필요없어졌으니 초기화
					temp = null;
				}
				// 데이터 입력하고 vector배열에 저장해주기
				System.out.print("[추가] 데이터 입력 :");
				int data = scan.nextInt();

				vector[count] = data;
				count++;
			} // 인덱스를 입력하여 해당 인덱스 데이터와 인덱스 한개 줄이기
			else if (sel == 2) {
				System.out.print("[삭제] 인덱스 입력 :");
				int delIdx = scan.nextInt();

				if (count - 1 < delIdx || delIdx < 0) {
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				if (count == 1) {
					vector = null;
				} else if (count > 1) {
					int[] temp = vector;
					vector = new int[count - 1];
					// 인덱스를 입력한 값빼고 새로 저장해주기
					int j = 0;
					for (int i = 0; i < count; i++) {
						if (i != delIdx) {
							vector[j] = temp[i];
							j++;
						}
					}
					// temp 초기화
					temp = null;
				}
				count--;
			} else if (sel == 3) {
				String data = "";
				if (count > 0) {
					for (int i = 0; i < count; i++) {
						data += vector[i];
						data += "\n";
					}
					data = data.substring(0, data.length() - 1);

					FileWriter fw = null;
					try {
						fw = new FileWriter(fileName);
						fw.write(data);

						fw.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("[메세지]저장할 데이터가 없습니다.");
				}
			} else if (sel == 4) {
				String data = "";
				File file = new File(fileName);

				if (file.exists()) {
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
						vector = new int[temp.length];

						for (int i = 0; i < temp.length; i++) {
							vector[i] = Integer.parseInt(temp[i]);
						}
						fr.close();
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			} else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}
}
