package File;

//2020-09-15
//19:00-19:42 43분"(정답보고 공부)
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * # 콘솔 게시판
 * 1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다.
 * 2. 현재 페이지 번호에 해당되는 게시글만 볼 수 있다.
 * 3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다.
 * 4. 게시글을 추가하고 삭제할 때마다 파일입출력을 통해 데이터가 바로바로 저장된다.
 * 5. 실행시 저장되어 있는 파일이 존재한다면, 바로 파일을 불러오도록 설계한다.
 */

public class consoleBoard {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "board.txt";

		String[][] board = null;
		int count = 0; // 전체 게시글 수
		int pageSize = 5; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호

		// 파일 불러오기
		File file = new File(fileName);
		// 파일이 존재 하면 파일 불러와주기
		if (file.exists())
		{
			FileReader fr = null;
			BufferedReader br = null;

			// 예외처리 해서 오류나는 부분 해결해주기
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				String size = br.readLine();
				count = Integer.parseInt(size);

				String data = "";
				for (int i = 0; i < count; i++) {
					data += br.readLine();
					if (i != count - 1) {
						data += "\n";
					}
				}

				// 게시판수가 생성되었을때
				if (count > 0) {
					// 내용을 라인으로 구분하여 board에 저장해주기
					String[] info = data.split("\n");
					board = new String[count][2];

					// board에
					for (int i = 0; i < info.length; i++) {
						String temp[] = info[i].split("/");
						board[i][0] = temp[0];
						board[i][1] = temp[1];
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fr != null) {
					try {
						fr.close();
					} catch (IOException e) {
					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {

					}
				}
			}
		}
		// 게시글 수 & 페이지 만들어주기
		while (true)

		{
			// 한페이지에 보여줄수 있는 게시물 수만큼 페이지를 늘려준다
			pageCount = count / pageSize;
			if (count % pageSize > 0) {
				pageCount++;
			}
			// 첫번째 페이지에
			startRow = (curPageNum - 1) * pageSize; // 0부터 시작
			endRow = startRow + pageSize; // 미만
			if (endRow > count) {
				endRow = count;
			}

			System.out.println("게시판 (" + count + ")개");
			System.out.println("현재 페이지: " + curPageNum);
			for (int i = startRow; i < endRow; i++) {
				System.out.println("(" + (i + 1) + ")" + board[i][0]);
			}
			System.out.println();
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");

			int choice = scan.nextInt();
			// 현재 페이지가 1일 때를 제외하고는 감소 시켜준다
			if (choice == 1) {
				if (curPageNum == 1) {
					continue;
				}
				curPageNum--;
				// 현재 페이지가 존재하는 페이지수를 넘어 가지 않고서는 증가시켜준다
			} else if (choice == 2) {
				if (curPageNum >= pageCount) {
					continue;
				}
				curPageNum++;
				// 게시물 증가시켜주기
			} else if (choice == 3) {
				// 게시물이 없다면 board의 배열을 1개 늘려준다
				// 제목과 내용만 저장하면 되니까 2배열은 2로 고정.
				if (count == 0) {
					board = new String[count + 1][2];
				} else if (count > 0) {
					// 게시물이 존재한다면 temp배열에 내용을 저장해주고 board 배열을 증가 시켜준다
					String[][] temp = board;

					board = new String[count + 1][2];
					for (int i = 0; i < count; i++) {
						board[i] = temp[i];
					}
					temp = null;
				}
				System.out.print("게시글 제목을 입력하세요 :");
				board[count][0] = scan.next();

				System.out.print("게시글 내용을 입력하세요 :");
				board[count][1] = scan.next();

				count++;

				String data = "";
				data += count;
				data += "\n";
				for (int i = 0; i < count; i++) {
					data += board[i][0];
					data += "/";
					data += board[i][1];
					if (i != count - 1) {
						data += "\n";
					}
				}
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fw != null) {
						try {
							fw.close();
						} catch (IOException e) {

						}
					}
				}

			} else if (choice == 4) {
				System.out.print("삭제할 게시글 번호를 입력하세요 :");
				int num = scan.nextInt();
				num--;

				if (endRow <= num || num < startRow) {
					System.out.println("해당 위치의 게시글은 삭제할 수 없습니다.");
					continue;
				}
				if (count == 1) {
					board = null;
				} else if (count > 1) {
					String[][] temp = board;

					board = new String[count - 1][2];
					int j = 0;
					for (int i = 0; i < count; i++) {
						if (i != num) {
							board[j] = temp[i];
							j++;
						}
					}
					temp = null;
				}
				count--;

				String data = "";
				data += count;
				data += "\n";

				for (int i = 0; i < count; i++) {
					data += board[i][0];
					data += "/";
					data += board[i][1];
					if (i != count - 1) {
						data += "\n";
					}
				}

				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fw != null) {
						try {
							fw.close();
						} catch (IOException e) {
						}
					}
				}

			} else if (choice == 5) {
				System.out.print("게시글 번호를 입력하세요:");
				int num = scan.nextInt();
				num--;

				if (startRow <= num && num < endRow) {
					System.out.println("내용 = " + board[num][1]);
				}
			}
		}
	}

}
