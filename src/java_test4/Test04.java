package java_test4;

import java.util.Vector;

class Node{
	int num;
	void printNode() {
		System.out.print(num + "\t");
	}
}

class NodeManager{
	Vector<Node []> nodeList;
	int data[][];
	final int SIZE = 5;
	void dataInit() {
		data = new int[SIZE][SIZE];
		int num = 1;
		for(int i = 0;  i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				data[i][j] = num;
				//System.out.println(num);
				num += 1;
			}
		}
	}
	void dataShuffle() {}
	void nodeInit() {
		nodeList = new Vector<>();
		
		for(int i = 0; i < SIZE; i++) {
			Node [] temp = new Node[SIZE];
			for(int j = 0; j < SIZE; j++) {
				Node node = new Node();
				node.num = data[i][j];
				//System.out.println(node.num);
				temp[j] = node;
			}
			nodeList.add(temp);
		}		
	}
	
	void printNodeList() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				nodeList.get(i)[j].printNode();
			}
			System.out.println();
		}		
	}	
	void init() {	
		dataInit();
		dataShuffle();
		nodeInit();
		printNodeList();
	}
	
}

public class Test04 {
	public static void main(String[] args) {
		// 1to50 을만들어보세요
		NodeManager nm = new NodeManager();
		nm.init();
	}
}
