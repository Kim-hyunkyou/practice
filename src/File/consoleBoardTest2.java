package File;

//2020-09-16
//16:10-16:51 42분"
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * # 콘솔 게시판
 * 1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다.
 * 2. 현재 페이지 번호에 해당되는 게시글만 볼 수 있다.
 * 3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다.
 * 4. 게시글을 추가하고 삭제할 때마다 파일입출력을 통해 데이터가 바로바로 저장된다.
 * 5. 실행시 저장되어 있는 파일이 존재한다면, 바로 파일을 불러오도록 설계한다.
 */

public class consoleBoardTest2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "board3.txt";

		String[][] board = null;
		int count = 0; // 전체 게시글 수
		int pageSize = 5; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호

		File file = new File(fileName);
		if (file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;

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
				if (count > 0) {
					String[] info = data.split("\n");
					board = new String[count][2];

					for (int i = 0; i < info.length; i++) {
						String[] temp = info[i].split("/");
						board[i][0] = temp[0];
						board[i][1] = temp[1];

					}
				}
			} catch (Exception e) {

			} finally {
				if (fr != null) {
					try {
						fr.close();
					} catch (Exception e) {

					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (Exception e) {

					}
				}
			}
		}
		while (true) {
			pageCount = count / pageSize;
			if (count % pageSize > 0) {
				pageCount++;
			}
			startRow = (curPageNum - 1) * pageSize;
			endRow = startRow + pageSize;
			if (endRow > count) {
				endRow = count;
			}
			System.out.println("게시판 (" + count + ")개");
			System.out.println("현재 페이지 : " + curPageNum);

			for (int i = startRow; i < endRow; i++) {
				if (board != null) {
					System.out.println("(" + (i + 1) + ")" + board[i][0]);
				}
			}
			System.out.println();
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");

			int choice = scan.nextInt();

			if (choice == 1) {
				if (curPageNum == 1) {
					continue;
				}
				curPageNum--;
			} else if (choice == 2) {
				if (curPageNum >= pageCount) {
					continue;
				}
				curPageNum++;
			} else if (choice == 3) {
				if (count == 0) {
					board = new String[count + 1][2];
				} else if (count > 0) {
					String temp[][] = board;

					board = new String[count + 1][2];
					for (int i = 0; i < count; i++) {
						board[i] = temp[i];
					}
					temp = null;
				}

				System.out.print("게시물 제목을 입력하세요:");
				board[count][0] = scan.next();
				System.out.print("게시물 내용을 입력하세요:");
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
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (fw != null) {
						try {
							fw.close();
						} catch (Exception e) {

						}
					}
				}

			} else if (choice == 4) {
				System.out.print("삭제할 게시글 번호를 입력하세요.");
				int num = scan.nextInt();
				num--;

				if (endRow <= num || startRow > num) {
					System.out.println("해당 위치의 게시글을 삭제할 수 없습니다.");
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

					FileWriter fw = null;
					try {
						fw = new FileWriter(fileName);
						fw.write(data);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (fw != null) {
							try {
								fw.close();
							} catch (Exception e) {
							}
						}
					}
				}
			} else if (choice == 5) {
				System.out.print("확인할 게시물의 번호를 입력하세요	:");
				int num = scan.nextInt();
				num--;

				if (startRow <= num && num < endRow) {
					System.out.println("내용 = " + board[num][1]);
				}
			}
		}
	}
}
