package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Board {
	Scanner scan = new Scanner(System.in);

	String fileName = "";
	String board[][] = null;

	int pageCount = 0; // 전체 페이지 수
	int pageSize = 5; // 한페이지당 5개씩
	int count = 0; // 전체 게시글수
	int curPageNum = 1; // 현재 페이지
	int startRow = 0;
	int endRow = 0;

	void makeRull() {
		pageCount = count / pageSize;
		if (count % pageSize > 0) {
			pageCount++;
		}
		startRow = (curPageNum - 1) * pageSize; // 0부터 시작
		endRow = startRow + pageSize; // 미만
		if (endRow > count) {
			endRow = count;
		}
	}

	void nameWrite(String name) {
		this.fileName = name;
	}

	void writeFile() {
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
	}

	void agoBoard() {
		while (true) {
			if (curPageNum == 1) {
				continue;
			}
			curPageNum--;
			break;
		}
	}

	void afterBoard() {
		while (true) {
			if (curPageNum >= pageCount) {
				continue;
			}
			curPageNum++;
			break;
		}
	}

	void createBoard() {
		if (count == 0) {
			board = new String[count + 1][2];
		} else if (count > 0) {
			String[][] temp = board;

			board = new String[count + 1][2];
			for (int i = 0; i < count; i++) {
				board[i] = temp[i];
			}
			temp = null;
		}
		System.out.print("게시글 제목을 입력하세요.");
		board[count][0] = scan.next();
		System.out.print("게시글 내용을 입력하세요.");
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
	}

	void delBoard() {

		while (true) {
			System.out.print("삭제할 게시글 번호를 입력하세요");
			int num = scan.nextInt() - 1;
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
			break;
		}
	}

	void showInfoBoard() {
		System.out.print("게시글 번호를 입력하세요");
		int num = scan.nextInt() - 1;

		if (startRow <= num && num < endRow) {
			System.out.println("내용 = " + board[num][1]);
		}
	}

	void run() {
		
		while (true) {
			makeRull();
			writeFile();
			
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
				agoBoard();
			} else if (choice == 2) {
				afterBoard();
			} else if (choice == 3) {
				createBoard();
			} else if (choice == 4) {
				delBoard();
			} else if (choice == 5) {
				showInfoBoard();
			}
		}
	}

}

public class consoleBoardMaking {
	public static void main(String[] args) {
		Board board = new Board();
		board.nameWrite("board.txt");
		board.run();
	}

}
