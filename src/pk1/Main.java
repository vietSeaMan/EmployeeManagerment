package pk1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//call Operation class
		Operation op = new Operation();
		//Create a new binary Search tree to store employee information
		BST_Employee empTree = new BST_Employee();
		//Path for graph file
		String path = "E:\\ca nhan\\learn programing\\Cau truc du lieu va giai thuat\\ASM3\\Graph.txt";
		//Call File class
		File myFile = new File(path);
		//Create a new arrayList(2D array) to store weight of edge 
		ArrayList<ArrayList<Integer>> myArr = new ArrayList<ArrayList<Integer>>();
		//Get data from file
		myFile.getDataFromFile(myArr);
		//Create a new graph
		Graph myGraph = new Graph(myArr.get(0).size());
		
		//update vertexes and edges into graph
		for(int i=0; i<myArr.get(0).size(); i++) {
			for(int j=0; j<myArr.get(0).size(); j++) {
				if(myArr.get(i).get(j)!=9999 && myArr.get(i).get(j)!=0) {
					myGraph.addEdge(i, j, myArr.get(i).get(j));
				}
			}
		}
		
		//Main function
		int option;
		do {
			op.displayMenu();
			option = op.inputInt(sc);
			if(option == 1) {
				//1. Add a new employee in to Binary Search Tree (BST)
				op.addNewEmployee(empTree);
			}
			else if(option == 2) {
				//2. In-order Traverse BST 
				op.displayByInOrder(empTree);
			}
			else if(option == 3) {
				//3. Breadth-First Traversal(BFT)
				op.displayByBeadthFirst(empTree);	
			}
			else if(option == 4) {
				//4. Find Employee's information by ID
				op.findById(empTree);
			}
			else if(option == 5) {
				//5. Delete an Employee by ID
				op.removeById(empTree);
			}
			else if(option == 6) {
				//6. Balance Binary Search Tree
				op.balanceTree(empTree);
			}
			else if(option == 7) {
				//7. Depth-First Graph Traversal (DFT)
				op.printVertex('A', myGraph);
			}
			else if(option == 8) {
				//8. Find a shortest from A to F city with Dijkstra algorithms
				op.findShortestWay('A', 'F', myGraph);
			}
		}while(option != 0);
		
	}

}
